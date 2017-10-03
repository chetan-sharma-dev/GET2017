package com.metacube.get.layarch.facade;

import java.util.ArrayList;
import java.util.List;

import com.metacube.get.layarch.dto.ProductDto;
import com.metacube.get.layarch.model.Product;
import com.metacube.get.layarch.service.ProductService;

public class DefaultProductFacade implements ProductFacade
{
	ProductService productService;

	public DefaultProductFacade(ProductService productService) {
		this.productService = productService;
	}


	@Override public Iterable<ProductDto> getAllProducts()
	{
		List<ProductDto> productDtoList = new ArrayList<>();

		for (Product product : productService.getAllProducts()) {
			productDtoList.add(modelToDto(product));
		}

		return productDtoList;
	}

	@Override public ProductDto getProductById(final int id)
	{
		return modelToDto(productService.getProductById(id));
	}

	protected Product dtoToModel(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setPrice(product.getPrice());
		return product;
	}

	protected ProductDto modelToDto(Product product) {
		if (product == null) {
			return null;
		}
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setPrice(product.getPrice());
		
		return productDto;
	}
}
