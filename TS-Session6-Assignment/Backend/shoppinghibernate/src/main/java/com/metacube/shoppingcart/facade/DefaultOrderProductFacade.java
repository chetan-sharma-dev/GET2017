package com.metacube.shoppingcart.facade;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.OrderProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Order_Payement;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.service.OrderProductService;

@Component("orderProductFacade")
public class DefaultOrderProductFacade implements OrderProductFacade {

	
	@Autowired
	OrderProductService orderProductService;
	
	
	
	
	public OrderProductService getOrderProductService() {
		return orderProductService;
	}




	public void setOrderProductService(OrderProductService orderProductService) {
		this.orderProductService = orderProductService;
	}




	@Override
	public Status saveOrderProduct(Order_Payement curorder, ArrayList<Product> cartProducts) {
		
		return orderProductService.saveOrderProduct(curorder, cartProducts);
	}




	@Override
	public OrderProductDto getorderproducts(int orderId) {
		
		return orderProductService.getorderproducts(orderId);
	}

}
