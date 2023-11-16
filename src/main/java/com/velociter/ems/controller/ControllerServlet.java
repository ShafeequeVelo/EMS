package com.velociter.ems.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Servlet implementation class ControllerServlet
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//getting the parameter from jsp page into string variable.
			
			
			//variables which contain names of jsp pages.
			String loginJSP = "Login.jsp";
			String registrationJSP = "Registration.jsp";
			String welcomeJSP = "Welcome.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String submit = request.getParameter("submit");
		if (submit != null && submit.equals("Login Now")) {
			response.sendRedirect(loginJSP);
		}
		else if (submit != null && submit.equals("LoginServlet")) {
			request.getRequestDispatcher("WelcomeServlet").forward(request, response);
		}
		else if (submit != null && submit.equals("WelcomeServlet")) {
			request.getRequestDispatcher(welcomeJSP).forward(request, response);
		}
		else if (submit != null && submit.equals("Logout")) {
			request.getRequestDispatcher("LogoutServlet").forward(request, response);
		}
		else if (submit != null && submit.equals("LogoutServlet")) {
			response.sendRedirect("index.jsp");
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String submit = request.getParameter("submit"); 
		//redirecting to login page
		if(submit != null && submit.equals("Login Now")) {
			response.sendRedirect(loginJSP);
		}
		//redirecting to Registration page
		else if(submit != null && submit.equals("Register Now")) {
			response.sendRedirect(registrationJSP);
		}
		
		// sending the request to RegistrationServlet
		else if (submit != null && submit.equals("Register")) {
			request.getRequestDispatcher("RegistrationServlet").forward(request, response);
		}	
		// redirecting to login page
		else if(submit != null && submit.equals("RegisterServlet")) {
			response.sendRedirect(loginJSP);
		}
		
		// sending request to LoginServlet
		else if(submit != null && submit.equals("Login")) {
			request.getRequestDispatcher("LoginServlet").forward(request, response);

		}
		// redirecting to welcome page.
		else if(submit != null && submit.equals("LoginServlet")) {
			request.getRequestDispatcher(welcomeJSP).forward(request, response);
		}
		else if(submit != null && submit.equals("CreateDepartment")) {
			request.getRequestDispatcher("CreateDepartment.jsp").forward(request, response);
		}
		else if(submit != null && submit.equals("Create Department")) {
			request.getRequestDispatcher("CreateDepartmentServlet").forward(request, response);
		}
	
		else if(submit != null && submit.equals("CreateDepartmentServlet")) {
			request.getRequestDispatcher("CreateDepartment.jsp").forward(request, response);
		}
	
		else if(submit != null && submit.equals("CreateRole")) {
			request.getRequestDispatcher("CreateRole.jsp").forward(request, response);
		}
		else if(submit != null && submit.equals("Create Role")) {
			request.getRequestDispatcher("CreateRoleServlet").forward(request, response);
		}
		else if(submit != null && submit.equals("CreateRoleServlet")) {
			request.getRequestDispatcher("CreateRole.jsp").forward(request, response);
		}
		else if(submit != null && submit.equals("Add Manager")) {
			request.getRequestDispatcher("EmployeeListServlet").forward(request, response);
		}
		else if(submit != null && submit.equals("Add Employees")) {
			request.getRequestDispatcher("EmployeeListServlet").forward(request, response);
		}
		else if(submit != null && submit.equals("Task")) {
			request.getRequestDispatcher("TaskListServlet").forward(request, response);
		}
		else if(submit != null && submit.equals("TaskListServlet")) {
			request.getRequestDispatcher("TaskList.jsp").forward(request, response);
		}
		else if(submit != null && submit.equals("Add Task")) {
			request.getRequestDispatcher("TaskServlet").forward(request, response);
		}
		else if(submit != null && submit.equals("TaskServlet")) {
			request.getRequestDispatcher("TaskListServlet").forward(request, response);
		}
		else if(submit != null && submit.equals("EmployeeListServlet")) {
			request.getRequestDispatcher("EmployeeList.jsp").forward(request, response);
		}
		else if(submit != null && submit.equals("Save")) {
			request.getRequestDispatcher("DesignationListServlet").forward(request, response);
		}
		else if(submit != null && submit.equals("DesignationListServlet")) {
			request.getRequestDispatcher("EmployeeListServlet").forward(request, response);
		}
		
		
		// redirecting to LogoutServlet
		else if(submit != null && submit.equals("Logout")) {
				request.getRequestDispatcher("LogoutServlet").forward(request, response);
					}
		
		
		else if(submit != null && submit.equals("LogoutServlet")) {
			request.getRequestDispatcher(loginJSP).forward(request, response);
		}
		
	}
}