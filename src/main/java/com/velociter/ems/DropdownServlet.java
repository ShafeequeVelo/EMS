package com.velociter.ems;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.CityPojo;
import com.velociter.ems.pojo.CountryPojo;
import com.velociter.ems.pojo.StatePojo;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// Imports...

@WebServlet(name = "DropdownServlet", urlPatterns = { "/DropdownServlet" })
public class DropdownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseConnection dbCon = new DatabaseConnection();
	Connection connection = dbCon.getConnection();

	// Rest of the code remains the same...

	// In the doGet method:
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String countryCode = request.getParameter("countryCode");
        String stateCode = request.getParameter("stateCode");

        if (countryCode == null && stateCode == null) {
             List<CountryPojo> countries = getCountries();
             String json = new Gson().toJson(countries);
             response.setContentType("application/json");
             response.setCharacterEncoding("UTF-8");
             response.getWriter().write(json);
        } else if (countryCode != null && stateCode == null) {
             List<StatePojo> states = getStatesByCountry(countryCode);
             String json = new Gson().toJson(states);
             response.setContentType("application/json");
             response.setCharacterEncoding("UTF-8");
             response.getWriter().write(json);
        } else if (stateCode != null && countryCode != null) {
             List<CityPojo> cities = getCitiesByState(stateCode, countryCode);
             String json = new Gson().toJson(cities);
             response.setContentType("application/json");
             response.setCharacterEncoding("UTF-8");
             response.getWriter().write(json);
        }
	}


	private List<CountryPojo> getCountries() {
		List<CountryPojo> countries = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM country");
			while (resultSet.next()) {
				CountryPojo country = new CountryPojo();
				country.setCountryCode(resultSet.getString("countryCode"));
				country.setCountryName(resultSet.getString("countryName"));
				country.setZipcode(resultSet.getString("zipcode"));
				countries.add(country);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle any exceptions properly
		}
		return countries;
	}

	private List<StatePojo> getStatesByCountry(String countryCode) {
		List<StatePojo> states = new ArrayList<>();
		try {
			PreparedStatement statement = connection
					.prepareStatement("SELECT * FROM state WHERE countryCode = ?");
			statement.setString(1, countryCode);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				StatePojo state = new StatePojo();
				state.setStateCode(resultSet.getString("stateCode"));
				state.setCountryCode(resultSet.getString("countryCode"));
				state.setStateName(resultSet.getString("stateName"));
				states.add(state);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle any exceptions properly
		}
		return states;
	}

	private List<CityPojo> getCitiesByState(String stateCode, String countryCode) {
		List<CityPojo> cities = new ArrayList<>();
		try {
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM city WHERE stateCode = ? and countryCode = ?");
			statement.setString(1, stateCode);
			statement.setString(2, countryCode);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				CityPojo city = new CityPojo();
				city.setCityCode(resultSet.getString("cityCode"));
				city.setCityName(resultSet.getString("cityname"));
				cities.add(city);
				System.out.println(city.getCityName());
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// Handle any exceptions properly
		}
		return cities;
	}

}
