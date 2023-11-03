package com.velociter.ems;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.velociter.ems.helper.DepartmentOperations;
import com.velociter.ems.helper.RoleOperation;
import com.velociter.ems.pojo.DepartmentPojo;
import com.velociter.ems.pojo.RolePojo;

/**
 * Servlet implementation class ListDepartmentsServlet
 */
public class ListDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListDepartmentServlet() {
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

		HttpSession session = request.getSession(false);
		if (null == session.getAttribute("empID")) {
			response.sendRedirect("index.jsp");
		} else {

			DepartmentOperations Operation = new DepartmentOperations();

			List<DepartmentPojo> Departments = Operation.getAllDepartments();

			session.setAttribute("Departments", Departments);
//			request.getRequestDispatcher("ControllerServlet?submit=ListDepartmentServlet").forward(request, response);
			response.sendRedirect("ControllerServlet?submit=ListDepartmentServlet");
		}
	}

}
