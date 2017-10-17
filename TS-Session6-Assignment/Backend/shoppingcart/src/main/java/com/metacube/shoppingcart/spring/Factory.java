package com.metacube.shoppingcart.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Factory {
	
	static ApplicationContext applicationContext;

	static {
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	
	}

	static public ApplicationContext getApplicationContext()
	{
		return applicationContext;
	
	}
}
