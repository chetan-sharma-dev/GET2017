package com.metacube.shoppingcart.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_payement")
public class Order_Payement {
	
	@Id
	@Column(name = "orderId")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int orderId;
	
	@Column(name="userId")
	private int userId;
	
	@Column(name="total")
	private double total;
	
	@Column(name="date")
	private String date;
	
	@Column(name="cardNumber")
	private String cardNumber;
	
	@Column(name="expMonth")
	private int expMonth;
	
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}

	public int getExpYear() {
		return expYear;
	}

	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}

	public int getCvCode() {
		return cvCode;
	}

	public void setCvCode(int cvCode) {
		this.cvCode = cvCode;
	}

	@Column(name="expYear")
	private int expYear;
	
	@Column(name="cvCode")
	private int cvCode;
	
	
	
	
	
}
