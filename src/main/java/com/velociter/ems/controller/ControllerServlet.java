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

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerServlet() {
		super();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// getting the parameter from jsp page into string variable.
		String submit = request.getParameter("submit");

		// variables which contain names of jsp pages.
		String loginJSP = "Login.jsp";
		String registrationJSP = "Registration.jsp";
		String welcomeJSP = "Welcome.jsp";
		String employeeDesigJSP = "EmployeeDesignation.jsp";

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
			response.sendRedirect(loginJSP);
		}

		// sending request to LoginServlet
		else if (submit != null && submit.equals("Login")) {
			request.getRequestDispatcher("LoginServlet").forward(request, response);

		}
		// redirecting to welcome page.
		else if (submit != null && submit.equals("LoginServlet")) {
			request.getRequestDispatcher(welcomeJSP).forward(request, response);
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
			request.getRequestDispatcher("CreateTasks.jsp").forward(request, response);
		}

		else if (submit != null && submit.equals("updateTask")) {
			request.getRequestDispatcher("UpdateTaskServlet").forward(request, response);
		}

		else if (submit != null && submit.equals("UpdateTaskServlet")) {
			request.getRequestDispatcher("CreateTaskServlet").forward(request, response);
		}

		// redirecting to LogoutServlet
		else if (submit != null && submit.equals("Logout")) {
			request.getRequestDispatcher("LogoutServlet").forward(request, response);
		}

		// redirecting to login page.
		else if (submit != null && submit.equals("LogoutServlet")) {
			request.getRequestDispatcher(loginJSP).forward(request, response);
		}

	}
}