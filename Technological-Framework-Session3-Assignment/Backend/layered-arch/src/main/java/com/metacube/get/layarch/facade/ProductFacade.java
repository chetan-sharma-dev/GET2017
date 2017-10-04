package com.metacube.get.layarch.facade;

import com.metacube.get.layarch.dto.ProductDto;


public interface ProductFacade
{
	Iterable<ProductDto> getAllProducts();
	ProductDto getProductById(int id);
}
