package model;
/**
 * @class 
 * class dedicated to individual product added in cart for holding ordered item details
 * */
public class OrderedItem {
	private Product productObject;
	private int quantity;
	private Double totalPrice;
	
	public OrderedItem() {
	
	}
	
	public OrderedItem(Product productObject,int quantity,Double totalPrice) {
		this.productObject=productObject;
		this.quantity=quantity;
		this.totalPrice=totalPrice;
	}
	
	public Product getProductObject() {
		return productObject;
	}
	public void setProductObject(Product productObject) {
		this.productObject = productObject;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
