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

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.TasksPojo;

/**
 * Servlet implementation class TaskServlet
 */
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskServlet() {
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

		TasksPojo tasksPojo = new TasksPojo();
		
		tasksPojo.setTask(request.getParameter("task"));
		tasksPojo.setTaskDescription(request.getParameter("taskDescription"));
		
		try {
			Connection connection = DatabaseConnection.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement("Insert into tasks"
					+ "(task,taskdesc) values(?,?)");
		
			preparedStatement.setString(1, tasksPojo.getTask());
			preparedStatement.setString(2, tasksPojo.getTaskDescription());
			ResultSet resultSet = preparedStatement.executeQuery();
		
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("ControllerServlet?submit=TaskServlet").forward(request, response);
		
	}

}
