package com.metacube.shoppingcart.service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.metacube.shoppingcart.dao.user.UserDao;
import com.metacube.shoppingcart.dto.UserDto;

@Service("userService")
@Transactional
public class DefaultUserService implements UserService {
	
	@Resource(name="hibernateUserDao")
	UserDao userDao;
	
	public DefaultUserService() {
		
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserDto getUserBymail(String email) {
		
		return userDao.findOne(email);
	}

	

	
}
