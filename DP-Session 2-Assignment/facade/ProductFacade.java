package facade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Product;
import dao.BaseDao;
import factory.DaoFactory;
import enums.DBType;
import enums.EntityName;
/**
 * @class 
 * class handling product business logics
 * */
public class ProductFacade {
/**
 * @method getAllProducts()
 * method returning allProduct informations
 * */
	public List<String> getAllProducts() {
		BaseDao<Product> productDao = (BaseDao<Product>) DaoFactory.getDaoforEntity(EntityName.Product, DBType.InMemory);
		/*
		 * getting product object List and iterating each product 
		 * each product information is added in one string and added in list 
		 * at last returning list 
		 * */
		List<Product> productList=productDao.getAll();
		List<String> productListString=new ArrayList<String>();
		Iterator<Product> iterateList=productList.iterator();
		while(iterateList.hasNext())
		{
			productListString.add(iterateList.next().toString());
		}
		return productListString;
	}
/**
 * @method getAllProductsCodesList()
 * returning all Product code lists
 * */	
	public List<String> getAllProductsCodesList() {
		BaseDao<Product> productDao = (BaseDao<Product>) DaoFactory.getDaoforEntity(EntityName.Product, DBType.InMemory);
		/*
		 * getting product object List and iterating each product 
		 * each product Code added in list and returning list at last 
		 * */
		List<Product> productList=productDao.getAll();
		List<String> productListString=new ArrayList<String>();
		Iterator<Product> iterateList=productList.iterator();
		while(iterateList.hasNext())
		{
			productListString.add(iterateList.next().getProductCode());
		}
		return productListString;
	}
	
}
