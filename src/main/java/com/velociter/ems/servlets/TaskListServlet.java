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
import com.velociter.ems.pojo.TasksPojo;

/**
 * Servlet implementation class TaskListServlet
 */
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskListServlet() {
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
		
		List<TasksPojo> taskList = new ArrayList<TasksPojo>();
		try {
			Connection connection = DatabaseConnection.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("Select * from tasks");
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				TasksPojo tasksPojo = new TasksPojo();
				tasksPojo.setTask(resultSet.getString("task"));
				tasksPojo.setTaskDescription(resultSet.getString("taskDesc"));
				
				taskList.add(tasksPojo);
			}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		
		request.setAttribute("taskList", taskList);
		request.getRequestDispatcher("ControllerServlet?submit=TaskListServlet").forward(request, response);
		}
}


