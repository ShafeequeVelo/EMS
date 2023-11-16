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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.DepartmentPojo;

/**
 * Servlet implementation class DepartmentServlet
 */
public class DepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */

	Connection connection = DatabaseConnection.getConnection();
    public DepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<DepartmentPojo> departments = getAllDepartments();
		String json = new Gson().toJson(departments);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}
	public List<DepartmentPojo> getAllDepartments() {
		List<DepartmentPojo> departments = new ArrayList<>();

		String query = "SELECT * FROM department";
		
		try (Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query)) {
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
