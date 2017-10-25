package com.metacube.shoppingcart.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metacube.shoppingcart.dao.cart.CartDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.Product;

@Service("cartService")
@Transactional
public class DefaultCartService implements CartService{
	
	@Resource(name="hibernateCartDao")
	CartDao cartDao;
	
	public DefaultCartService() {
	}

	public CartDao getCartDao() {
		return cartDao;
	}

	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	
	@Override
	public Status addtoCart(Cart cart) {
		return cartDao.addToCart(cart);
	}

	@Override
	public Iterable<Product> getCartProducts(int userId) {
		
		return cartDao.getCartProducts(userId);
	}

	@Override
	public Status deleteProductFromCart(Cart cart) {
		
		return cartDao.deleteProductFromCart(cart);
	}
	
	
}