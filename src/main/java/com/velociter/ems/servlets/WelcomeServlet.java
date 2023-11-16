package com.velociter.ems.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.helper.NewConnection;
import com.velociter.ems.helper.RoleOperation;
import com.velociter.ems.pojo.RolePojo;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet{ 
	
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeServlet() {
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		if (session.getAttribute("empID")== null) {
			response.sendRedirect("index.jsp");
		} else {
			String empID = (String) session.getAttribute("empID");
			Connection connection = DatabaseConnection.getConnection();
			try {

				PreparedStatement statement = connection.prepareStatement("SELECT * FROM employee WHERE EMPID = ?");

				statement.setString(1, empID);

				ResultSet resultSet = statement.executeQuery();

				if (resultSet.next()) {
					// Successful login - redirect to a secure page
					String fName = resultSet.getString("fName");
					String lName = resultSet.getString("lName");
					// String empID = resultSet.getString("empID");
					short age = resultSet.getShort(("age"));
					String gender = resultSet.getString("gender");
					String email = resultSet.getString("email");
					String phone = resultSet.getString("phone");
					String roleID = resultSet.getString("RoleID");
					String departmentID = resultSet.getString("DepartmentID");

					request.setAttribute("fName", fName);
					request.setAttribute("lName", lName);
					request.setAttribute("empID", empID);
					request.setAttribute("age", age);
					request.setAttribute("gender", gender);
					request.setAttribute("email", email);
					request.setAttribute("phone", phone);

					RoleOperation roleOperation = new RoleOperation();
					String roleName = roleOperation.getRoleByID(roleID).getRoleName();
					request.setAttribute("roleName", roleName);
					PreparedStatement statement2 = ((Connection) connection).prepareStatement("SELECT * FROM address WHERE EmpID = ?");
					statement2.setString(1, empID);

					ResultSet resultSet2 = statement2.executeQuery();

					if (resultSet2.next()) {
						String address1 = resultSet2.getString("address");
						String city = resultSet2.getString("city");
						int zipCode = Integer.parseInt(resultSet2.getString("zipcode"));
						String state = resultSet2.getString("state");
						String country = resultSet2.getString("country");

						request.setAttribute("address1", address1);
						request.setAttribute("city", city);
						request.setAttribute("zipcode", zipCode);
						request.setAttribute("state", state);
						request.setAttribute("country", country);
					}

					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("empID", empID);

					request.getRequestDispatcher("ControllerServlet?submit=WelcomeServlet").forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
				
			}
		}
	}
}