package com.metacube.get.layarch.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class JdbcConnectionFactory
{
	Connection getConnection() throws Exception
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/product_database", "chetan", "chetanp");
			return con;
		}
		catch (Exception e)
		{
			System.out.println(e);
			throw e;
		}
	}
}
