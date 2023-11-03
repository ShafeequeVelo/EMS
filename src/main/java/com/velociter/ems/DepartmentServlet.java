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
import com.velociter.ems.pojo.DepartmentPojo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DepartmentRoleServlet
 */
@WebServlet(name = "DepartmentServlet", urlPatterns = { "/DepartmentServlet" })
public class DepartmentServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DatabaseConnection dbConnection = new DatabaseConnection();
	Connection connection = dbConnection.getConnection();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<DepartmentPojo> departments = getAllDepartments();
		String json = new Gson().toJson(departments);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}

	public List<DepartmentPojo> getAllDepartments() {
		List<DepartmentPojo> departments = new ArrayList<>();

		String query = "SELECT * FROM department";
		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(query)) {
			while (resultSet.next()) {
				DepartmentPojo department = new DepartmentPojo();
				department.setDepartmentID(resultSet.getString("DEPARTMENTID"));
				department.setDepartmentName(resultSet.getString("DEPARTMENTNAME"));
				departments.add(department);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return departments;
	}

	// Add prepared statements to prevent SQL injection

}
