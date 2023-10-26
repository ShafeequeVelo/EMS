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
import com.velociter.ems.pojo.*;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//public String registerServletSubmit = "Register";       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		RegistrationPojo rp = new RegistrationPojo();
		
		rp.setfName(request.getParameter("fName"));
		rp.setlName(request.getParameter("lName"));
		rp.setEmpID(request.getParameter("empid"));
		rp.setAge(Short.parseShort((request.getParameter("age"))));
		rp.setGender(request.getParameter("gender"));
		rp.setPhone(request.getParameter("phone"));
		rp.setEmail(request.getParameter("email"));
		rp.setuName(request.getParameter("uName"));
		rp.setPassword(request.getParameter("password"));
		
		AddressPojo addressPojo = new AddressPojo();
		addressPojo.setAddress1(request.getParameter("address1"));
		addressPojo.setAddress2(request.getParameter("address2"));
		addressPojo.setAddress3(request.getParameter("address3"));
		addressPojo.setCity(request.getParameter("city"));
		addressPojo.setZipCode(request.getParameter("zipcode"));
		addressPojo.setState(request.getParameter("state"));
		addressPojo.setCountry(request.getParameter("country"));
		
		DatabaseConnection dbConnection = new DatabaseConnection();		

		Connection connection = dbConnection.getConnection();
		
		try {
			PreparedStatement prepObj = connection.prepareStatement(
					("insert into employee("
							+ "fname,lname,empID,age,gender,phone,email,uName,password"
							+ ") "
							+ "values(?,?,?,?,?,?,?,?,?)")
					);
			
			prepObj.setString(1, rp.getfName());
			prepObj.setString(2, rp.getlName());
			prepObj.setString(3, rp.getEmpID());
			prepObj.setShort(4, rp.getAge());
			prepObj.setString(5, rp.getGender());
			prepObj.setString(6, rp.getPhone());
			prepObj.setString(7, rp.getEmail());
			prepObj.setString(8, rp.getuName());
			prepObj.setString(9, rp.getPassword());
			
		      prepObj.executeQuery();
		      
		 PreparedStatement prepObj2 = connection.prepareStatement(
				 ("insert into address("
					+ "address1,address2,address3,city,zipcode,state,country,EmpID"
					+ ") "
					+ "values(?,?,?,?,?,?,?,?)")
			);
			
		 prepObj2.setString(1, addressPojo.getAddress1());
		 prepObj2.setString(2, addressPojo.getAddress2());
		 prepObj2.setString(3, addressPojo.getAddress3());
		 prepObj2.setString(4, addressPojo.getCity());
		 prepObj2.setString(5, addressPojo.getZipCode());
		 prepObj2.setString(6, addressPojo.getState());
		 prepObj2.setString(7, addressPojo.getCountry());
		 prepObj2.setString(8, rp.getEmpID());
		 
		 prepObj2.executeQuery();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//request.getRequestDispatcher("Login.jsp").forward(request, response);
		
//	request.setAttribute("registerServletSubmit", "RegisterServlet");
		//request.removeAttribute("submit");
		request.getRequestDispatcher("ControllerServlet?submit=RegisterServlet").forward(request, response);
		
	}

}
