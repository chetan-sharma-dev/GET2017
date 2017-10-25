package com.metacube.shoppingcart.dto;

import com.metacube.shoppingcart.modal.User;

public class UserDto {
	
	private User user;
	private int totalNoproduct;
	private double totalCost;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getTotalNoproduct() {
		return totalNoproduct;
	}
	public void setTotalNoproduct(int totalNoproduct) {
		this.totalNoproduct = totalNoproduct;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
}
