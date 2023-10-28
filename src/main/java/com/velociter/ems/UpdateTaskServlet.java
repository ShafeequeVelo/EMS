package com.velociter.ems;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.velociter.ems.helper.TaskOperations;
import com.velociter.ems.pojo.TaskPojo;

/**
 * Servlet implementation class UpdateTask
 */
public class UpdateTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateTaskServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		TaskPojo taskPojo = new TaskPojo();

		taskPojo.setTaskID(request.getParameter("taskid"));
		taskPojo.setAssignee(request.getParameter("assignee"));
		TaskOperations taskOperations = new TaskOperations();
		int i = taskOperations.updateTask(taskPojo);
		if (0 < i) {
			
			request.getRequestDispatcher("ControllerServlet?submit=UpdateTaskServlet").forward(request, response);

		} else {
			System.out.println("fail");
		}

	}

}
