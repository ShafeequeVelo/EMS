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
import com.velociter.ems.pojo.DepartmentPojo;
import com.velociter.ems.pojo.TasksPojo;

/**
 * Servlet implementation class DepartmentListServlet
 */
public class DepartmentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentListServlet() {
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
		List<DepartmentPojo> departList = new ArrayList<DepartmentPojo>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from Department");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				DepartmentPojo department = new DepartmentPojo();
				department.setDepartmentID(resultSet.getString("departmentId"));
				department.setDepartmentName(resultSet.getString("departmentName"));
				
				departList.add(department);
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		request.setAttribute("departList", departList);
		request.getRequestDispatcher("ControllerServlet?submit=DepartmentListServlet").forward(request, response);
		}
}
