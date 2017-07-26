package oops_session3;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;



public class Main {
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
		System.out.println("Available products ");
		/*
		 * getting productId, name ,cost from product class for each product
		 * */
		for(int i=0;i<noOfObjects;i++)
		{
			System.out.println(productObject[i].getProductId()+","+productObject[i].getProductName()+","+productObject[i].getProductCost());
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
		
		if(AllConstants.PRODUCT_FIXED_AMOUNT_PROMOTION.compareTo(promotionType)==0)
		{
			return new ProductFixedAmountPromotion(promotionDiscount,productListOrMinThresholdAmount);
			
		}
		else if(AllConstants.PRODUCT_FIXED_PERCENT_PROMOTION.compareTo(promotionType)==0)
		{
			return new ProductFixedPercentPromotion(promotionDiscount,productListOrMinThresholdAmount);
			
		}
		else if(AllConstants.ORDER_FIXED_AMOUNT_PROMOTION.compareTo(promotionType)==0)
		{
			return new OrderFixedAmountPromotion(promotionDiscount,productListOrMinThresholdAmount);
			
		}
		else 
		{
			return new OrderFixedPercentPromotion(promotionDiscount,productListOrMinThresholdAmount);
		}
	
		
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
				promotionObject[promotionIndex++]=getPromotionObject(splitedPromotionDetails);
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
			System.out.println(AllConstants.INVALID_INPUT);
			return -1;
		}
	}

	/**
	 * Taking user product choices along with validation
	 * */
	public static Order takeUserInputs()
	{
		
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
			System.out.println("Enter no of product items to buy");
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
			System.out.println("Enter product "+i+" id ");
			int productId=getInput();
			if(productId>0)
			{ 
				boolean isProductFound=Product.searchProductById(productId);
				if(isProductFound)
				{	
					System.out.println("Enter product quantity ");
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
		Iterator<String> itr =orderBill.iterator();
		/*
		 * iterating list and printing it to console
		 * */
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	

	public static void main(String...s) throws IOException
	{
		/*
		 * printing all product list after initialization of product objects 
		 * */
		String filePath=AllConstants.PRODUCT_LIST_CSV_FILE_PATH;
		int noOfProducts=FileOperations.countNoOfLinesInFile(filePath);
		Product[] productObject=Product.initializeProductDetails(filePath, noOfProducts);
		printProductDetails(productObject);
		
		/*
		 * printing all promotions on product list after initialization of promotion objects
		 * */
		/*
		 * printing and initialization of product promotions
		 * */
		filePath=AllConstants.PRODUCT_PROMOTION_CSV_FILE_PATH;
		int noOfProductPromotions=FileOperations.countNoOfLinesInFile(filePath);
		Promotion[] productPromotionObject=initializePromotionDetails(filePath, noOfProductPromotions);
		System.out.println("\nAvailable  product promotions ");
		System.out.println("ProductPromotionType \t\t Discount \t\t Product code lists");
		printPromotionDetails(productPromotionObject);
		
		/*
		 * printing and initialization of order promotions
		 * */
		filePath=AllConstants.ORDER_PROMOTION_CSV_FILE_PATH;
		int noOfOrderPromotions=FileOperations.countNoOfLinesInFile(filePath);
		Promotion[] orderPromotionObject=initializePromotionDetails(filePath, noOfOrderPromotions);
		System.out.println("\nAvailable order promotions ");
		System.out.println("OrderPromotionType \t\t Discount \t\t Minimum purchase amount");
		printPromotionDetails(orderPromotionObject);
		
		/*
		 * taking order from user ,using console 
		 * */
		Order orderObject=takeUserInputs();
		
		/*
		 * creating object for promotion result class and calculating applied promotions of all type
		 * */
		PromotionResult promotionResultObject=new PromotionResult();
		promotionResultObject.calculatePromotionDiscounts(orderObject, productPromotionObject, orderPromotionObject);
		
		/*
		 * creating object for Bill generation class and generating bill 
		 * */
		BillGeneration generateBillObject=new BillGeneration();
		generateBillObject.generateBill(promotionResultObject,orderObject, productPromotionObject, orderPromotionObject);
		
		/*
		 * printing bill to console
		 * */
		
		printBill(generateBillObject);
		
		/*
		 * storing bill to a text file 
		 * */
		FileOperations.generateBillFile(generateBillObject.getOrderBill());
		
	}
}
