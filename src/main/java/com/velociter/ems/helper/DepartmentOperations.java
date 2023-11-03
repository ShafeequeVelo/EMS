package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.pojo.DepartmentPojo;


public class DepartmentOperations {
	DatabaseConnection dbConnection = new DatabaseConnection();

	public DepartmentPojo getDepartmentByID(String departmentID) {
		String getDepartment = "SELECT * FROM Department WHERE DEPARTMENTID=?";
		DepartmentPojo department = new DepartmentPojo();
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(getDepartment);
			pstm.setString(1, departmentID);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				department.setDepartmentID(rs.getString("DEPARTMENTID"));
				department.setDepartmentName(rs.getString("DepartmentName"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return department;
	}

	public List<DepartmentPojo> getAllDepartments() {
		List<DepartmentPojo> departments = new ArrayList<>();
		String getRoles = "Select * from Department";
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(getRoles);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				DepartmentPojo department = new DepartmentPojo();
				department.setDepartmentID(rs.getString("DepartmentID"));
				department.setDepartmentName(rs.getString("DepartmentName"));
				departments.add(department);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return departments;
	}

	public int createDepartment(DepartmentPojo department) {
		UUIDGenerator id = new UUIDGenerator();
		String insertRole = "INSERT INTO Department (DepartmentID, DepartmentName) VALUES(?, ?)";
		Connection connection = dbConnection.getConnection();
		try {
			PreparedStatement pstm = connection.prepareStatement(insertRole);
			pstm.setString(1, id.getID());
			pstm.setString(2, department.getDepartmentName());
			int i = pstm.executeUpdate();
			if (i > 0) {
				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

