package dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Product;

/**
 * @class InMemoryProductDao
 * Singleton class for storing data in memory itself
 * 
 * */
public class InMemoryProductDao implements ProductDao {
	/*
	 * singleton reference created
	 * */
	private static InMemoryProductDao inMemoryProductDaoObject;
	//list of all Product Objects Stored  
	private List<Product> productDetails;
	

	/*
	 * @constructor 
	 * initializing all variables
	 * */
	private InMemoryProductDao() {
		productDetails=new ArrayList<Product>();
		addProduct("1001","Product A",1000.00);
		addProduct("1002","Product B",2000.00);
		addProduct("1003","Product C",3000.00);
		addProduct("1004","Product D",4000.00);
			
	}
	
	public static InMemoryProductDao getInstance()
	{
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
	
	public void addProduct(String productCode,String productName,Double productCost)
	{
		Product productObject=new Product();
		productObject.setProductCode(productCode);
		productObject.setProductName(productName);
		productObject.setProductCost(productCost);
		create(productObject);
	}

	public void create(Product productObject) {
		productDetails.add(productObject);
	}

	public void update(Product productObject) {
		Iterator<Product> iteratorObject = productDetails.iterator();
		int index = 0;
		while (iteratorObject.hasNext()) {
			if (iteratorObject.next().getProductCode() == productObject.getProductCode()) {
					productDetails.set(index, productObject);
					break;
			}
			index++;
		}
	}

	public void delete(Product productObject) {
		productDetails.remove(productObject);
	}


	public List<Product> getAll() {
		return productDetails;
	}


	public Product getProductObjectByProductCode(String productCode) {
		Iterator<Product> iteratorObject = productDetails.iterator();
		int index = 0;
		while (iteratorObject.hasNext()) {
			if ((iteratorObject.next().getProductCode()).compareTo(productCode)==0) {
				return productDetails.get(index);
			}
			index++;
		}
		
		return null;
	}

}
