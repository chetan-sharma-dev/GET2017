package oops_session3;

import java.util.HashMap;

public class Order {

	private double subTotal;
	/*
	 * storing product list and quantity 
	 * */
	private HashMap<Integer, Integer> orderedProductList=new HashMap<Integer, Integer>();
	private double productLevelDiscount; 
	private double orderLevelDiscount;
	private double totalDiscount;
	private double total;
	
	public double getSubTotal() {
		return subTotal;
	}
	/*
	 * calculating sub total for ordered products without applying promotions
	 * */
	public void setSubTotal(String[] productIds) {
		double subTotal=0;
		for(int i=0;i<productIds.length;i++)
		{  
			int productId=Integer.parseInt(productIds[i]);
			double eachProductCost=Product.getProductReference(productId).getProductCost();
			int productQuantity=orderedProductList.get(productId);
			/*
			 * calculating sum of all ordered items costs 
			 * */
			subTotal+=eachProductCost*productQuantity;
		}
		
		this.subTotal = subTotal;
	}
	public HashMap<Integer, Integer> getOrderedProductList() {
		return orderedProductList;
	}
	public void setOrderedProductList(int productId,int productQunantity) {
		this.orderedProductList.put(productId, productQunantity);
	}
	public double getProductLevelDiscount() {
		return productLevelDiscount;
	}
	public void setProductLevelDiscount(double productLevelDiscount) {
		this.productLevelDiscount = productLevelDiscount;
	}
	public double getOrderLevelDiscount() {
		return orderLevelDiscount;
	}
	public void setOrderLevelDiscount(double orderLevelDiscount) {
		this.orderLevelDiscount = orderLevelDiscount;
	}
	public double getTotalDiscount() {
		return totalDiscount;
	}
	public void setTotalDiscount() {
		this.totalDiscount = this.orderLevelDiscount+this.productLevelDiscount;
	}
	public double getTotal() {
		return total;
	}
	
	public void setTotal() {
		if(subTotal-totalDiscount>0)
			this.total = subTotal-totalDiscount;
		else
			this.total=0.0;
	}
	
	
	
}
