package oops_session3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Chetan Sharma
 * NAME BillGeneration
 * class is generating bill for ordered list of products 
 */
public class BillGeneration {
	
	/**
	 * list containing bill entries for ordered products  
	 */
	private static List<String> orderBill=new ArrayList<String>();
	
	/**
	 * method is returning order bill as a list 
	 * @return
	 */
	public List<String> getOrderBill() {
		return orderBill;
	}

	/**
	 * @param promotionResultObject : this is giving information about applied promotions
	 * @param orderObject : giving all information related to user order  
	 * @param productPromotionObject : giving information about all available product promotions
	 * @param orderPromotionObject : giving information about all available order promotions
	 */
	public void generateBill(PromotionResult promotionResultObject,Order orderObject,Promotion[] productPromotionObject,Promotion[] orderPromotionObject)
	{
		orderBill.add("########################################################");
		orderBill.add("YOUR ORDER :");
		orderBill.add("########################################################");
		orderBill.add("PURCHASED PRODUCTS :");
		/*
		 * extracting order list from given order
		 * */
		HashMap<Integer, Integer> productList=orderObject.getOrderedProductList();
		/*
		 * Getting List of all Ordered product items
		 * */
		String keySetOfOrderedProducts=productList.keySet().toString().toString();
		keySetOfOrderedProducts=keySetOfOrderedProducts.replace("[", "");
		keySetOfOrderedProducts=keySetOfOrderedProducts.replace("]", "");
		String[] allOrderedProducts=keySetOfOrderedProducts.split("\\, ");
		/*
		 * product list with quantity stored in orderBill list
		 * */
		int noOfItems=allOrderedProducts.length;
		for(int i=0;i<noOfItems;i++)
		{
			/*
			 * extracting productId from ordered product list 
			 * using productId to extract productName,ProductCost and ordered product quantity relatively
			 * */
			int productId=Integer.parseInt(allOrderedProducts[i]);
			String productName=Product.getProductReference(productId).getProductName();
			double productCost=Product.getProductReference(productId).getProductCost();
			int productQuantity=productList.get(productId);
			/*
			 * adding product and cost lines in orderBill list for product individual 
			 * */
			orderBill.add("Product : "+productId+" "+productName);
			orderBill.add("Cost : $"+ (productCost*productQuantity)+"("+productQuantity+" x "+productCost+")\n");
			
		}
		/*
		 * doing Applied discount entry in orderBill list 
		 * */
		orderBill.add("Applied Promotions/Discounts :");
		
/*
 * all product discounts applied
 * */		
		/*
		 * extracting Hashmap from promotion result class ,
		 * which is giving informations of applied product promotions objects 
		 * */
		HashMap<Integer, Promotion> appliedPromotions=promotionResultObject.appliedProductPromotion;
		/*
		 * extracting Hashmap from promotion result class ,
		 * which is giving applied maximum discount informations on ordered products relatively
		 * */
		HashMap<Integer,Double> appliedDiscount=promotionResultObject.appliedDiscount;
		/*
		 * for each product getting all product promotions details along with applied maximum discounts 
		 * */
		for(int i=0;i<noOfItems;i++)
		{
			int productId=Integer.parseInt(allOrderedProducts[i]);
			String productName=Product.getProductReference(productId).getProductName();
			double discountOnOneProduct=0;
			int productQuantity=productList.get(productId);
			/*
			 * when there is no discount on product print default string else update string
			 * */
			String promotionPrintingString="Promotion : no promotion on "+productName+" [code:"+productId+"]";
			if(appliedPromotions.size()>0&&appliedPromotions.containsKey(productId))
			{
				/*
				 * giving information about given discount in product promotion 
				 * either in percent or value
				 * */
				discountOnOneProduct=appliedPromotions.get(productId).discount;
				/*
				 * checking percentage type
				 * */
				if(appliedPromotions.get(productId).isPercentage)
					promotionPrintingString="Promotion : "+(int)discountOnOneProduct+" % off on "+productName+" [code:"+productId+"]";
				else
					promotionPrintingString="Promotion : $"+discountOnOneProduct+" off on "+productName+" [code:"+productId+"]";
			}
			
			orderBill.add(promotionPrintingString);
			/*
			 * calculating discounted value after applying promotion on one product 
			 * */
			double discountedValueOnOneProduct=appliedDiscount.get(productId);
			/*
			 * calculating total discount value on one type item
			 * */
			double discountOnItem=productQuantity*discountedValueOnOneProduct;
			/*
			 * adding total discount in orderBill list
			 * */
			orderBill.add("Discount : $"+discountOnItem+"\n");
		}
		
		
		/*
		 * order discounts calculation
		 * */
		if(promotionResultObject.appliedOrderPromotion!=null)
		{	
		double orderDiscount=promotionResultObject.appliedOrderPromotion.discount;
		double minimumPurchaseAmount= promotionResultObject.appliedOrderPromotion.minimumThresoldAmount;
		/*
		 * checking for percentage type
		 * */
		
			if (promotionResultObject.appliedOrderPromotion.isPercentage)
				orderBill.add("Promotion : " + orderDiscount
						+ " % on orders above " + minimumPurchaseAmount);
			else
				orderBill.add("Promotion : $" + orderDiscount
						+ " on orders above " + minimumPurchaseAmount);
		}
		else {
				orderBill
						.add("Promotion :  no promotion applicable on purchased amount ");
			}
		/*
		 * adding total order level Discount, subtotal , 
		 * total product level discount ,total discount and 
		 * final total amount to be paid in orderBill list 
		 * */
		orderBill.add("Discount : $"+orderObject.getOrderLevelDiscount()+"\n");
		
		orderBill.add("SubTotal :$"+orderObject.getSubTotal());
		orderBill.add("Product Level Discounts :$"+orderObject.getProductLevelDiscount());
		orderBill.add("Order Level Discounts :$"+orderObject.getOrderLevelDiscount());
		orderBill.add("Total Discounts :$"+orderObject.getTotalDiscount());
		orderBill.add("Total :$"+orderObject.getTotal());
		
		
		
		
	}

}
