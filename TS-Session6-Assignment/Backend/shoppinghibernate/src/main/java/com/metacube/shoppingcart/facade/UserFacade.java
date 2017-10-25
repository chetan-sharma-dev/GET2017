package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.dto.UserDto;

public interface UserFacade {
		
	UserDto getUserBymail(String email);

	 
}
