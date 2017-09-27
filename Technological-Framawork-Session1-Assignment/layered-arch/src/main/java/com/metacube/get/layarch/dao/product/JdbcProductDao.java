package com.metacube.get.layarch.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.metacube.get.layarch.dao.GenericJdbcDao;
import com.metacube.get.layarch.model.Product;


public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements ProductDao
{

	@Override protected String getTableName()
	{
		return "Product";
	}

	@Override protected Product extractResultSetRow(final ResultSet resultSet)
	{
		Product product = new Product();


		try
		{
			product.setId(resultSet.getInt("id"));
			product.setName(resultSet.getString("name"));
			product.setPrice(resultSet.getInt("price"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}


		return product;
	}

	@Override protected String getPrimaryKeyColoumnName()
	{
		return "id";
	}
}
