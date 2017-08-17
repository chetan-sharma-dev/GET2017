package controller;

import java.util.List;

import facade.ProductFacade;

/**
 * @class ProductController 
 * class for handling product related input output
 * */
public class ProductController {
	/*
	 * instantiating all variables required 
	 * */
	private static ProductController productControllerObject;
	private static ProductFacade productFacadeObject;
	private  List<String> allProductslist;
	private  List<String> allProductsCodeslist;
	
	/**
	 * @constructor ProductController()
	 * initializing DataMembers of class in private constructor
	 * */
	private ProductController() {
		productFacadeObject=new ProductFacade();
		allProductslist=productFacadeObject.getAllProducts();
		allProductsCodeslist=productFacadeObject.getAllProductsCodesList();
	}
	
	/**
	 * @method getInstance()
	 * method for getting instance of ProductController class using double checking mechanism for singleton class 
	 * */
	public static ProductController getInstance()
	{
		if(productControllerObject==null)
		{
			synchronized (ProductController.class) {
				if(productControllerObject==null){
					productControllerObject=new ProductController();
				}
				
			}
		}
		return productControllerObject;
	}

	
	public List<String> getAllProductslist() {
		return allProductslist;
	}

	public void setAllProductslist(List<String> allProductslist) {
		this.allProductslist = allProductslist;
	}

	public List<String> getAllProductsCodeslist() {
		return allProductsCodeslist;
	}

	public void setAllProductsCodeslist(List<String> allProductsCodeslist) {
		this.allProductsCodeslist = allProductsCodeslist;
	}

		 
}
