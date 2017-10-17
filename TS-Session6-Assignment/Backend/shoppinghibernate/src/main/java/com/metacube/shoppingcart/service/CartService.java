package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.Product;

public interface CartService {
	
	Status addtoCart(Cart cart);

	Iterable<Product> getCartProducts(int userId);

	Status deleteProductFromCart(Cart cart);
}
