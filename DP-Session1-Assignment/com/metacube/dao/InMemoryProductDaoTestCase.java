package com.metacube.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.model.Product;

public class InMemoryProductDaoTestCase {
	
	InMemoryProductDao inMemoryProductDaoObject;
	Product productObject;
	@Before
	public void createObject()
	{
		inMemoryProductDaoObject=InMemoryProductDao.getInstance();
	}
	@Test
	public void positiveTestCaseForAddMethod(){
		productObject=new Product("1001","Product A",1000.00);
		String actualMessage=inMemoryProductDaoObject.addNew(productObject.getProductCode(), productObject);
		String expectedMessage="Product Successfully added in Dao";
		assertEquals(expectedMessage,actualMessage);
	}
	
	@Test
	public void negativeTestCaseForAddMethod(){
		productObject=new Product("1001","Product A",1000.00);
		String actualMessage=inMemoryProductDaoObject.addNew(productObject.getProductCode(), productObject);
		String expectedMessage="Product already exist";
		assertEquals(expectedMessage,actualMessage);
		
	}
	
	@Test
	public void positiveTestCaseForDeleteMethod(){
	
		String actualMessage=inMemoryProductDaoObject.delete("1001");
		String expectedMessage="Product entry deleted Successfully from Dao";
		assertEquals(expectedMessage,actualMessage);
	}
	
	@Test
	public void negativeTestCaseForDeleteMethod(){
		String actualMessage=inMemoryProductDaoObject.delete("1001");
		String expectedMessage="product doesn't exist";
		assertEquals(expectedMessage,actualMessage);
		
	}
	
	@Test
	public void positiveTestCaseForUpdateMethod(){
	
		productObject=new Product("1001","Product B",2000.00);
		String actualMessage=inMemoryProductDaoObject.update(productObject.getProductCode(), productObject);
		String expectedMessage="Product entry deleted Successfully from Dao";
		assertEquals(expectedMessage,actualMessage);
	}
	
	@Test
	public void negativeTestCaseForUpdateMethod(){
		productObject=new Product("1002","Product B",2000.00);
		String actualMessage=inMemoryProductDaoObject.update(productObject.getProductCode(), productObject);
		String expectedMessage="product doesn't exist";
		assertEquals(expectedMessage,actualMessage);
		
	}
	
}
