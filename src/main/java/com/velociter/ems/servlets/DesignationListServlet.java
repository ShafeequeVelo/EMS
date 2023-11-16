package com.velociter.ems.servlets;

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
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.DesignationPojo;

/**
 * Servlet implementation class DesignationListServlet
 */
public class DesignationListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DesignationListServlet() {
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
		// TODO Auto-generated method stub
		
		DesignationPojo designationPojo = new DesignationPojo();
		designationPojo.setEmp_designationId(Integer.parseInt(request.getParameter("EmpID")));
		designationPojo.setDesignationName(request.getParameter("designation").toString());
		
		HttpSession httpSession = request.getSession(false);
		int empID = Integer.parseInt(httpSession.getAttribute("empID").toString());
		
		Connection connection = DatabaseConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(("Insert into emp_designation"
					+ "(designation, empid, Manager_id) values(?,?,?)"));
			preparedStatement.setString(1, designationPojo.getDesignationName());
			
			preparedStatement.setInt(2, designationPojo.getEmp_designationId());
			preparedStatement.setInt(3, empID);

			ResultSet resultSet = preparedStatement.executeQuery();
			request.getRequestDispatcher("ControllerServlet?submit=DesignationListServlet").forward(request,response);
			
			
			
		}catch(SQLException e)
		{
			e.printStackTrace();
	}
		
}

}
