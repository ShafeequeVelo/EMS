package com.velociter.ems;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.velociter.ems.helper.RoleOperation;
import com.velociter.ems.pojo.RolePojo;

/**
 * Servlet implementation class CreateRoleServlet
 */
public class CreateRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRoleServlet() {
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

		
			RoleOperation operation = new RoleOperation();
			String submit = request.getParameter("submit");
			
			if(submit.equals("Create Role")) {
				RolePojo role = new RolePojo();
				role.setRoleName(request.getParameter("roleName"));
				int i = operation.createRole(role);
				if(i>0) {
					request.getRequestDispatcher("ControllerServlet?submit=CreateRoleServlet").forward(request, response);
				}
				else {
					System.out.print("Role not created");
				}
			}
	}

}
