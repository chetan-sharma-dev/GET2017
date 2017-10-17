package com.metacube.shoppingcart.service;

import java.util.ArrayList;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metacube.shoppingcart.dao.orderproduct.OrderProductDao;
import com.metacube.shoppingcart.dto.OrderProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Order_Payement;
import com.metacube.shoppingcart.modal.Product;

@Service("orderProductService")
@Transactional
public class DefaultOrderProductService implements OrderProductService {

	@Resource(name = "hibernateOrderProductDao")
	OrderProductDao orderProductDao;

	public DefaultOrderProductService() {

	}

	public OrderProductDao getOrderProductDao() {
		return orderProductDao;
	}

	public void setOrderProductDao(OrderProductDao orderProductDao) {
		this.orderProductDao = orderProductDao;
	}

	@Override
	public Status saveOrderProduct(Order_Payement curorder, ArrayList<Product> cartProducts) {

		return orderProductDao.saveOrderProduct(curorder, cartProducts);
	}

	@Override
	public OrderProductDto getorderproducts(int orderId) {

		return orderProductDao.getorderproducts(orderId);
	}

}
