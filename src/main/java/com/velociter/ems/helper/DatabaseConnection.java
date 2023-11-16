package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection dbConnection; // connection is an interface

	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // registering and loading the driver
			dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "EMS", "system"); // establishing
																												// connection
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return dbConnection;
	}

	public static void closeCon(PreparedStatement preparedStatement, ResultSet resultSet, Connection connection) {

		try {

			if (connection != null && connection.isClosed()) {

				connection.close(); 
				}

			if (preparedStatement != null && preparedStatement.isClosed()) {

				preparedStatement.close();
			}

			if (resultSet != null && resultSet.isClosed()) {

				resultSet.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}
	
	public static void closeCon(PreparedStatement preparedStatement, Connection connection) {

		try {

			if (connection != null && connection.isClosed()) {

				connection.close(); 
				}

			if (preparedStatement != null && preparedStatement.isClosed()) {

				preparedStatement.close();
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

	}

}
