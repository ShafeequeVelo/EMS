package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.pojo.RolePojo;

public class RoleOperation {

	DatabaseConnection databaseConnection = new DatabaseConnection();
	public boolean isAdminAvailable() {
		Connection connection = databaseConnection.getConnection();
		String query = "SELECT ROLEID FROM ROLE WHERE ROLENAME =?";
		String query2 = "SELECT EMPID FROM EMPLOYEE WHERE ROLEID=?";
		
		try{
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "ADMIN");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String AdminRoleId = resultSet.getString("ROLEID");
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
				preparedStatement2.setString(1, AdminRoleId);
				ResultSet resultSet2 = preparedStatement2.executeQuery();
				if(resultSet2.next()) {
					return true;
				}
				
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
		return false;
				
	}
	public RolePojo getRoleByID(String roleID) {
		String Role = "SELECT * FROM ROLE WHERE ROLEID=?";
		RolePojo rolePojo = new RolePojo();
		Connection connection = databaseConnection.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Role);
			preparedStatement.setString(1, roleID);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				rolePojo.setRoleID(rs.getString("RoleID"));
				rolePojo.setRoleName(rs.getString("RoleName"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rolePojo;
	}
	
	

}
