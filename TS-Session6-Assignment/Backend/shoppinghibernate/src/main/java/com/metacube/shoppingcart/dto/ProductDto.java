package com.metacube.shoppingcart.dto;

public class ProductDto {
	private int id;
	private String name;
	private double price;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(final int id) {
		this.id = id;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(final double price) {
		this.price = price;
	}
	
}
