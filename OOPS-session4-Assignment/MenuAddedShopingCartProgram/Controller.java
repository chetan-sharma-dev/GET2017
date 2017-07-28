package oopssession4;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;



public class Controller implements Action{
	public static Product[] productObject;
	public static Promotion[] productPromotionObject;
	public static Promotion[] orderPromotionObject;
	public static Order orderObject;
	public static PromotionResult promotionResultObject;
	public static BillGeneration generateBillObject;
	/**
	 * creating single scanner object
	 * */
	public static Scanner scanner=new Scanner(System.in);
	/**
	 * method for printing product details from already initailized objects
	 * */
	public static void printProductDetails(Product[] productObject)
	{
	
		int noOfObjects=productObject.length;
		/*
		 * getting productId, name ,cost from product class for each product
		 * */
		for(int i=0;i<noOfObjects;i++)
		{
			System.out.println(productObject[i].getProductId()+"\t\t\t"+productObject[i].getProductName()+"\t\t\t"+productObject[i].getProductCost());
		}
	}
	
	/**
	 * method checking promotion type and returning appropriate class object
	 * */
	public static Promotion getPromotionObject(String[] promotionDetails)
	{
		String promotionType=promotionDetails[0];
		String promotionDiscount=promotionDetails[1];
		String productListOrMinThresholdAmount=promotionDetails[2];
		
		if(ShopingCartAllConstants.PRODUCT_FIXED_AMOUNT_PROMOTION.compareTo(promotionType)==0)
		{
			return new ProductFixedAmountPromotion(promotionDiscount,productListOrMinThresholdAmount);
			
		}
		else if(ShopingCartAllConstants.PRODUCT_FIXED_PERCENT_PROMOTION.compareTo(promotionType)==0)
		{
			return new ProductFixedPercentPromotion(promotionDiscount,productListOrMinThresholdAmount);
			
		}
		else if(ShopingCartAllConstants.ORDER_FIXED_AMOUNT_PROMOTION.compareTo(promotionType)==0)
		{
			return new OrderFixedAmountPromotion(promotionDiscount,productListOrMinThresholdAmount);
			
		}
		else if(ShopingCartAllConstants.ORDER_FIXED_PERCENT_PROMOTION.compareTo(promotionType)==0)
		{
			return new OrderFixedPercentPromotion(promotionDiscount,productListOrMinThresholdAmount);
		}
		else
			return null;
	
		
	}
	
	/**
	 * initializing all promotion details according to their type
	 * */
	
	public static Promotion[] initializePromotionDetails(String filePath,int noOfPromotions)
	{
		try{
			FileInputStream fileInput = new FileInputStream(filePath);
			BufferedReader bufferInput = new BufferedReader(new InputStreamReader(fileInput));
			String promotionDetails;
			Promotion[] promotionObject=new Promotion[noOfPromotions];
			int promotionIndex=0;
			while ((promotionDetails = bufferInput.readLine()) != null) {
				/*
				 * splitting promotion details in , promotion type, discount and product code list/minimum threshold value
				 * */
				String[] splitedPromotionDetails=promotionDetails.split("\\,");
				Promotion promotionReference=getPromotionObject(splitedPromotionDetails);
				if(promotionReference!=null)
					promotionObject[promotionIndex++]=promotionReference;
				else
					{
						bufferInput.close();
						fileInput.close();
						throw new NullPointerException("invalid entries in file");
					}
			}
			
			bufferInput.close();
			fileInput.close();
			/*
			 * returning initialized object
			 * */
			return promotionObject;
		}
		catch(IOException e)
		{
			System.out.println(e);
			return new Promotion[0];
		}
		catch(NullPointerException e)
		{
			System.out.println(e);
			return new Promotion[0];
		}
	}

/**
 *method to print Promotion Details
 * */
	public static void printPromotionDetails(Promotion[] promotionObject)
	{
		int noOfObjects=promotionObject.length;
		for(int i=0;i<noOfObjects;i++)
		{ 
			String promomotionType=promotionObject[i].getClass().getName().split("\\.")[1];
			double promomotionDiscount=promotionObject[i].discount;
			
			System.out.print(promomotionType+"\t"+promomotionDiscount+"\t\t\t");
			/*
			 * checking for promotion type and accordingly printing values
			 * */
			if(promotionObject[i].isOrderFixed)
			{
				System.out.println(promotionObject[i].minimumThresoldAmount);
			}
			else
			{
				System.out.println(promotionObject[i].discountedProductList);
			}
		}
	}

	/**
	 * taking input from user along with validation
	 * */
	public static int getInput()
	{
		try
		{
			String user_input=scanner.next();
			int value=Integer.parseInt(user_input);
			if(value>0)
				return value ;
			else 
				throw new Exception();
		}
		catch(Exception e)
		{
			System.out.println(ShopingCartAllConstants.INVALID_INPUT);
			return -1;
		}
	}

	/**
	 * Taking user product choices along with validation
	 * */
	public static Order takeUserInputs()
	{
		System.out.println("-------------------------------------------------------------------------------");
		
		int noOfItems;
		/*
		 * creating order object and returning  it at last
		 * */
		Order userOrderObject=new Order();
		/*
		 * taking valid no of Product Items to buy
		 * */
		while(true)
		{
			System.out.print("\nEnter no of product items to buy");
			noOfItems=getInput();
			if(noOfItems>0)
			{
				break;
			}
			
		}
		
		
		/*
		 * For valid product item numbers,
		 *  taking valid product id and quantity combination   
		 * */
		for(int i=1;i<=noOfItems;i++)
		{
			System.out.print("Enter product "+i+" id ");
			int productId=getInput();
			if(productId>0)
			{ 
				boolean isProductFound=Product.searchProductById(productId);
				if(isProductFound)
				{	
					System.out.print("Enter product quantity ");
					int productQunantity=getInput();
					if(productQunantity>0)
					{
						/*
						 * checking for repeated product input 
						 * */
						if(userOrderObject.getOrderedProductList().containsKey(productId))
						{
							int currentQuantity=userOrderObject.getOrderedProductList().get(productId);
							productQunantity=currentQuantity+productQunantity;
						}
							userOrderObject.setOrderedProductList(productId, productQunantity);
						
					}
					else
					{
						i--;
					}
				}
				else 
				{
					System.out.println("Enter valid productId ");
					i--;
				}

			}
			else
			{
				i--;
			}
		}
		/*
		 * returning order object
		 * */
		return userOrderObject;
	}

	/**
	 * getting bill list as argument
	 * and printing bill to console
	 * */
	public static void printBill(BillGeneration generateBillObject)
	{
		List<String> orderBill=generateBillObject.getOrderBill();
		if(orderBill.size()>0)
		{
			Iterator<String> itr =orderBill.iterator();
			/*
			 * iterating list and printing it to console
			 * */
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
		}
		else
		{
			System.out.println("No product Ordered");
		}
	}
	

	public static void initializeAllVariables() throws IOException
	{
		/*
		 *  initialization of product objects 
		 * */
		String filePath=ShopingCartAllConstants.PRODUCT_LIST_CSV_FILE_PATH;
		int noOfProducts=FileOperations.countNoOfLinesInFile(filePath);
		productObject=Product.initializeProductDetails(filePath, noOfProducts);
		
	
		/*
		 * initialization of product promotions
		 * */
		filePath=ShopingCartAllConstants.PRODUCT_PROMOTION_CSV_FILE_PATH;
		int noOfProductPromotions=FileOperations.countNoOfLinesInFile(filePath);
		productPromotionObject=initializePromotionDetails(filePath, noOfProductPromotions);
		
		/*
		 * printing and initialization of order promotions
		 * */
		filePath=ShopingCartAllConstants.ORDER_PROMOTION_CSV_FILE_PATH;
		int noOfOrderPromotions=FileOperations.countNoOfLinesInFile(filePath);
		orderPromotionObject=initializePromotionDetails(filePath, noOfOrderPromotions);
		
		
	}

	@Override
	public void performAction(String displayName) {

		try {
			initializeAllVariables();
			if(productObject!=null&&productPromotionObject!=null&&orderPromotionObject!=null)
			{	
					
				switch(displayName)
				{
					case "Display Product List":
						System.out.println("\nAvailable  products  ");
						System.out.println("-------------------------------------------------------------------------------");
						System.out.println("Product Id \t\t Product Name \t\t Product cost");
						System.out.println("-------------------------------------------------------------------------------");
						printProductDetails(productObject);
						System.out.println("-------------------------------------------------------------------------------");
						break;
					case "Display Product Promotion":
						System.out.println("\nAvailable  product promotions ");
						System.out.println("-------------------------------------------------------------------------------");
						System.out.println("ProductPromotionType \t\t Discount \t\t Product code lists");
						System.out.println("-------------------------------------------------------------------------------");
						printPromotionDetails(productPromotionObject);
						System.out.println("-------------------------------------------------------------------------------");
						break;
						
					case "Display Order Promotion":
						System.out.println("\nAvailable order promotions ");
						System.out.println("-------------------------------------------------------------------------------");
						System.out.println("OrderPromotionType \t\t Discount \t\t Minimum purchase amount");
						System.out.println("--------------------------------------------------------------------------------");
						printPromotionDetails(orderPromotionObject);
						System.out.println("-------------------------------------------------------------------------------");
						break;
					case "Order Products":
						orderObject=takeUserInputs();
						break;
					case "Display Bill":
						if(orderObject!=null)
						{
							promotionResultObject=new PromotionResult();
							promotionResultObject.calculatePromotionDiscounts(orderObject, productPromotionObject, orderPromotionObject);
							generateBillObject=new BillGeneration();
							generateBillObject.generateBill(promotionResultObject,orderObject, productPromotionObject, orderPromotionObject);
							printBill(generateBillObject);
							System.out.println("-------------------------------------------------------------------------------");
						
						}
						else
							System.out.println("No product Ordered");
						break;
					case "Exit":
						System.out.println("-------------------------------------------------------------------------------");
						System.out.println("\t\t\t Thank you for shopping");
						System.out.println("-------------------------------------------------------------------------------");
						System.exit(0);
				}
				
			}
			else
			{
				System.out.println("\n Invalid file entries ");
				System.exit(0);
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
