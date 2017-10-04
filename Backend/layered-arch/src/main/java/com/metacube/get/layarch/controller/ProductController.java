package com.metacube.get.layarch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metacube.get.layarch.dao.product.JdbcProductDao;
import com.metacube.get.layarch.facade.DefaultProductFacade;
import com.metacube.get.layarch.facade.ProductFacade;
import com.metacube.get.layarch.model.Product;
import com.metacube.get.layarch.service.DefaultProductService;
import com.metacube.get.layarch.spring.Factory;

/**
 * @class 
 * controller class for project
 * */

@Path("/product")
public class ProductController
{
	
	/**
	 * creating productFacade Object using Beans in Application Context 
	 * */
	ProductFacade productFacade;

	public ProductController() {
		productFacade = Factory.getApplicationContext().getBean("productFacade", ProductFacade.class);
	}

	/**
	 * @method getProducts()
	 * method for getting product list form facade object and returnig responce through rest service
	 * */
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProducts() {

		return Response.status(Response.Status.OK).entity(productFacade.getAllProducts()).build();

	}
	
	/**
	 * @method getProduct()
	 * method for getting product details using it's id
	 * 
	 * */
	@GET
	@Path("/list/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProduct(@PathParam("productId") int productId) {

		return Response.status(Response.Status.OK).entity(productFacade.getProductById(productId)).build();

	}

	
		
}
