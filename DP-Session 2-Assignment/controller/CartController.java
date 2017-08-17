package controller;

import facade.CartFacade;

public class CartController {
	private static CartController cartControllerObject;
	private static CartFacade cartFacadeObject;
	private CartController()
	{
		cartFacadeObject=CartFacade.getInstance();
	}
	
	public static CartController getInstance()
	{
		if(cartControllerObject==null)
		{
			synchronized (CartController.class) {
				if(cartControllerObject==null)
				{
					
				}
				
			}
		}
		return cartControllerObject;
	}
	
	public boolean isProductAvailbleInCart(String productCode){
		return cartFacadeObject.getAllProductCodesInCart().contains(productCode);
	}
	
	public void addItemInCart(String productCode,int productQunatity)
	{
		cartFacadeObject.addItem(productCode, productQunatity);
	}
}
