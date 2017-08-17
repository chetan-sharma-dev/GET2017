package com.metacube.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import com.metacube.model.Product;

/**
 * @class InMemoryProductDao
 * Singleton for holding data in memory variables
 * */
public class InMemoryProductDao implements ProductDao {
	private static InMemoryProductDao inMemoryProductDaoObject;
	private HashMap<String,Product> productDetails;
	
/**
 * @constructor 
 * for initializing data members
 * */
	private InMemoryProductDao() {
		productDetails=new HashMap<String,Product>();
	}
	
/**
 * @method getInstance()
 * returning singleton class instance
 * using double checking mechanism for singleton class
 * */	
	public static InMemoryProductDao getInstance()
	{
		/*
		 *checking whether the object is having some reference or not
		 * */
		if(inMemoryProductDaoObject==null)
		{
			synchronized(InMemoryProductDao.class)
			{
				if(inMemoryProductDaoObject==null)
				{
					inMemoryProductDaoObject=new InMemoryProductDao();
				}
			}
		}
		return inMemoryProductDaoObject;
	}

/**
 * @method addNew()
 * method for adding new product in productDetails 
 * */

	public String addNew(String productCode,Product productObject) {
		/*
		 * checking whether the product is already available or not 
		 * if yes , returning message as already exist
		 * else , adding new product in productDetails HashMap
		 * */
		if(!isProductAvailableInDao(productCode))
		{
			productDetails.put(productCode,productObject);
			return "Product Successfully added in Dao";
		}
		else
		{
			return "Product already exist";
		}
	}

/**
* @method update()
 * method for updating product details already available in productDetails HashaMap
 * */
	public String update(String productCode,Product productObject) {
		/*
		 * checking product availability , 
		 * and accordingly updating in productDetails HashMap or showing Appropriate message
		 * */
		if(isProductAvailableInDao(productCode))
		{
			productDetails.replace(productCode, productObject);
			return "Product details updated Successfully in Dao";
		}
		else
		{
			return "product doesn't exist";
		}
	
	}

/**
 * @method delete()
 * method for deleting product from productDetails HashMap
 * */
	public String delete(String productCode) {
		/*
		 * checking product availability , 
		 * and accordingly deleting from productDetails HashMap or showing Appropriate message
		 * */
		if(isProductAvailableInDao(productCode))
		{
			productDetails.remove(productCode);
			return "Product entry deleted Successfully from Dao";
		}
		else
		{
			return "product doesn't exist";
		}
		
	}
/**
 * @method getAllProductList()
 * method returning all product list 
 * */

	public List<Product> getAllProductsList() {
		/*
		 * checking for productDetails size(), 
		 * if size > 0 , means there are some product in dao,
		 * then returning product list
		 * else , returning null
		 * */
		if(productDetails.size()>0)
			{
				return new ArrayList<Product>(productDetails.values());
			}
		else
			{
				return null;
			}
	}
	/**
	 * @method getAllProductList()
	 * private method returning all product reference according to product code 
	 * */

	private Product getProductObjectByProductCode(String productCode) {
		/*
		 * checking for productCode entry in productDetails 
		 * if found, then returning product object
		 * else, returning null
		 * */
		if(productDetails.containsKey(productCode))
		{
			return productDetails.get(productCode);
		}else{
			return null;
		}
	}
	
	/**
	 * @method isProductAvailableInDao()
	 * private method for checking whether product already exist or not 
	 * */

	private boolean isProductAvailableInDao(String productCode){
		/*
		 *	checking for productCode entry in productDetails 
		 *	if found, returning true
		 *	else, returning false
		 * */
		if(getProductObjectByProductCode(productCode)!=null)
		{
			return true;
		}else{
			return false;
		}
	}
	

}
