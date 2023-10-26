package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskOperations {
	
	DatabaseConnection databaseConnection = new DatabaseConnection();
	
	public String CreateTask(String taskName, String taskDesc) throws SQLException {
	
		Connection connection = databaseConnection.getConnection();
		
		String query = null;
		
		PreparedStatement prparedStatement = connection.prepareStatement("query");
		
		String CreatedTask = null;
		return CreatedTask;
		
	}

}
