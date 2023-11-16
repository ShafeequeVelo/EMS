package com.velociter.ems;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.google.gson.JsonObject;
import com.velociter.ems.helper.DatabaseConnection;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class CheckZipcodeServlet
 */
public class CheckZipcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckZipcodeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String enteredZipcode = request.getParameter("zipcode");
		String countryCode = request.getParameter("cityCode");

		// Perform validation against your table of zipcodes
		boolean isValidZipcode = checkZipcodeValidity(enteredZipcode, countryCode);

		// Create a JSON response to send back the validation result
		JsonObject jsonResponse = new JsonObject();
		jsonResponse.addProperty("valid", isValidZipcode);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(jsonResponse.toString());
	}

	private boolean checkZipcodeValidity(String zipcode, String cityCode) {
		boolean isValid = false;
		
		Connection connection = DatabaseConnection.getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {

			String sql = "SELECT COUNT(*) as count FROM zipcode WHERE zipcode = ? AND cityCode = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, zipcode);
			statement.setString(2, cityCode);

			resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int count = resultSet.getInt("count");
				isValid = (count > 0);
			}

			resultSet.close();
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();

		}
		finally {
			DatabaseConnection.closeCon(statement, resultSet, connection);
		}
		return isValid;
	}
}
