package com.metacube.model;
/**
 * @class Product
 * class having all product parameters 
 * */
public class Product extends BaseEntity {
	private String productCode;
	private String productName;
	private Double productCost;
	
	public Product() {
		
	}
	
	/*
	 * parameterized constructor initializing product properties
	 * */
	public Product(String productCode,String productName,Double productCost){
		this.productCode=productCode;
		this.productName=productName;
		this.productCost=productCost;
	}

	/*
	 * getter and setter methods for product properties 
	 * */
	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductCost() {
		return productCost;
	}

	public void setProductCost(Double productCost) {
		this.productCost = productCost;
	}
	
	@Override
	public String toString() {
		
		return productCode+"--->"+productName+"--->"+productCost;
	}
		
}
