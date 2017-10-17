package com.metacube.shoppingcart.service;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
public class ShoppingCartService {
	 @GET
	 @Path("/{name}")
	 @Produces(MediaType.APPLICATION_JSON)	
	    public Response getMsg(@PathParam("name") String name) {
	  
	        String output = "Welcome   : " + name;
	  
	        return Response.status(200).entity(output).build();
	  
	    }
}
