package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;

public interface ProductService {
	Iterable<Product> getAllProducts();
	Product getProductById(int id);
	Status addProduct(Product entity);
	Status deleteProduct(int id);
	Status editProduct(Product entity, int id);
}
