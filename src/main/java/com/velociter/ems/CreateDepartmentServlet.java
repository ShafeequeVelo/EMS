package com.velociter.ems;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.velociter.ems.helper.DepartmentOperations;
import com.velociter.ems.helper.RoleOperation;
import com.velociter.ems.pojo.DepartmentPojo;
import com.velociter.ems.pojo.RolePojo;

/**
 * Servlet implementation class CreateDepartmentServlet
 */
public class CreateDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateDepartmentServlet() {
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

		
		DepartmentOperations operation = new DepartmentOperations();
		String submit = request.getParameter("submit");
		
		if(submit.equals("Create Department")) {
			DepartmentPojo Department = new DepartmentPojo();
			Department.setDepartmentName(request.getParameter("DepartmentName"));
			int i = operation.createDepartment(Department);
			if(i>0) {
				request.getRequestDispatcher("ControllerServlet?submit=CreateDepartmentServlet").forward(request, response);
			}
			else {
				System.out.print("Department not created");
			}
		}
}
}
