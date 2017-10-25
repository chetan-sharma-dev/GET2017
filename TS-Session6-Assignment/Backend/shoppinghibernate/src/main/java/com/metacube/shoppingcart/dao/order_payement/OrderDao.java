package com.metacube.shoppingcart.dao.order_payement;

import com.metacube.shoppingcart.dao.AbstractDao;
import com.metacube.shoppingcart.modal.Order_Payement;

public interface OrderDao extends AbstractDao<Order_Payement, Integer> {

	int placeOrder(Order_Payement curorder);

	Iterable<Order_Payement> getMyOrders(int userId);

}
