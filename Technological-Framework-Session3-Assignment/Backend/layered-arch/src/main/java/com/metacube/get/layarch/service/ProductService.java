package com.metacube.get.layarch.service;



import com.metacube.get.layarch.model.Product;

public interface ProductService
{
	Iterable<Product> getAllProducts();
	Product getProductById(int id);
}
