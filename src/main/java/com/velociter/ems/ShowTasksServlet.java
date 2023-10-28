package com.velociter.ems;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.helper.TaskOperations;
import com.velociter.ems.pojo.TaskPojo;

/**
 * Servlet implementation class ShowTasksServlet
 */
public class ShowTasksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTasksServlet() {
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
		
		TaskOperations taskOperatoin = new TaskOperations();
		
		List<TaskPojo> tasksForEmp = new ArrayList<TaskPojo>();
		
		HttpSession session = request.getSession();
		
		tasksForEmp = taskOperatoin.getTaskForEmp(session.getAttribute("empID").toString());
		
		request.setAttribute("tasksForEmp", tasksForEmp);
		
		request.getRequestDispatcher("ControllerServlet?submit=ShowTasksServlet").forward(request, response);
	}

}
