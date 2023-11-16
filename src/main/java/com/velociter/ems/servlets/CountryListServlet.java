package com.velociter.ems.servlets;

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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.velociter.ems.helper.DatabaseConnection;
import com.velociter.ems.pojo.CityPojo;
import com.velociter.ems.pojo.CountryPojo;
import com.velociter.ems.pojo.StatePojo;

/**
 * Servlet implementation class CountryListServlet
 */
public class CountryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Connection connection = DatabaseConnection.getConnection();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		   
		   PreparedStatement statement = connection.prepareStatement("Select * from Country");
		   
		   ResultSet resultSet = statement.executeQuery();
		   
			while (resultSet.next()) {
				CountryPojo country = new CountryPojo();
				country.setCountryCode(resultSet.getString("countryCode"));
				country.setCountryName(resultSet.getString("countryName"));
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
			PreparedStatement statement = connection.prepareStatement("SELECT * FROM state WHERE countryCode = ?");
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
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return cities;
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}
}
