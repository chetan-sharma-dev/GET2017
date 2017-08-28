package com.metacube.assignment2;
/**
 * @class Address
 * class for holding user address
 * */
public class Address {
	private String placeName;

	/*
	 * getter and setter method
	 * */
	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	/*
	 * overridden toString method to stringify user address 
	 * */
	public String toString(){
		return placeName;
	}
}
