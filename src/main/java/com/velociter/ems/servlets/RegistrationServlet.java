package com.velociter.ems.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.helper.*;
import com.velociter.ems.pojo.AddressPojo;
import com.velociter.ems.pojo.ManagerPojo;
import com.velociter.ems.pojo.RegistrationPojo;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// public String registerServletSubmit = "Register";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<ManagerPojo> managers = new ArrayList<ManagerPojo>();
		RegistrationPojo rp = new RegistrationPojo();
		UUIDGenerator uuid = new UUIDGenerator();
		
		rp.setfName(request.getParameter("fName"));
		rp.setlName(request.getParameter("lName"));
		rp.setEmpID(request.getParameter("empid"));
		rp.setAge(Short.parseShort((request.getParameter("age"))));
		rp.setGender(request.getParameter("gender"));
		rp.setPhone(request.getParameter("phone"));
		rp.setEmail(request.getParameter("email"));
		rp.setuName(request.getParameter("uName"));
		rp.setPassword(request.getParameter("password"));
		rp.setDepartmentID(request.getParameter("DepartmentID"));
		rp.setRoleID(request.getParameter("RoleID"));
		rp.setManagerID(request.getParameter("ManagerID"));
		
		AddressPojo addressPojo = new AddressPojo();
		String address = request.getParameter("address1").toString()+ " " + 
				request.getParameter("address2").toString()+ " " + request.getParameter("address3");
		
		addressPojo.setCity(request.getParameter("city"));
		addressPojo.setZipCode(Integer.parseInt(request.getParameter("zipcode")));
		addressPojo.setState(request.getParameter("state"));
		addressPojo.setCountry(request.getParameter("country"));
		
		String query = "INSERT INTO employee (EmpID, fname, lname, age, gender, phone, email, uName, password, DEPARTMENTID, ROLEID, MANAGERID) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		if(rp.getManagerID()== null)
		{
			query = "INSERT INTO Employee (EmpID, fName, lName, Age, Gender , Phone, Email, uName, Password, DepartmentID, RoleID ) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		}
			

		Connection connection = DatabaseConnection.getConnection();
		
		try {
			PreparedStatement prepObj = connection.prepareStatement(query);
			
			prepObj.setString(1, rp.getEmpID());
			prepObj.setString(2, rp.getfName());
			prepObj.setString(3, rp.getlName());
			prepObj.setShort(4, rp.getAge());
			prepObj.setString(5, rp.getGender());
			prepObj.setString(6, rp.getPhone());
			prepObj.setString(7, rp.getEmail());
			prepObj.setString(8, rp.getuName());
			prepObj.setString(9, rp.getPassword());
			prepObj.setString(10, rp.getDepartmentID());
			prepObj.setString(11, rp.getRoleID());
			if (rp.getManagerID() != null) {
				prepObj.setString(12, rp.getManagerID());
			}
			
		      prepObj.executeQuery();
		      
		      RoleOperation roleOperation = new RoleOperation();
		      String roleName = roleOperation.getRoleByID(rp.getRoleID()).getRoleName();
				if (roleName.equals("MANAGER")) {
					PreparedStatement preparedStatement = connection
							.prepareStatement("insert into manager (managerID) values(?)");
					preparedStatement.setString(1, rp.getEmpID());
					ResultSet rs = preparedStatement.executeQuery();
					
		      }
		      
		 PreparedStatement prepObj2 = connection.prepareStatement(
				 ("insert into Address( addressid,address,country,state,city,zipcode,EmpID) values(?,?,?,?,?,?,?)")
			);
			
		 prepObj2.setString(1,uuid.getID());
		 prepObj2.setString(2, address);
		 prepObj2.setString(3, addressPojo.getCountry());
		 prepObj2.setString(4, addressPojo.getState());
		 prepObj2.setString(5, addressPojo.getCity());
		 prepObj2.setInt(6, addressPojo.getZipCode());
		 
		
		 prepObj2.setString(7, rp.getEmpID());
		 
		 prepObj2.executeQuery();

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//request.getRequestDispatcher("Login.jsp").forward(request, response);
		
		//request.setAttribute("checkIfRegistered", "true");
		//request.removeAttribute("submit");
		request.getRequestDispatcher("ControllerServlet?submit=RegisterServlet").forward(request, response);
		
	}

}
