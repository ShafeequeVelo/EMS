package com.velociter.ems.servlets;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.helper.NewConnection;
import com.velociter.ems.pojo.DepartmentPojo;
import com.velociter.ems.pojo.RolePojo;
import com.velociter.ems.helper.NewConnection;

/**
 * Servlet implementation class CreateDepartmentServlet
 */
public class CreateDepartmentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DepartmentPojo departmentPojo = new DepartmentPojo();
		departmentPojo.setDepartmentID(request.getParameter("departmentId"));
		departmentPojo.setDepartmentName(request.getParameter("departmentName"));
	
		Connection connection = DatabaseConnection.getConnection();
		try {
			PreparedStatement preparedStatement =  connection.prepareStatement("Insert into Department(departmentId,departmentName) values(?,?)");
			
			preparedStatement.setString(1,departmentPojo.getDepartmentID());
			preparedStatement.setString(2, departmentPojo.getDepartmentName());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ControllerServlet?submit=CreateDepartmentServlet").forward(request, response);
	}

	

}
