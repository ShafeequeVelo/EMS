package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.pojo.RolePojo;

public class RoleOperation {
	DatabaseConnection dbConnection = new DatabaseConnection();
	
	public boolean isAdminAvailable() {
		
		Connection connection = dbConnection.getConnection();
		
		String query = "SELECT ROLEID FROM ROLE WHERE ROLENAME = ?";
		String query2 = "SELECT EMPID FROM EMPLOYEE WHERE ROLEID=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "ADMIN");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String roleIDAdmin = resultSet.getString("ROLEID");
				PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
				preparedStatement2.setString(1, roleIDAdmin);
				ResultSet resultSet2 = preparedStatement2.executeQuery();
				if(resultSet2.next()) {
					return true;
				}
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public RolePojo getRoleByID(String roleID) {
		String getRole = "SELECT * FROM ROLE WHERE ROLEID=?";
		RolePojo role = new RolePojo();
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(getRole);
			pstm.setString(1, roleID);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				role.setRoleID(rs.getString("RoleID"));
				role.setRoleName(rs.getString("RoleName"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return role;
	}

	public List<RolePojo> getAllRoles() {
		List<RolePojo> roles = new ArrayList<RolePojo>();
		String getRoles = "Select * from Role";
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(getRoles);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				RolePojo role = new RolePojo();
				role.setRoleID(rs.getString("RoleID"));
				role.setRoleName(rs.getString("RoleName"));
				roles.add(role);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roles;
	}

	public int createRole(RolePojo role) {
		UUIDGenerator id = new UUIDGenerator();
		String insertRole = "INSERT INTO role (RoleID, RoleName) VALUES(?, ?)";
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(insertRole);
			pstm.setString(1, id.getID());
			pstm.setString(2, role.getRoleName());
			int i = pstm.executeUpdate();
			if (i > 0) {
				return i;
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		return 0;
	}
}
