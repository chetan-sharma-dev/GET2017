package oops_session3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Product {
	private int productId;
	private String productName;
	private double productCost; 
/*
 * containing all Unique product id's along with Product references
 * */
	private static HashMap<Integer,Product> allProductIds=new HashMap<Integer,Product>();
	
	public void setInAllProductIds(int productId)
	{
		allProductIds.put(productId,this);
	}
	
	public static boolean searchProductById(int productId)
	{
		return allProductIds.containsKey(productId);
	}
	public static Product getProductReference(int productId)
	{
		return allProductIds.get(productId);
	}
	
	public  int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductCost() {
		return productCost;
	}
	public void setProductCost(float cost) {
		this.productCost = cost;
	}
	

	public Product()
	{
		productId=0;
		productName=null;
		productCost=0;
		
	}
	
	public Product(int productId,String productName,float productCost)
	{
		this.productId=productId;
		this.productName=productName;
		this.productCost=productCost;
		this.setInAllProductIds(productId);
		
	}
	/* 
	 * initialization of all products objects
	 * */
	public static Product[] initializeProductDetails(String filePath,int noOfObjects)  {
			try{
				/*
				 * reading from product file
				 * */
				FileInputStream fileInput = new FileInputStream(filePath);
				BufferedReader bufferInput = new BufferedReader(new InputStreamReader(fileInput));
				String productDetails;
				Product[] productObject=new Product[noOfObjects];
				int productIndex=0;
				while ((productDetails = bufferInput.readLine()) != null) {
					/*
					 * splitting line read from product file 
					 * assigning values to variables 
					 * creating objects
					 * */
					String[] splitedProductDetails=productDetails.split("\\,");
					 int productId=Integer.parseInt(splitedProductDetails[0]);
					 String productName=splitedProductDetails[1];
					 float productCost=Float.parseFloat(splitedProductDetails[2]);
					 
					 productObject[productIndex]= new Product(productId,productName,productCost);
						productIndex++;
				}
				bufferInput.close();
				fileInput.close();
				
				return productObject;
			}
			catch(IOException e)
			{
				System.out.println(e);
				return new Product[0];
			}
	
	}

}
