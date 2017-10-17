package com.metacube.shoppingcart.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.shoppingcart.dto.OrderProductDto;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.facade.UserFacade;
import com.metacube.shoppingcart.facade.CartFacade;
import com.metacube.shoppingcart.facade.OrderFacade;
import com.metacube.shoppingcart.facade.OrderProductFacade;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.Order_Payement;
import com.metacube.shoppingcart.modal.Product;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserFacade userFacade;

	@Autowired
	CartFacade cartFacade;

	@Autowired
	OrderFacade orderFacade;

	@Autowired
	OrderProductFacade orderProductFacade;

	@RequestMapping(value = "/get/{email}", produces = "application/json")
	public @ResponseBody UserDto getUserById(@PathVariable("email") String email) {
		return userFacade.getUserBymail(email);
	}

	@RequestMapping(value = "/add")
	public @ResponseBody Status addToCart(@RequestBody Cart cart) {
		return cartFacade.addToCart(cart);
	}

	@RequestMapping(value = "/getcart/{userId}", produces = "application/json")
	public @ResponseBody Iterable<Product> getProducts(@PathVariable("userId") int userId) {

		return cartFacade.getAllProducts(userId);

	}

	@RequestMapping(value = "/delete")
	public @ResponseBody Status deleteProductFromCart(@RequestBody Cart cart) {
		// System.out.println(cart.getProductId() + cart.getUserId());
		return cartFacade.deleteProductFromCart(cart);

	}

	@RequestMapping(value = "/placeorder")
	public @ResponseBody Status placeOrder(@RequestBody Order_Payement curorder) {

		orderFacade.placeOrder(curorder);
		ArrayList<Product> cartProducts = (ArrayList<Product>) cartFacade.getAllProducts(curorder.getUserId());

		return orderProductFacade.saveOrderProduct(curorder, cartProducts);

	}

	@RequestMapping(value = "/getorders/{userId}", produces = "application/json")
	public @ResponseBody Iterable<Order_Payement> getorders(@PathVariable("userId") int userId) {

		return orderFacade.getMyorders(userId);

	}

	@RequestMapping(value = "/getorderproducts/{orderId}", produces = "application/json")
	public @ResponseBody OrderProductDto getorderProducts(@PathVariable("orderId") int orderId) {

		return orderProductFacade.getorderproducts(orderId);

	}

}
