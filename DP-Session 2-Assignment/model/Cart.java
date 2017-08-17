package model;

import java.util.HashMap;
import java.util.HashSet;
/**
 * @class
 * class for cart of user
 * */
public class Cart extends BaseEntity{
	/*
	 * HashMap Storing product id and all Ordered Item Values in different dedicated class object
	 * */
	private HashMap<String, OrderedItem> orderedItems;
	
	/**
	 * @constructor 
	 *	initializing HashMap 
	 * */
	public Cart()
	{
		orderedItems=new HashMap<String, OrderedItem>();
	}
	/*
	 * getter and setter methods
	 * */
	public HashMap<String, OrderedItem> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(HashMap<String, OrderedItem> orderedItems) {
		this.orderedItems = orderedItems;
	}

	/**
	 * @method addItemInCart()
	 * add New Item in Cart 
	 * */
	public void addItemInCart(Product productObject,int productQuantity){
		/*
		 * getting OrderedItem class and adding it along with product code in orderedItems HashMap
		 * */
		OrderedItem orderedItemObject=new OrderedItem(productObject,productQuantity,productQuantity*productObject.getProductCost());
		orderedItems.put(productObject.getProductCode(),orderedItemObject);
	}
	/**
	 * @method updateQuantityOfAlreadyAddedProduct()
	 * updating quantity information of already exist product 
	 * */
	public void updateQuantityOfAlreadyAddedProduct(Product productObject,int productQuantity)
	{
		OrderedItem orderedItemObject=orderedItems.get(productObject.getProductCode());
		int updatedQuantity=orderedItemObject.getQuantity()+productQuantity;
		orderedItemObject.setQuantity(updatedQuantity);
		orderedItemObject.setTotalPrice(updatedQuantity*productObject.getProductCost());
		orderedItems.replace(productObject.getProductCode(),orderedItemObject);
		
	}
	/**
	 * @method deleteItemFromCart()
	 * delete entry of Item from cart HashMap
	 * */
	public void deleteItemFromCart(String productCode){
			orderedItems.remove(productCode);
	}
	/**
	 * @method updateItemInCart
	 * Updating cart data
	 * */
	public void updateItemInCart(Product productObject,int productQuantity){
		OrderedItem orderedItemObject=orderedItems.get(productObject.getProductCode());
		orderedItemObject.setQuantity(productQuantity);
		orderedItemObject.setTotalPrice(productQuantity*productObject.getProductCost());
		orderedItems.replace(productObject.getProductCode(),orderedItemObject);
		
	}
	
}
