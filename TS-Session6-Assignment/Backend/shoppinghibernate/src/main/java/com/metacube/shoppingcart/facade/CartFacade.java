package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.Product;

public interface CartFacade {
	
	Status addToCart(Cart cart);

	Iterable<Product> getAllProducts(int userId);

	Status deleteProductFromCart(Cart cart);
}
