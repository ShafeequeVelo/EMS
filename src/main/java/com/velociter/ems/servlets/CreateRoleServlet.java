package com.velociter.ems.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.helper.NewConnection;
import com.velociter.ems.pojo.RolePojo;

/**
 * Servlet implementation class CreateRoleServlet
 */
public class CreateRoleServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRoleServlet() {
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
		// TODO Auto-generated method stub
		
		RolePojo rolePojo = new RolePojo();
		rolePojo.setRoleID(request.getParameter("roleId"));
		rolePojo.setRoleName(request.getParameter("roleName"));
		Connection connection = DatabaseConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("Insert into role (roleId,roleName) values(?,?)");
			
			preparedStatement.setString(1, rolePojo.getRoleID());
			preparedStatement.setString(2, rolePojo.getRoleName());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			 
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ControllerServlet?submit=CreateRoleServlet").forward(request, response);
	}

}
