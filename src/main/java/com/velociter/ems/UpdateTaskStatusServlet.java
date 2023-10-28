package com.velociter.ems;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.helper.TaskOperations;
import com.velociter.ems.pojo.TaskPojo;

/**
 * Servlet implementation class UpdateTaskStatusServlet
 */
public class UpdateTaskStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTaskStatusServlet() {
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
		
		TaskOperations taskOperations = new TaskOperations();
		TaskPojo taskPojo = new TaskPojo();
		
		taskPojo.setStatus(request.getParameter("status"));
		taskPojo.setTaskID(request.getParameter("taskid"));
		
		int i = taskOperations.updateTaskForEmp(taskPojo);
		
	if (0 < i) {
			
			request.getRequestDispatcher("ControllerServlet?submit=UpdateTaskStatusServlet").forward(request, response);

		} else {
			System.out.println("fail");
		}

	}
}
