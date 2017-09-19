package com.metacube.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @class 
 * class deals with database connections
 * */
public class JdbcMysqlConnection {
	   static final String JDBC_MYSQL_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String MYSQL_DB_URL = "jdbc:mysql://localhost/library_information_system";
	   static final String USER_ID = "root";
	   static final String USER_PASSWORD = "root";
	   private Connection connectionObject;
	   
	/**
	 * @method getConnection
	 * method return connection object for given database attributes
	 * */
	public Connection getConnection() {
		try {
			Class.forName(JDBC_MYSQL_DRIVER);
			connectionObject = DriverManager.getConnection(MYSQL_DB_URL, USER_ID, USER_PASSWORD);
			return connectionObject;
		} catch (ClassNotFoundException e) {
			System.out.println("Class not found" + e);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
 
}
