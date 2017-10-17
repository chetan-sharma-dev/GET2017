package com.metacube.shoppingcart.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnectionFactory {
	Connection getConnection() throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingcart", "root", "user");
			return con;
		}
		catch (Exception e)
		{
			System.out.println(e);
			throw e;
		}
	}
}
