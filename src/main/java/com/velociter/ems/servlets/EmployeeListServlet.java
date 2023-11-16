package com.velociter.ems.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.helper.Operations;
import com.velociter.ems.pojo.DesignationPojo;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<RegistrationPojo> employee = new ArrayList<RegistrationPojo>();

		List<String> designations = new ArrayList<String>();
		List<DesignationPojo> design = new ArrayList<DesignationPojo>();
		
		Operations operations = new Operations();
		Map<RegistrationPojo, DesignationPojo> managerList = new HashMap<RegistrationPojo, DesignationPojo>();
		
		Connection connection = DatabaseConnection.getConnection();

		try {
			PreparedStatement statement = connection.prepareStatement(
					"Select e.* from employee e LEFT JOIN emp_designation ed on e.empID = ed.empID where ed.empID is NULL");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				RegistrationPojo registrationPojo = new RegistrationPojo();
				registrationPojo.setfName(resultSet.getString("fName"));
				registrationPojo.setlName(resultSet.getString("lName"));
				registrationPojo.setEmpID(resultSet.getString("empID"));
				registrationPojo.setAge(Short.parseShort(resultSet.getString("age")));
				registrationPojo.setGender(resultSet.getString("gender"));
				registrationPojo.setEmail(resultSet.getString("email"));
				registrationPojo.setPhone(resultSet.getString("phone"));
				registrationPojo.setEmpID(resultSet.getString("empID"));

				employee.add(registrationPojo);

			}
			PreparedStatement statement2 = connection.prepareStatement("Select * from designation");

			ResultSet resultSet2 = statement2.executeQuery();

			while (resultSet2.next()) {
				DesignationPojo designationPojo = new DesignationPojo();
				designationPojo.setDesignationName(resultSet2.getString("designationName"));

				designations.add(designationPojo.getDesignationName());
			}

			PreparedStatement statement3 = connection.prepareStatement("Select * from emp_designation");

			ResultSet resultSet3 = statement3.executeQuery();

			while (resultSet3.next()) {

				DesignationPojo dp = new DesignationPojo();
				dp.setDesignationID(resultSet3.getString("empID"));
				dp.setDesignationName(resultSet3.getString("designation"));
				dp.setEmp_designationId(Integer.parseInt(resultSet3.getString("emp_designation")));
				dp.setManagerID(resultSet3.getString("manager_ID"));

				design.add(dp);

				PreparedStatement statement4 = connection.prepareStatement("Select * from employee where empid=?");
				statement4.setString(1, dp.getDesignationID());
				ResultSet resultSet4 = statement4.executeQuery();
				while (resultSet4.next()) {
					RegistrationPojo rePojo = new RegistrationPojo();
					rePojo.setfName(resultSet4.getString("fName"));
					rePojo.setlName(resultSet4.getString("lName"));
					rePojo.setEmpID(resultSet4.getString("empid"));
					rePojo.setAge(resultSet4.getShort("age"));
					rePojo.setGender(resultSet4.getString("gender"));
					rePojo.setPhone(resultSet4.getString("phone"));
					rePojo.setEmail(resultSet4.getString("email"));

//					registrationPojoList.add(rePojo);

					managerList.put(rePojo, dp);

				}

			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		request.setAttribute("employee", employee);
		request.setAttribute("designations", designations);
		request.setAttribute("managerList", managerList);
		request.setAttribute("design", design);
		request.getRequestDispatcher("ControllerServlet?submit=EmployeeListServlet").forward(request, response);

	}

}
