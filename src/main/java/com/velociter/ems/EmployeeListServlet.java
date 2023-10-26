package com.velociter.ems;

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
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.helper.GetDesignations;
import com.velociter.ems.pojo.RegistrationPojo;

/**
 * Servlet implementation class EmployeeListServlet
 */
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeListServlet() {
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
	 * @return
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(false);
		DatabaseConnection databaseConnection = new DatabaseConnection();

		Connection connection = databaseConnection.getConnection();

		List<RegistrationPojo> employeeList = new ArrayList<RegistrationPojo>();
		List<RegistrationPojo> managerList = new ArrayList<RegistrationPojo>();

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("SELECT e.* " + "FROM employee e LEFT JOIN emp_designation ed ON "
							+ "e.empid = ed.empid WHERE ed.empid IS NULL AND e.empID != 1");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				RegistrationPojo registrationPojo = new RegistrationPojo();

				registrationPojo.setfName(resultSet.getString("FName"));
				registrationPojo.setlName(resultSet.getString("LName"));
				registrationPojo.setEmpID((resultSet.getString("EMPID")));
				registrationPojo.setEmail((resultSet.getString("EMAIL")));

				employeeList.add(registrationPojo);
			}
			if (employeeList.size() > 0) {
				request.setAttribute("employeeList", employeeList);
			}

			GetDesignations getDesignations = new GetDesignations();

			String desig = getDesignations.determineEmpDesignation(session.getAttribute("empID").toString());
			if (desig.equals("ADMIN")) {
				managerList = getDesignations.getManagers();
			} else {
				managerList = getDesignations.getEmpForMgr(session.getAttribute("empID").toString());
			}
			request.setAttribute("managerList", managerList);

			request.getRequestDispatcher("ControllerServlet?submit=EmployeeListServlet").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
