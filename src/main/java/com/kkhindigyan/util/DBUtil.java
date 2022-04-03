package com.kkhindigyan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String DB_DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
	private static final String DB_USERNAME="root";
	private static final String DB_PASSWORD="root";
	private static final String DB_URL ="jdbc:mysql://localhost:3306/test";
	
	private static Connection connection = null;
	
	static {
		try {
			//1.Register the JDBC driver
			Class.forName(DB_DRIVER_CLASS);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getMySQLConnection() {
		return connection;
	}
}
