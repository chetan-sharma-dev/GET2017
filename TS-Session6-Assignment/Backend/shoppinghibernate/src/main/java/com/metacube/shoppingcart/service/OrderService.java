package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.modal.Order_Payement;

public interface OrderService {

	int placeOrder(Order_Payement curorder);

	Iterable<Order_Payement> getMyorders(int userId);

}
