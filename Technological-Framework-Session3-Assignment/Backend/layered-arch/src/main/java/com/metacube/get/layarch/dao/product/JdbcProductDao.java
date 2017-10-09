package com.metacube.get.layarch.dao.product;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.metacube.get.layarch.dao.GenericJdbcDao;
import com.metacube.get.layarch.model.Product;

/**
 * @class
 * class for dealing with product dao
 * */
@Component("productDao")
public class JdbcProductDao extends GenericJdbcDao<Product, Integer> implements ProductDao
{

	private String tableName = "Product";
	
	public JdbcProductDao() {
		
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	@Override
	protected String getTableName() {
		return tableName;
	}
	
	@Override 
	protected Product extractResultSetRow(final ResultSet resultSet)
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

	@Override 
	protected String getPrimaryKeyColoumnName()
	{
		return "id";
	}
}
