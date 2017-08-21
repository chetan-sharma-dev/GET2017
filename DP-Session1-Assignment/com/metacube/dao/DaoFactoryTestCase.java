package com.metacube.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.enums.DBType;
import com.metacube.enums.EntityName;
import com.metacube.model.Product;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

public class DaoFactoryTestCase {
	
	DaoFactory daoFactoryObject;
	BaseDao<Product> baseDaoObject ;
	@Before
	public void createObject(){
		daoFactoryObject=new DaoFactory();
	}
	
	@Test
	public void positiveTestCase(){
		baseDaoObject = (BaseDao<Product>) DaoFactory.getDaoforEntity(EntityName.Product, DBType.InMemory);
		assertEquals(true,baseDaoObject instanceof InMemoryProductDao);
		
	}
	
	@Test
	public void negativeTestCase(){
		baseDaoObject = (BaseDao<Product>) DaoFactory.getDaoforEntity(EntityName.Product, DBType.MySql);
		assertEquals(false,baseDaoObject instanceof InMemoryProductDao);
	}
	
	
}
