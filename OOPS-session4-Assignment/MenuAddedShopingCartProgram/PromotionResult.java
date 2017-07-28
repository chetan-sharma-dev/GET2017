package oopssession4;

import java.util.HashMap;

public class PromotionResult extends Order  {
	/*
	 * HashMap storing product id along with related applied promotion objects
	 * */
	public HashMap<Integer,Promotion> appliedProductPromotion=new HashMap<Integer, Promotion>();
	/*
	 * HashMap storing product id along with related calculated applied discount amount
	 * */
    public HashMap<Integer,Double> appliedDiscount=new HashMap<Integer, Double>();
	
    /*
     * storing reference for applied Order Promotion
     * */
	Promotion appliedOrderPromotion;
	
	/**
	 * method for calculating product level promotion discounts 
	 * by applying checks 
	 * */
	public void calculateProductPromotionToApply(Order orderObject,Promotion[] productPromotionObject)
	{
		/*
		 * all product list is splitted 
		 * */
		String keySetString=orderObject.getOrderedProductList().keySet().toString();
		keySetString=keySetString.replace("[", "");
		keySetString=keySetString.replace("]", "");
		String[] splitedKeyString=keySetString.split("\\, ");
		/*
		 * setting subtotals according to product id sets 
		 * */
		orderObject.setSubTotal(splitedKeyString);
		
		double totalProductLevelDiscount=0;
		double maximumProductDiscount=0;
		int appliedPromotionObjectIndex=0;
		/*
		 * checking all ordered products in product promotions
		 * */
		/*
		 * loop for each ordered products
		 * */
		for(int i=0;i<splitedKeyString.length;i++)
		{	maximumProductDiscount=0;
			int productId=Integer.parseInt(splitedKeyString[i]);
			/*
			 * loop for checking against each product promotion applicability
			 * */
			for(int promotionIndex=0;promotionIndex<productPromotionObject.length;promotionIndex++)
			{
				if(productPromotionObject[promotionIndex].isApplicable(productId))
				{
					/*
					 * if promotion applicable , calculating product discount ,
					 * and checking whether it is maximum or not
					 * */
					double calculatedProductDiscount=productPromotionObject[promotionIndex].getDiscount(productId);
					if(maximumProductDiscount<calculatedProductDiscount)
					{
						maximumProductDiscount=calculatedProductDiscount;
						appliedPromotionObjectIndex=promotionIndex;
					}

				}
			}
			/*
			 * if promotion applied ,do entry in applied product promotion HashMap of promotion object 
			 * and product id as well
			 * */
			if(maximumProductDiscount>0.0)
				appliedProductPromotion.put(productId,productPromotionObject[appliedPromotionObjectIndex]);
			int quantity=orderObject.getOrderedProductList().get(productId);
			/*
			 * do entry in appliedDiscount  HashMap of calculated discount along with product id 
			 * */
			appliedDiscount.put(productId, maximumProductDiscount);
			totalProductLevelDiscount+=maximumProductDiscount*quantity;
			
		}
		orderObject.setProductLevelDiscount(totalProductLevelDiscount);
	
	}
	
	/**
	 * method for calculating order level promotion discounts 
	 * by applying checks 
	 * */
	public void calculateOrderPromotionToApply(Order orderObject,Promotion[] orderPromotionObject)
	{
		double maximumProductDiscount=0;
		int appliedPromotionObjectIndex=-1;
		double amountAfterProductlevelDiscount=orderObject.getSubTotal()-orderObject.getProductLevelDiscount();
		/*
		 * checking for all available discounts for all promotions and extracting maximum product discount values
		 * */
		for(int promotionIndex=0;promotionIndex<orderPromotionObject.length;promotionIndex++)
		{
			
				if(orderPromotionObject[promotionIndex].isApplicable((int)amountAfterProductlevelDiscount))
				{
					double calculatedOrderDiscount=orderPromotionObject[promotionIndex].getDiscount((int)amountAfterProductlevelDiscount);
					if(maximumProductDiscount<calculatedOrderDiscount)
					{
						maximumProductDiscount=calculatedOrderDiscount;
						appliedPromotionObjectIndex=promotionIndex;
					}

				}
		}
		/*
		 * storing reference of applied Order Promotion
		 * */
		if(appliedPromotionObjectIndex>=0)
				appliedOrderPromotion=orderPromotionObject[appliedPromotionObjectIndex];
		/*
		 * after calculation of discount setting all other dependent paramaters
		 * */
		orderObject.setOrderLevelDiscount(maximumProductDiscount);	
		orderObject.setTotalDiscount();
		orderObject.setTotal();
	}
	

	public void calculatePromotionDiscounts(Order orderObject,Promotion[] productPromotionObject,Promotion[] orderPromotionObject)
	{
	
		this.calculateProductPromotionToApply(orderObject, productPromotionObject);
		this.calculateOrderPromotionToApply(orderObject,orderPromotionObject);
	}
}
