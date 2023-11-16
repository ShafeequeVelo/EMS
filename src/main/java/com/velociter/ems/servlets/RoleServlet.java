package com.velociter.ems.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.helper.RoleOperation;
import com.velociter.ems.pojo.RolePojo;

/**
 * Servlet implementation class RoleServlet
 */
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	Connection connection = DatabaseConnection.getConnection();
    public RoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		List<RolePojo> departments = getAllRoles();
		String json = new Gson().toJson(departments);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	public List<RolePojo> getAllRoles() {
		
		List<RolePojo> roles = new ArrayList<RolePojo>();
		String query = "Select * from role";
		RoleOperation roleOperation = new RoleOperation();
		String admin = "ADMIN";
		if(roleOperation.isAdminAvailable()) {
			query = "Select * from role where rolename != '"+admin+"'";
		}
		
		
		try  {
			Statement statement = connection.createStatement(); 
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				RolePojo role = new RolePojo();
				role.setRoleID(resultSet.getString("ROLEID"));
				role.setRoleName(resultSet.getString("ROLENAME"));
				roles.add(role);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return roles;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
