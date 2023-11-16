//package com.velociter.ems.helper;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class DatabaseConnectionImpl implements DatabaseConnection {
//
//	@Override
//	public Connection getConnection() {
//		Connection connection = null;
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); // registering and loading the driver
//			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "EMS", "system"); // establishing
//																												// connection
//		} catch (ClassNotFoundException ce) {
//			ce.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return connection;
//	}
//
//}
