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
	// variables which contain names of jsp pages.
	String loginJSP = "Login.jsp";
	String registrationJSP = "Registration.jsp";
	String welcomeJSP = "Welcome.jsp";
	String employeeDesigJSP = "EmployeeDesignation.jsp";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getting the parameter from jsp page into string variable.
		String submit = request.getParameter("submit");
		System.out.println("doGet");
		System.out.println(submit);
		// redirecting to login page
		if (submit != null && submit.equals("Login Now")) {
			response.sendRedirect(loginJSP);
		}
		if (submit != null && submit.equals("LoginServlet")) {
			request.getRequestDispatcher("WelcomeServlet").forward(request, response);
		}
		else if (submit != null && submit.equals("WelcomeServlet")) {
			request.getRequestDispatcher(welcomeJSP).forward(request, response);
		}
		else if (submit != null && submit.equals("ListDepartmentServlet")) {
			request.getRequestDispatcher("ListAndCreateDepartment.jsp").forward(request, response);
		}
		else if (submit != null && submit.equals("ListRoleServlet")) {
			request.getRequestDispatcher("ListAndCreateRole.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getting the parameter from jsp page into string variable.
		String submit = request.getParameter("submit");
		System.out.println("doPost");
		System.out.println(submit);


		// redirecting to login page
		if (submit != null && submit.equals("Login Now")) {
			response.sendRedirect(loginJSP);
		}
		// redirecting to Registration page
		else if (submit != null && submit.equals("Register Now")) {
			response.sendRedirect(registrationJSP);
		}

		// sending the request to RegistrationServlet
		else if (submit != null && submit.equals("Register")) {
			request.getRequestDispatcher("RegistrationServlet").forward(request, response);
		}
		// redirecting to login page
		else if (submit != null && submit.equals("RegisterServlet")) {
			request.getRequestDispatcher(loginJSP).forward(request, response);
		}

		// sending request to LoginServlet
		else if (submit != null && submit.equals("Login")) {
			request.getRequestDispatcher("LoginServlet").forward(request, response);

		}

		// sending request to WelcomeServlet
		else if (submit != null && submit.equals("LoginServlet")) {
			request.getRequestDispatcher("WelcomeServlet").forward(request, response);

		}

		// sending request to WelcomeServlet
		else if (submit != null && submit.equals("Back")) {
			request.getRequestDispatcher("WelcomeServlet").forward(request, response);

		}
		// redirecting to welcome page.
		else if (submit != null && submit.equals("WelcomeServlet")) {
			request.getRequestDispatcher(welcomeJSP).forward(request, response);
		}

		// redirecting to ListRoleServlet.
		else if (submit != null && submit.equals("Manage Roles")) {
			request.getRequestDispatcher("ListRoleServlet").forward(request, response);
		}

		// redirecting to ListAndCreate page.
		else if (submit != null && submit.equals("ListRoleServlet")) {
			request.getRequestDispatcher("ListAndCreateRole.jsp").forward(request, response);
		}

		// redirecting to CreateRoleServlet.
		else if (submit != null && submit.equals("Create Role")) {
			request.getRequestDispatcher("CreateRoleServlet").forward(request, response);
		}

		// redirecting to ListRoleServlet.
		else if (submit != null && submit.equals("CreateRoleServlet")) {
			request.getRequestDispatcher("ListRoleServlet").forward(request, response);
		}

		// redirecting to ListDepartmentServlet.
		else if (submit != null && submit.equals("Manage Departments")) {
			request.getRequestDispatcher("ListDepartmentServlet").forward(request, response);
		}

		// redirecting to ListAndCreateDepartment page.
		else if (submit != null && submit.equals("ListDepartmentServlet")) {
			request.getRequestDispatcher("ListAndCreateDepartment.jsp").forward(request, response);
		}

		// redirecting to CreateDepartmentServlet.
		else if (submit != null && submit.equals("Create Department")) {
			request.getRequestDispatcher("CreateDepartmentServlet").forward(request, response);
		}

		// redirecting to ListDepartmentServlet.
		else if (submit != null && submit.equals("CreateDepartmentServlet")) {
			request.getRequestDispatcher("ListDepartmentServlet").forward(request, response);
		}

		// redirecting to EmployeeListServlet.
		else if (submit != null && submit.equals("Add Manager")) {
			request.getRequestDispatcher("EmployeeListServlet").forward(request, response);
		}

		else if (submit != null && submit.equals("Add Employee")) {
			request.getRequestDispatcher("EmployeeListServlet").forward(request, response);
		}

		// ????
		else if (submit != null && submit.equals("Add Tasks")) {
			request.getRequestDispatcher("ListTasksServlet").forward(request, response);
		}

		else if (submit != null && submit.equals("ListTasksServlet")) {
			request.getRequestDispatcher("CreateTasks.jsp").forward(request, response);
		}

		// redirecting to EmployeeList jsp.
		else if (submit != null && submit.equals("EmployeeListServlet")) {
			request.getRequestDispatcher(employeeDesigJSP).forward(request, response);
		}

		// redirecting to UpdateDesignationServlet.
		else if (submit != null && submit.equals("EmployeeDesignation")) {
			request.getRequestDispatcher("UpdateDesignationServlet").forward(request, response);
		}

		else if (submit != null && submit.equals("UpdateDesigServlet")) {
			request.getRequestDispatcher("EmployeeListServlet").forward(request, response);
		}

		else if (submit != null && submit.equals("CreateTask")) {
			request.getRequestDispatcher("CreateTaskServlet").forward(request, response);
		}

		else if (submit != null && submit.equals("CreateTaskServlet")) {
			request.getRequestDispatcher("ListTasksServlet").forward(request, response);
		}

		else if (submit != null && submit.equals("updateTask")) {
			request.getRequestDispatcher("UpdateTaskServlet").forward(request, response);
		}

		// forwarding request to ListTasksServlet
		else if (submit != null && submit.equals("UpdateTaskServlet")) {
			request.getRequestDispatcher("ListTasksServlet").forward(request, response);
		}

		// To Change
		else if (submit != null && submit.equals("BackFromTask")) {
			request.getRequestDispatcher(welcomeJSP).forward(request, response);
		}

		// forwarding request to ShowTasksServlet
		else if (submit != null && submit.equals("Show Tasks")) {
			request.getRequestDispatcher("ShowTasksServlet").forward(request, response);
		}

		// forwarding request to ShowTasks.jsp
		else if (submit != null && submit.equals("ShowTasksServlet")) {
			request.getRequestDispatcher("ShowTasks.jsp").forward(request, response);
		}

		// forwarding request to UpdateTaskStatusServlet
		else if (submit != null && submit.equals("updateTaskForEmp")) {
			request.getRequestDispatcher("UpdateTaskStatusServlet").forward(request, response);
		}

		// forwarding request to ShowTasks.jsp
		else if (submit != null && submit.equals("UpdateTaskStatusServlet")) {
			request.getRequestDispatcher("ShowTasksServlet").forward(request, response);
		}

		// redirecting to LogoutServlet
		else if (submit != null && submit.equals("Logout")) {
			// request.getRequestDispatcher("LogoutServlet").forward(request, response);
			response.sendRedirect("LogoutServlet");
		}

	}
}