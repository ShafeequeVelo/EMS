package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.pojo.CityPojo;
import com.velociter.ems.pojo.StatePojo;

public class GetStateCity {

	DatabaseConnection dbConnection = new DatabaseConnection();



	public List<String> getState() {

        Connection connection = dbConnection.getConnection();

        List<String> stateList = new ArrayList<String>();

        try {



             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM STATES");

             ResultSet rs = preparedStatement.executeQuery();

             StatePojo state = new StatePojo();

             while (rs.next()) {

//                  state.setStateID(rs.getString("state_id"));

                  state.setStateName(rs.getString("state_name"));

                  stateList.add(state.getStateName());



             }



        } catch (SQLException e) {

             e.printStackTrace();

        } finally {

             if (connection != null) {

                  System.out.print("in finally, in GetStateCity.java");

             }

        }

 

       

        return stateList;



  }
	public List<String> getCities(String stateName) {

		Connection connection = dbConnection.getConnection();

		List<String> citieList = new ArrayList<String>();

		try {



			PreparedStatement ps = connection.prepareStatement("SELECT * FROM City where state_name=?");

			ps.setString(1, stateName);

			ResultSet rs = ps.executeQuery();

			CityPojo city = new CityPojo();

			while (rs.next()) {

//				city.setStateID(rs.getString("city_id"));

				city.setCityName(rs.getString("city_name"));
				

				citieList.add(city.getCityName());

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		return citieList; 
	}

}