package oops_session3;

import java.util.ArrayList;





public class ProductFixedPercentPromotion extends Promotion {
	
	public ProductFixedPercentPromotion() {
		this.discount=0;
		this.isPercentage=true;
		this.discountedProductList=new ArrayList<Integer>();
		
	}

	public ProductFixedPercentPromotion(String discount, String productCodeList) {
		this.discountedProductList=new ArrayList<Integer>();
		this.isPercentage=true;
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
	 * returning discount amount after calculating percentage
	 * */
	@Override
	public double getDiscount(int productId) {
		double fetchedProductCost= Product.getProductReference(productId).getProductCost();
		return (fetchedProductCost*discount)/100;
	} 
	
}
