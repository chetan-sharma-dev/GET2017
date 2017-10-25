package com.metacube.shoppingcart.dao;

import java.io.Serializable;
import java.util.ArrayList;

import com.metacube.shoppingcart.dto.OrderProductDto;
import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Cart;
import com.metacube.shoppingcart.modal.Order_Payement;
import com.metacube.shoppingcart.modal.Product;


/**
 * The Interface AbstractDao.
 *
 * @param <T> the generic type
 * @param <ID> the generic type
 */
public interface AbstractDao<T, ID extends Serializable> {
	
	/**
	 * Save.
	 *
	 * @param <S> the generic type
	 * @param entity the entity
	 * @return the s
	 */
	<S extends T> Status save(S entity);
	
	/**
	 * Find one.
	 *
	 * @param primaryKey the primary key
	 * @return the t
	 */
	T findOne(ID primaryKey);
	
	UserDto findOne(String email);
	
	Status addToCart(Cart cart);
	
	Status deleteProductFromCart(Cart cart);
	
	Iterable<Product> getCartProducts(int userId);
	/**
	 * Find all.
	 *
	 * @return the iterable
	 */
	Iterable<T> findAll();
	
	
	
	/**
	 * Delete.
	 *
	 * @param primaryKey the primary key
	 * @return the status
	 */
	Status delete(ID primaryKey);
	
	/**
	 * Edits the.entity
	 *
	 * @param primaryKey the primary key
	 * @return the status
	 */
	<S extends T>Status edit(S entity,ID primaryKey);
	/**
	 * Exists.
	 *
	 * @param primaryKey the primary key
	 * @return true, if successful
	 */
	

	int placeOrder(Order_Payement curorder);
	Status saveOrderProduct(Order_Payement curorder, ArrayList<Product> cartProducts);

	Iterable<Order_Payement> getMyOrders(int userId);
	
	OrderProductDto getorderproducts(int orderId);
}
