package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.velociter.ems.pojo.RegistrationPojo;
import com.velociter.ems.pojo.TaskPojo;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;

public class TaskOperations {
	
	DatabaseConnection databaseConnection = new DatabaseConnection();
	
	public void createTask(TaskPojo taskPojo, String mgrID) {
				
		Connection connection = databaseConnection.getConnection();
		
		DateTimeProvider dateTime = new DateTimeProvider();
		
		String query = "INSERT INTO Tasks (task, taskDesc, taskStatus, taskAssignee, taskAssigner, creationTime, updationTime) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement prparedStatement;
		try {
			prparedStatement = connection.prepareStatement(query);
			
			prparedStatement.setString(1, taskPojo.getTask());
			prparedStatement.setString(2, taskPojo.getTaskDesc());
			prparedStatement.setString(3, "OPEN");
			prparedStatement.setString(4, "NOT ASSIGNED");
			prparedStatement.setString(5, mgrID);
			prparedStatement.setString(6, dateTime.getCurrentDateTime().toString());
		    prparedStatement.setString(7, "null");
			
			
			prparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public List<TaskPojo> getTaskList(){
		
	 	 Connection connection = databaseConnection.getConnection();
	 	 
	 	 
	 	 List<TaskPojo> taskList = new ArrayList<TaskPojo>();
	 	 
	 	 String query = "SELECT * FROM Tasks";
	 	 
	 	 try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {

				TaskPojo taskPojo = new TaskPojo();
				
				taskPojo.setTask(resultSet.getString("Task"));
				taskPojo.setTaskDesc(resultSet.getString("TaskDesc"));
				taskPojo.setStatus(resultSet.getString("TaskStatus"));
				taskPojo.setAssignee(resultSet.getString("TaskAssignee"));
				taskPojo.setAssigner(resultSet.getString("TaskAssigner"));
				taskPojo.setTaskID(resultSet.getString("TaskID"));
				
				taskList.add(taskPojo);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return taskList;
	}
	
	public int updateTask(TaskPojo taskPojo){
		
		Connection connection = databaseConnection.getConnection();
		
		String query = "UPDATE TASKS SET taskassignee=? WHERE taskid =?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, taskPojo.getAssignee());
			preparedStatement.setString(2, taskPojo.getTaskID());
			
			int i = preparedStatement.executeUpdate();
			if(i > 0) {
				return i;
			}
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
		
	}
		
}
