package com.metacube.shoppingcart.dto;

import com.metacube.shoppingcart.modal.Product;

public class OrderProductDto {
	
	private double total;
	Product products[];
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Product[] getProducts() {
		return products;
	}
	public void setProducts(Product[] products) {
		this.products = products;
	}
	
	
		
}
