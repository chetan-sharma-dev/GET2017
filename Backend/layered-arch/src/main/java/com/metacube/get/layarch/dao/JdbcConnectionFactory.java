package com.metacube.get.layarch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @class
 * class returning JdbcConnectionFactory Object
 * */
public class JdbcConnectionFactory
{
	Connection getConnection() throws Exception
	{
		try
		{
			/**
			 * 
			 * */
			Class.forName("com.mysql.jdbc.Driver");
			String jdbcUrl="jdbc:mysql://localhost:3306/user_database";
			String userName="chetan";
			String userPassword="chetan";
			
			Connection con = DriverManager.getConnection(jdbcUrl,userName , userPassword);
			return con;
		}
		catch (Exception e)
		{
			System.out.println(e);
			throw e;
		}
	}
}
