package com.metacube.shoppingcart.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metacube.shoppingcart.dao.order_payement.OrderDao;
import com.metacube.shoppingcart.modal.Order_Payement;

@Service("orderService")
@Transactional
public class DefaultOrderService implements OrderService {

	@Resource(name="hibernateOrderDao")
	OrderDao orderDao; 
	
	public DefaultOrderService() {
		
	}
	
	
	
	public OrderDao getOrderDao() {
		return orderDao;
	}



	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}



	@Override
	public int placeOrder(Order_Payement curorder) {
		
		return orderDao.placeOrder(curorder);
	}



	@Override
	public Iterable<Order_Payement> getMyorders(int userId) {
	
		return orderDao.getMyOrders(userId);
	}

}
