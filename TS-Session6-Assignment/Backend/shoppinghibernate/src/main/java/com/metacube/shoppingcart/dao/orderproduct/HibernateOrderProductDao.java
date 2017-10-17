package com.metacube.shoppingcart.dao.orderproduct;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.GenericHibernateDao;
import com.metacube.shoppingcart.modal.OrderProduct;

@Repository("hibernateOrderProductDao")
public class HibernateOrderProductDao extends GenericHibernateDao<OrderProduct, Integer> implements OrderProductDao{

	public HibernateOrderProductDao() {
		super(OrderProduct.class);
	}

	

	
	
}
