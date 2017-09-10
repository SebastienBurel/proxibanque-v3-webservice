package com.gtm.projectwebservice.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class AbstractDAO {
	
	private final static String CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	/*private final static String HOSTNAME = "localhost";
	private final static int PORT = 3306;
	private final static String DBNAME = "proxidb";*/
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";
	private final static String URL = "jdbc:mysql://localhost:3306/proxidb?useSSL=true&useLegacyDatetimeCode=false&serverTimezone=America/New_York";
	
	/**
	 * Get sql connection to database
	 * @return Connection
	 */
	public Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName(CLASS_NAME);
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//connection = DriverManager.getConnection("jdbc:mysql://"+HOSTNAME+":"+PORT+"/"+DBNAME, USERNAME, PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}

}
