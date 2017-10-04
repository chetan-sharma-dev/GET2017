package com.metacube.get.layarch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.metacube.get.layarch.dto.ProductDto;
import com.metacube.get.layarch.facade.ProductFacade;


/**
 * @class 
 * controller class for project
 * */


@CrossOrigin
@Controller
@RequestMapping("/product")
public class ProductController
{

	@Autowired
	ProductFacade productFacade;
	
	
	
	@RequestMapping(value ="/list",method = RequestMethod.GET )
	public @ResponseBody Iterable<ProductDto> getProducts() {

		return  productFacade.getAllProducts();

	}
	
	@RequestMapping(value ="/list/{productId}",method = RequestMethod.GET )
	
	public @ResponseBody ProductDto getProduct(@PathVariable int productId) {
		return productFacade.getProductById(productId);
	}

	
		
}
