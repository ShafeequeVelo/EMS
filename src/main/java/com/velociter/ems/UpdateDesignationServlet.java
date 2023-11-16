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
import java.sql.SQLException;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.DesignationsPojo;

/**
 * Servlet implementation class UpdateDesignationServlet
 */
public class UpdateDesignationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDesignationServlet() {
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

		DesignationsPojo designationsPojo = new DesignationsPojo();

		designationsPojo.setDesignation_Name(request.getParameter("designation"));
		designationsPojo.setEmployee_desigID(Integer.parseInt(request.getParameter("EmpID").toString()));

		HttpSession httpSession = request.getSession(false);

		int empID = Integer.parseInt(httpSession.getAttribute("empID").toString());

		Connection connection = DatabaseConnection.getConnection();
		
		PreparedStatement prepObj = null;

		try {
			prepObj= connection
					.prepareStatement(("insert into EMP_DESIGNATION( Designation,empID,manager_ID) values(?,?,?)"));

			prepObj.setString(1, designationsPojo.getDesignation_Name());
			prepObj.setInt(2, designationsPojo.getEmployee_desigID());
			prepObj.setInt(3, empID);

			prepObj.executeQuery();

			request.getRequestDispatcher("ControllerServlet?submit=UpdateDesigServlet").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			DatabaseConnection.closeCon(prepObj, connection);
		}
	}
}