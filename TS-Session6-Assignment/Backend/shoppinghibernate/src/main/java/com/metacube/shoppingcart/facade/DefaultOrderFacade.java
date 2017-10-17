package com.metacube.shoppingcart.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.modal.Order_Payement;
import com.metacube.shoppingcart.service.OrderService;

@Component("orderFacade")
public class DefaultOrderFacade implements OrderFacade {
	
	@Autowired
	OrderService orderService;
	
	
	
	public OrderService getOrderService() {
		return orderService;
	}



	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}



	@Override
	public int placeOrder(Order_Payement curorder) {
		
		return orderService.placeOrder(curorder);
	}



	@Override
	public Iterable<Order_Payement> getMyorders(int userId) {
		
		return orderService.getMyorders(userId);
	}
	
}
