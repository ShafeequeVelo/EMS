//package com.velociter.ems.helper;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.velociter.ems.pojo.CityPojo;
//import com.velociter.ems.pojo.StatePojo;
//
//public class GetCityState {
//	
//	DatabaseConnection dbcon = new DatabaseConnection();
//
//	public List<String> getState() {
//        Connection connection = dbcon.getConnection();
//        List<String> state = new ArrayList<String>();
//        try {
//
//             PreparedStatement ps = connection.prepareStatement("SELECT * FROM STATES");
//             ResultSet rs = ps.executeQuery();
//             StatePojo statePojo = new StatePojo();
//             while (rs.next()) {
//            	 statePojo.setStateCode(rs.getString("state_Id"));
//            	 statePojo.setStateName(rs.getString("state_Name"));
//                 state.add(statePojo.getStateName());
//
//             }
//
//        } catch (SQLException e) {
//             e.printStackTrace();
//       
//        }
//  
//        
//        return state;
//
//  }
//	public List<String> getCities(String stateName) {
//
//		Connection connection = dbcon.getConnection();
//
//		List<String> citieList = new ArrayList<String>();
//
//		try {
//
//
//
//			PreparedStatement ps = connection.prepareStatement("SELECT * FROM City where state_Name=?");
//
//			ps.setString(1, stateName);
//
//			ResultSet rs = ps.executeQuery();
//
//			CityPojo city = new CityPojo();
//
//			while (rs.next()) {
//
//				city.setStateCode(rs.getString("city_id"));
//
//				city.setCityName(rs.getString("city_name"));
//				
//
//				citieList.add(city.getCityName());
//
//			}
//
//		} catch (SQLException e) {
//
//			e.printStackTrace();
//
//		}
//		return citieList; 
//	}
//
//}
//
//
//
