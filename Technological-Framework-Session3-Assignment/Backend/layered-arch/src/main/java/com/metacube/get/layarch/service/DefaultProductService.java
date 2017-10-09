package com.metacube.get.layarch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.metacube.get.layarch.dao.product.ProductDao;
import com.metacube.get.layarch.model.Product;

@Component("productService")
public class DefaultProductService implements ProductService
{
	@Autowired
	ProductDao productDao;
	/*
	public ProductDao getProductDao() {
		return productDao;
	}
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}
	*/
	@Override public Iterable<Product> getAllProducts()
	{
		return productDao.findAll();
	}

	@Override public Product getProductById(final int id)
	{
		return productDao.findOne(id);
	}
}
