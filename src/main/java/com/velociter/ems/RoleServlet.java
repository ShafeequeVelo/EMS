package com.velociter.ems;

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

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RoleServlet
 */
@WebServlet(name = "RoleServlet", urlPatterns = { "/RoleServlet" })
public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DatabaseConnection dbConnection = new DatabaseConnection();
	Connection connection = dbConnection.getConnection();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<RolePojo> departments = getAllRoles();
		String json = new Gson().toJson(departments);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	public List<RolePojo> getAllRoles() {
		List<RolePojo> roles = new ArrayList<>();
		
		RoleOperation roleOperation = new RoleOperation();
		
		String admin = "ADMIN";
		
		String query = "SELECT * FROM role";
		
		if(roleOperation.isAdminAvailable()) {
			query = "SELECT * FROM ROLE WHERE ROLENAME != '"+admin+"'";
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

}
