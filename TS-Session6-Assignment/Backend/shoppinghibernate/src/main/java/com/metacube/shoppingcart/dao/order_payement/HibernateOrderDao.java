package com.metacube.shoppingcart.dao.order_payement;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.GenericHibernateDao;
import com.metacube.shoppingcart.modal.Order_Payement;

@Repository("hibernateOrderDao")
public class HibernateOrderDao extends GenericHibernateDao<Order_Payement, Integer> implements OrderDao {

	public HibernateOrderDao() {
		super(Order_Payement.class);
	}

}
