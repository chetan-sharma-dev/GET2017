package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.modal.Order_Payement;

public interface OrderFacade {

	int placeOrder(Order_Payement curorder);

	Iterable<Order_Payement> getMyorders(int userId);

}
