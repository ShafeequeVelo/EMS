package com.velociter.ems;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oracle.net.aso.p;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.helper.RoleOperation;
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


		
		HttpSession session = request.getSession();

		Connection connection = DatabaseConnection.getConnection();
		
		PreparedStatement preparedStatement = null;
		
		ResultSet resultSet = null;
		
		try {
			preparedStatement = connection.prepareStatement("SELECT EMPID FROM EMPLOYEE WHERE uName= ? and password = ?");
			
			preparedStatement.setString(1, rp.getuName());
			preparedStatement.setString(2, rp.getPassword());
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				
				String empID = resultSet.getString("empID");
				
				session.setAttribute("empID", empID);
				//request.getRequestDispatcher("ControllerServlet?submit=LoginServlet").forward(request, response);
				response.sendRedirect("ControllerServlet?submit=LoginServlet");
			}
			else {
				// Authentication failed - show an error message
				response.sendRedirect("Error.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		finally {
			DatabaseConnection.closeCon(preparedStatement, resultSet, connection);
		}

	}

}
