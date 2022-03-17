package com.niko.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getConnectionToDB() {
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("postgresql register");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/blog", "postgres", "admin");
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Connection fail");
			e.printStackTrace();
		} if (connection != null) {
			System.out.println("Connection made to DB");
		}
		return connection;
	}

}
