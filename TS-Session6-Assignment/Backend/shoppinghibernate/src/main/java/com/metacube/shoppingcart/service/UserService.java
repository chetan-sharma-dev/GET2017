package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.dto.UserDto;

public interface UserService {
	
	UserDto getUserBymail(String email);

	
}
