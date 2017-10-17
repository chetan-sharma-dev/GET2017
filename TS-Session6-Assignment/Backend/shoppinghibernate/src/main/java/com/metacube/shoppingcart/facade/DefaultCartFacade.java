package com.metacube.shoppingcart.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.service.CartService;

@Component("cartFacade")
public class DefaultCartFacade implements CartFacade {
	
	@Autowired
	CartService cartService;

	public CartService getCartService() {
		return cartService;
	}

	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	
	@Override
	public Status addToCart(Cart cart) {
		
		return cartService.addtoCart(cart);
	}

	@Override
	public Iterable<Product> getAllProducts(int userId) {
		
		return cartService.getCartProducts(userId);
	}

	@Override
	public Status deleteProductFromCart(Cart cart) {
		
		return cartService.deleteProductFromCart(cart);
	}

	
	
	
}
