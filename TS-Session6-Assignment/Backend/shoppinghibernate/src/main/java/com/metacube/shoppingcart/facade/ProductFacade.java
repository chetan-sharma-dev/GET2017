package com.metacube.shoppingcart.facade;

import com.metacube.shoppingcart.dto.ProductDto;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;

public interface ProductFacade {
	Iterable<ProductDto> getAllProducts();
	ProductDto getProductById(int id);
	Status addProduct(Product entity);
	Status deleteProduct(int id);
	Status editProduct(Product entity,int id);
}
