package oops_session3;

import java.util.ArrayList;



public class ProductFixedAmountPromotion extends Promotion {
	
	public ProductFixedAmountPromotion() {
		this.discount=0;
		this.discountedProductList=new ArrayList<Integer>();
	}

	public ProductFixedAmountPromotion(String discount,String productCodeList) {
		this.discountedProductList=new ArrayList<Integer>();
		this.discount=Double.parseDouble(discount);
		String[] splitedProductCodeList=productCodeList.split("\\;");
		for(int i=0;i<splitedProductCodeList.length;i++)
		{
			
			this.discountedProductList.add(Integer.parseInt(splitedProductCodeList[i]));
		}
	}
/*
 * checking for discount applicability for given productId
 * */
	@Override
	public boolean isApplicable(int productId) {
		return this.discountedProductList.contains(productId);
	}
	/*
	 * returning discount amount
	 * */
	@Override
	public double getDiscount(int productId) {
		return discount;
	} 
	
}
