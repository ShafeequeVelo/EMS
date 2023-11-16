package com.velociter.ems;

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

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.helper.RoleOperation;
import com.velociter.ems.helper.UUIDGenerator;
import com.velociter.ems.pojo.*;

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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

		String address = request.getParameter("address1").toString() + " " + request.getParameter("address2").toString()
				+ " " + request.getParameter("address3").toString();

		addressPojo.setCity(request.getParameter("City"));
		addressPojo.setZipCode(request.getParameter("Zipcode"));
		addressPojo.setState(request.getParameter("State"));
		addressPojo.setCountry(request.getParameter("Country"));

		String query = "INSERT INTO employee (fname, lname, EmpID, age, gender, phone, email, uName, password, DEPARTMENTID, ROLEID, MANAGERID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		Connection connection = DatabaseConnection.getConnection();
		
		PreparedStatement prepObj = null;
		
		PreparedStatement prepObj2 = null;
		
		
		if (rp.getManagerID() == null)

		{

			query = "INSERT INTO Employee (fName, lName, EmpID, Age, Gender , Phone, Email, uName, Password, DepartmentID, RoleID ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		}

		try {
			prepObj = connection.prepareStatement(query);

			prepObj.setString(1, rp.getfName());
			prepObj.setString(2, rp.getlName());
			prepObj.setString(3, rp.getEmpID());
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
				int i = preparedStatement.executeUpdate();
				if (i > 0) {
					System.out.println("Manager Inseted");
				} else {
					System.out.println("Manager not Inseted");
				}
			}

			prepObj2 = connection.prepareStatement(("insert into address("
					+ "ADDRESSID,address,city,zipcode,state,country,EmpID" + ") " + "values(?,?,?,?,?,?,?)"));

			prepObj2.setString(1, uuid.getID());
			prepObj2.setString(2, address);
			prepObj2.setString(3, addressPojo.getCity());
			prepObj2.setString(4, addressPojo.getZipCode());
			prepObj2.setString(5, addressPojo.getState());
			prepObj2.setString(6, addressPojo.getCountry());
			prepObj2.setString(7, rp.getEmpID());

			prepObj2.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DatabaseConnection.closeCon(prepObj, connection);
			DatabaseConnection.closeCon(prepObj2, connection);
		}
		request.setAttribute("checkIfRegistired", "true");
		request.getRequestDispatcher("ControllerServlet?submit=RegisterServlet").forward(request, response);

	}

}
