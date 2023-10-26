package com.velociter.ems.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnection {
	
	private Connection dbConnection;           //connection is an interface

	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //registering and loading the driver
			dbConnection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "EMS", "system"); //establishing connection
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return dbConnection;
	}

}

