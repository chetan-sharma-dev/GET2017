package com.metacube.facade;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.metacube.dao.BaseDao;
import com.metacube.dao.DaoFactory;
import com.metacube.enums.DBType;
import com.metacube.enums.EntityName;
import com.metacube.model.Product;

public class ProductFacade {
	/*
	 * getting productDao reference from daoFactory
	 */
	@SuppressWarnings("unchecked")
	private static BaseDao<Product> productDao = (BaseDao<Product>) DaoFactory.getDaoforEntity(EntityName.Product, DBType.InMemory);
	/*
	 * creating common object of scanner class
	 * */
	public static Scanner scanInput=new Scanner(System.in);
	
	/**
	 * @method takeStringInputWithValidation()
	 * method for taking user input along with string null check validation
	 * returning scanned string 
	 * */
	public String takeStringInputWithValidation(){
		String userInput="";
		/*
		 * taking user input until the valid string entered,
		 * if wrong input given error message shown
		 * */
		while(true)
		{
			userInput=takeStringInput();
			if(userInput.length()!=0)
			{
				return userInput;
			}
			else
			{
				System.out.println("Enter valid string input");
			}
		}
	}
	
	/**
	 * @method takeStringInput
	 * taking string input including null string 
	 * */
	public String takeStringInput()
	{
		return scanInput.nextLine();
	}
	/**
	 * @method takeDoubleInput()
	 * method taking input as string and after validating double input ,returning double value
	 * */
	public double takeDoubleInput()
	{
		double inputValue;
		/*
		 * taking input until valid positive double value entered 
		 * */
		while(true)
		{
			inputValue=parseAndValidateDoubleValue(takeStringInput());
			if(inputValue!=-1)
			{
				return inputValue;
			}
		}
	}
	
	/**
	 * @method parseAndValidateDoubleValue()
	 * parsing string into double and checking for positive double values validation
	 */
	public  double parseAndValidateDoubleValue(String inputStringValue)
	{
		try{
			double inputValue=Double.parseDouble(inputStringValue);
			if(inputValue>=0)
			{
				return inputValue;
			}
			else{
				throw new NumberFormatException();
			}
		}
		catch(NumberFormatException e)
		{
			System.out.println("Invalid value entered");
			return -1;
		}
		
	}
	
	/**
	 * @method getAllProducts()
	 * returning all product list
	 * */
	public List<Product> getAllProducts() {
		return productDao.getAllProductsList();
	}
	
	/**
	 * @method addNewProductInMemoryDao
	 * returning all product list
	 * */
	public void addNewProductInMemoryDao()
	{
		/*
		 * taking user input for product 
		 * */
		System.out.println("Enter Product Code:-");
		scanInput.nextLine();
		String productCode=takeStringInputWithValidation();
		System.out.println("Enter Product Name:-");
		String productName=takeStringInputWithValidation();
		System.out.println("Enter Product Cost :-");
		Double productCost=takeDoubleInput();
		/*
		 * getting product object for input values
		 * */
		Product productObject=new Product(productCode,productName,productCost);
		
		/*
		 * adding product in memoryDao
		 * */
		System.out.println(productDao.addNew(productObject.getProductCode(),productObject ));
	
	}
	
	/**
	 * @method deleteProductFromMemoryDao()
	 * method deleting product from cart
	 */
	public void deleteProductFromMemoryDao()
	{
		/*
		 * taking product code as input and calling deletion method of product dao
		 * */
		System.out.println("Enter Product Code which is to be deleted:-");
		String productCode=takeStringInputWithValidation();
		System.out.println(productDao.delete(productCode));
	}

	/**
	 * @method  updateProductDetails()
	 * updating product details in memory dao
	 * */
	public void updateProductDetails()
	{
		/*
		 * taking product details as input and calling updating it into memoryDao
		 * */
		System.out.println("Enter Product Code where the change has to be done:-");
		scanInput.nextLine();
		String productCode=takeStringInputWithValidation();
		System.out.println("Enter New Product Name:-");
		String productName=takeStringInputWithValidation();
		System.out.println("Enter New Product Cost :-");
		Double productCost=takeDoubleInput();
		Product productObject=new Product(productCode,productName,productCost);
		System.out.println(productDao.update(productObject.getProductCode(),productObject ));

	}

	/**
	 * @method printAllProductDetails()
	 * method printing allProductDetails
	 * */
	public void printAllProductDetails(List<Product> productsList)
	{	
		/*
		 * checking whether productList is having items or not
		 * if having items in list, iterating list and printing product details
		 * else, returning message on console 
		 * */
		if(productsList!=null)
		{
			Iterator<Product> itr=productsList.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next().toString());
			}
		}
		else
		{
			System.out.println("No Product Available in dao");
		}
	}

	/**
	 * @method showMenu()
	 * method showingMenu on console and according to user input call appropriate method 
	 * */
	public void showMenu(ProductFacade productFacadeObject)
	{
		
		String choice;
	
			System.out.println("-------------------Enter your choice----------------- \n"
					+ "1. Add New Product\n"
					+ "2. Show All Available Products\n"
					+ "3. Delete Product details \n"
					+ "4. Update Product details \n"
					+ "5. Exit \n"
					+ "-------------------------------------------------------");
			choice=scanInput.next();
			switch(choice)
			{
				case "1":
					System.out.println("------------Adding New Product in Dao-------------------");
					productFacadeObject.addNewProductInMemoryDao();
					System.out.println("--------------------------------------------------------");
					break;
				case "2":
					System.out.println("---------------All Available Products ------------------");
					productFacadeObject.printAllProductDetails(productDao.getAllProductsList());
					System.out.println("--------------------------------------------------------");
					break;
				case "3":
					System.out.println("---------------Deleting Product from Dao ------------------");
					productFacadeObject.deleteProductFromMemoryDao();
					System.out.println("--------------------------------------------------------");
					break;
				case "4":
					System.out.println("------------Updating Product details in Dao ------------");
					productFacadeObject.updateProductDetails();
					System.out.println("--------------------------------------------------------");
					break;
				case "5":
					System.out.println("---------------------Thank you--------------------------");
					return;
				
				default:System.out.println("Invalid Choice Entered");
			}
			showMenu(productFacadeObject);
		
	}
	/**
	 * Main Method of class
	 * */
	public static void main(String...s){
		
			ProductFacade productFacadeObject=new ProductFacade();
			productFacadeObject.showMenu(productFacadeObject);
	}
}
