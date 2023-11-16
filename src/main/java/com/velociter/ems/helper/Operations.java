package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.pojo.DesignationPojo;

public class Operations {

	DatabaseConnection databaseConnection = new DatabaseConnection();
	
	public  String getDesignation(String empid){
		String designation = null;
		try {
			Connection connection = databaseConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement
					("Select designation from emp_designation where empid=?");
			
			preparedStatement.setString(1, empid);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				designation = resultSet.getString("designation");
			}
		}catch (SQLException e) {

			e.printStackTrace();
		}
		return designation;
		
	}
	public List<String> getDesignationForAdmin(String empid) {

		Connection connection = databaseConnection.getConnection();

		List<String> designationList = new ArrayList<String>();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DESIGNATION WHERE DESIGNATIONID = 2");

			ResultSet resultSet = preparedStatement.executeQuery();

			

			while (resultSet.next()) {
				DesignationPojo designationPojo = new DesignationPojo();
				
				designationPojo.setDesignationID(resultSet.getString("designationId"));
				designationPojo.setDesignationName(resultSet.getString("designationName"));
				designationList.add(designationPojo.getDesignationName());
			}

		} catch (SQLException e) {

			e.printStackTrace();

		} 


		return designationList;

	}
	
	
	
	public String getEmpDesignation(String empID) throws SQLException {
		
		Connection connection = databaseConnection.getConnection();
		
		DesignationPojo designationPojo = new DesignationPojo();
		
		String empDesignation = null;
		
		PreparedStatement preparedStatement = connection.prepareStatement(
				"select * from emp_Designation WHERE empid = ?");
		
		preparedStatement.setString(1, empID);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		try {
			if(resultSet.next()){
				
				empDesignation = resultSet.getString("Designation");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empDesignation;
		
	}
	
	
	
	public List<String> getDesignationForManager() {

		Connection connection = databaseConnection.getConnection();

		List<String> designationList = new ArrayList<String>();

		try {

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DESIGNATIONS WHERE DESIGNATION_ID > 2");

			ResultSet resultSet = preparedStatement.executeQuery();

			DesignationPojo designationsPojo = new DesignationPojo();

			while (resultSet.next()) {

				designationsPojo.setDesignationID(resultSet.getString("designationId"));

				designationsPojo.setDesignationName(resultSet.getString("designation"));

				designationList.add(designationsPojo.getDesignationName());

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return designationList;

	}
	
	
}
