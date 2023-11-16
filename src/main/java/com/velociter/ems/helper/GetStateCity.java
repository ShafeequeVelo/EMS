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

	public List<String> getState() {

        Connection connection = DatabaseConnection.getConnection();
        
        PreparedStatement  preparedStatement = null;
        
        ResultSet rs = null;

        List<String> stateList = new ArrayList<String>();

        try {



             preparedStatement = connection.prepareStatement("SELECT * FROM STATES");

             rs = preparedStatement.executeQuery();

             StatePojo state = new StatePojo();

             while (rs.next()) {

//                  state.setStateID(rs.getString("state_id"));

                  state.setStateName(rs.getString("state_name"));

                  stateList.add(state.getStateName());



             }



        } catch (SQLException e) {

             e.printStackTrace();

        } finally {

        	DatabaseConnection.closeCon(preparedStatement, rs, connection);

        }
        return stateList;



  }
	public List<String> getCities(String stateName) {

		Connection connection = DatabaseConnection.getConnection();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;

		List<String> citieList = new ArrayList<String>();

		try {



			ps = connection.prepareStatement("SELECT * FROM City where state_name=?");

			ps.setString(1, stateName);

			rs = ps.executeQuery();

			CityPojo city = new CityPojo();

			while (rs.next()) {

//				city.setStateID(rs.getString("city_id"));

				city.setCityName(rs.getString("city_name"));
				

				citieList.add(city.getCityName());

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}
		finally {
			DatabaseConnection.closeCon(ps, rs, connection);
		}
		return citieList; 
	}

}