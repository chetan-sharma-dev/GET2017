package com.metacube.get.layarch.dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @class
 * abstract class GenericJdbcDao implementing AbstractDao and defining it's methods 
 * and providing extra methods 
 * */
public abstract class GenericJdbcDao<T, ID extends Serializable> implements AbstractDao<T,ID>
{
	/**
	 * creating JDBC connection object
	 * */
	JdbcConnectionFactory connectionFactory = new JdbcConnectionFactory();

	protected abstract String getTableName();
	protected abstract T extractResultSetRow(ResultSet resultSet);
	protected abstract String getPrimaryKeyColoumnName();

	/**
	 * @method 
	 * method to save data in database
	 * */
	public <S extends T> S save(final S entity)
	{
		return null;
	}

	/**
	 * @method findOne()
	 * method for finding one record from database table using id 
	 * */
	public T findOne(final ID primaryKey)
	{
		try {
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName() + " where " + getPrimaryKeyColoumnName() +" = '" + primaryKey + "'");
			while(resultSet.next()) {
				return extractResultSetRow(resultSet);
			}
			return null;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 * @method findAll()
	 * method for finding All records from database table 
	 * */
	public Iterable<T> findAll ()
	{
		try {
			
			Connection connection = connectionFactory.getConnection();
			Statement stmt = connection.createStatement();
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM " + getTableName());
			List<T> productList = new ArrayList<>();
			while(resultSet.next()) {
				productList.add(extractResultSetRow(resultSet));
			}
			return productList;

		} catch (Exception e) {
			System.out.println(e);
			return Collections.emptyList();
		}

	}
	
	/**
	 * @method 
	 * method for counting no of records 
	 * */

	public Long count()
	{
		return null;
	}
	
	
	/**
	 * @method 
	 * method for deleting entity form database table 
	 * */

	public void delete(final T entity)
	{

	}

	/**
	 * @method 
	 * method for checking whether the records having the id is exist or not
	 * */

	public boolean exists(final ID primaryKey)
	{
		return false;
	}
}
