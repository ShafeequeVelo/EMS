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
import com.velociter.ems.pojo.RolePojo;

/**
 * Servlet implementation class RoleListServlet
 */
public class RoleListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoleListServlet() {
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
		
		List<RolePojo> roles = new ArrayList<RolePojo>();
				
		try {
			Connection connection = DatabaseConnection.getConnection();
		  PreparedStatement preparedStatement2 = connection.prepareStatement("Select * from role");
		  ResultSet resultSet2 = preparedStatement2.executeQuery();
		 
		  while(resultSet2.next()) {
			  RolePojo rolePojo2 = new RolePojo();
			  rolePojo2.setRoleID(resultSet2.getString("ROLEID"));
			  rolePojo2.setRoleName(resultSet2.getString("ROLENAME"));
			  roles.add(rolePojo2);	
			  
		  }
		}catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("ControllerServlet?submit=RoleListServlet").forward(request, response);
	}

	}


