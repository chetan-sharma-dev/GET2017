package com.metacube.get.layarch.service;

import com.metacube.get.layarch.dao.product.ProductDao;
import com.metacube.get.layarch.model.Product;

public class DefaultProductService implements ProductService
{
	ProductDao productDap;

	public DefaultProductService(ProductDao productDap) {
		this.productDap = productDap;
	}

	@Override public Iterable<Product> getAllProducts()
	{
		return productDap.findAll();
	}

	@Override public Product getProductById(final int id)
	{
		return productDap.findOne(id);
	}
}
