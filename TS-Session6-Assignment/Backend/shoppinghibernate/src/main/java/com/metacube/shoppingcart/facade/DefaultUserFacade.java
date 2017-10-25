package com.metacube.shoppingcart.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.shoppingcart.dto.UserDto;
import com.metacube.shoppingcart.service.UserService;

@Component("userFacade")
public class DefaultUserFacade implements UserFacade {
	
	@Autowired
	UserService userService;
	
	

	public UserService getUserService() {
		return userService;
	}



	public void setUserService(UserService userService) {
		this.userService = userService;
	}



	@Override
	public UserDto getUserBymail(String email) {
		
		return userService.getUserBymail(email);
	}





}
