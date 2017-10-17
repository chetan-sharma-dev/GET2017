package com.metacube.shoppingcart.dao.user;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.GenericHibernateDao;
import com.metacube.shoppingcart.modal.User;


@Repository("hibernateUserDao")
public class HibernateUserDao extends GenericHibernateDao<User, Integer> implements UserDao{
	
	public HibernateUserDao() {
		super(User.class);
	}
}
