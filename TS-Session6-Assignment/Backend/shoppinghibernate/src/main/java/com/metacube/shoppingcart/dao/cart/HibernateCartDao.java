package com.metacube.shoppingcart.dao.cart;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.GenericHibernateDao;
import com.metacube.shoppingcart.modal.Cart;

@Repository("hibernateCartDao")
public class HibernateCartDao extends GenericHibernateDao<Cart, Integer> implements CartDao {

	public HibernateCartDao() {
		super(Cart.class);
	}
}
