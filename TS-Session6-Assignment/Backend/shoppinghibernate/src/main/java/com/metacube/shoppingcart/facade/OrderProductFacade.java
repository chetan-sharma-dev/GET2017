package com.metacube.shoppingcart.facade;

import java.util.ArrayList;

import com.metacube.shoppingcart.dto.OrderProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Order_Payement;
import com.metacube.shoppingcart.modal.Product;

public interface OrderProductFacade {

	Status saveOrderProduct(Order_Payement curorder, ArrayList<Product> cartProducts);

	OrderProductDto getorderproducts(int orderId);

}
