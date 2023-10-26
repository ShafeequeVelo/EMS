package com.velociter.ems;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.RegistrationPojo;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		// TODO Auto-generated method stub
		authentication(request, response);
	}

	public void authentication(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RegistrationPojo rp = new RegistrationPojo();
		rp.setuName(request.getParameter("uName"));
		rp.setPassword(request.getParameter("password"));

		DatabaseConnection dbconnection = new DatabaseConnection();

		Connection connection = dbconnection.getConnection();
		try {

			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM employee WHERE uName = ? AND password = ?");
			statement.setString(1, rp.getuName());
			statement.setString(2, rp.getPassword());

			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				// Successful login - redirect to a secure page
				String fName = resultSet.getString("fName");
				String lName = resultSet.getString("lName");
				String empID = resultSet.getString("empID");
				short age = resultSet.getShort(("age"));
				String gender = resultSet.getString("gender");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				
				request.setAttribute("fName", fName);
				request.setAttribute("lName", lName);
				request.setAttribute("empID", empID);
				request.setAttribute("age", age);
				request.setAttribute("gender", gender);
				request.setAttribute("email", email);
				request.setAttribute("phone", phone);
				
				PreparedStatement statement2 = connection
						.prepareStatement("SELECT * FROM address WHERE EmpID = ?");
				statement2.setString(1, empID);
				
				ResultSet resultSet2 = statement2.executeQuery();
				
				if(resultSet2.next()) {
				String address1 = resultSet2.getString("address1");
//				String address2 = resultSet2.getString("address2");
//				String address3 = resultSet2.getString("address3");
				String city = resultSet2.getString("city");
				String zipCode = resultSet2.getString("zipcode");
				String state = resultSet2.getString("state");
				String country = resultSet2.getString("country");
				
				request.setAttribute("address1", address1);
//				request.setAttribute("address2", address2);
//				request.setAttribute("address3", address3);
				request.setAttribute("city", city);
				request.setAttribute("zipcode", zipCode);
				request.setAttribute("state", state);
				request.setAttribute("country", country);
				}
				
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("empID", empID);

//				request.setAttribute("loginServletSubmit", "LoginServlet");
				request.getRequestDispatcher("ControllerServlet?submit=LoginServlet").forward(request, response);
			} else {
				// Authentication failed - show an error message
				response.sendRedirect("Error.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
