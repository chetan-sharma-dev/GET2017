package controller;


import facade.CartFacade;
import view.Display;
import view.TakeUserInput;

/**
 * Main Controller Singleton class 
 * Using this class input taken from view and validation done
 * 
 * */
public class MainController {
	/*
	 * all required variables taken and instantiated once
	 * */
	private static MainController mainControllerObject;
	private static ProductController productControllerObject;
	private static CartFacade cartFacadeObject;
	private MainController() {
		productControllerObject=ProductController.getInstance();
		cartFacadeObject=CartFacade.getInstance();
	}
	
	/**
	 * @method MainController getInstance()
	 * method for getting object of mainController
	 * @return mainControllerObject
	 * */
	public static MainController getInstance()
	{
		/*
		 * checking for instance using double checking mechanism of singleton class
		 * */
		if(mainControllerObject==null)
		{
			synchronized (MainController.class) {
				if(mainControllerObject==null)
				{
					mainControllerObject=new MainController();
				}
				
			}
		}
		return mainControllerObject;
	}
	
	/**
	 * @method getResponce(String choice)
	 * using this method View is getting response from MainController for user given choice input
	 * */
	public void getResponse(String choice){
		/*
		 * According to User choice method called 
		 * */
		switch(choice)
		{
			case "1":
				Display.displayproductList(productControllerObject.getAllProductslist());
				break;
			case "2":
				Display.displayCartItemList(cartFacadeObject.getAllCartItems());
				break;
			case "3":
				addToCart();
				break;
			case "4":
				editProductQuantity();
				break;
			case "5":
				deleteItemFromCart();
				break;
			case "6":
				Display.printMessageOnDisplay(cartFacadeObject.deleteAllItemsFromCart());
				break;
			case "7":
				Display.printMessageOnDisplay("---------------Thank You----------------");
				System.exit(0);
				break;
			default:
				Display.printMessageOnDisplay("invalid input");
				
		}
		/*
		 * showing menu to user
		 * */
		Display.displayMenu();
	}

	/**
	 * @method addToCart()
	 * method for adding items in cart ,
	 * On user input, checking for valid input , calling cartFacade method for adding items in cart
	 * and showing appropriate message on screen
	 * */
	public void addToCart(){
		boolean status=false;
		int choice=1;
		String productCode="";
		String productQuantity="";
		while(!status)
		{
			switch(choice)
			{
				case 1:
					/*
					 * Taking product code from user and validating it
					 * if valid product code entered , take product quantity as input
					 * */
						Display.printMessageOnDisplay("Enter product Code");
						productCode=TakeUserInput.takeUserInput();
						if(validateProductId(productCode))
						{
							choice=2;
						}
						else
						{
							Display.printMessageOnDisplay("Invalid Product Id Entered");
						}
						break;
				case 2:
					/*
					 * taking product quantity as input and validating it
					 * */
					Display.printMessageOnDisplay("Enter Quantity");
					productQuantity=TakeUserInput.takeUserInput();
					if(validateProductQuantity(productQuantity))
					{
						Display.printMessageOnDisplay(cartFacadeObject.addItem(productCode,Integer.parseInt(productQuantity)));
						status=true;
					}
					else
					{
						Display.printMessageOnDisplay("Invalid Quantity Entered");
					}
					break;
					
			
			}
		}
	
	}
	
	/**
	 * @method removeItemFromCart()
	 * method for removing items from cart ,
	 * On user input, checking for valid input , calling cartFacade method for removing item in cart
	 * and showing appropriate message on screen
	 *  */
	public void deleteItemFromCart(){
		boolean status=false;
		String productCode="";
		/*
		 * checking whether cart is having items or not,
		 * if not , showing Empty Cart Message
		 * */
		if(cartFacadeObject.getAllCartItems().size()==0)
		{
			Display.printMessageOnDisplay("---------Your Cart is Empty-------------");
			return;
		}
		
		/*
		 * taking product code of item which is to be deleted
		 * and calling Facade method for deleting items from cart
		 * */
		while(!status)
		{
						Display.printMessageOnDisplay("Enter product Code");
						productCode=TakeUserInput.takeUserInput();
						if(validateProductId(productCode))
						{	
							
								Display.printMessageOnDisplay(cartFacadeObject.deleteItem(productCode));
								status=true;
						}
						else
						{
							Display.printMessageOnDisplay("Invalid Product Id Entered");
						}
		}
		
	}
	/**
	 * @method editProductQuantity() 
	 * method for editing productQuantity in cart
	 * */
	public void editProductQuantity(){
		boolean status=false;
		int choice=1;
		String productCode="";
		String productQuantity="";
		/*
		 * checking whether cart empty or not ,
		 * if cart is empty, then showing empty cart message and returning to Menu
		 * */
		if(cartFacadeObject.getAllCartItems().size()==0)
		{
			Display.printMessageOnDisplay("---------Your Cart is Empty-------------");
			return;
		}
		/*
		 * taking user input and after all input validation checked , cartFacade method called for updating cart
		 * */
		while(!status)
		{
			switch(choice)
			{
				case 1:
						Display.printMessageOnDisplay("Enter product Code");
						productCode=TakeUserInput.takeUserInput();
						if(validateProductId(productCode))
						{
							if(cartFacadeObject.getAllProductCodesInCart().contains(productCode))
								{
									choice=2;
									break;
								}
						}
						
							Display.printMessageOnDisplay("-------Enterd Product doesn't exist in Cart------");
						
						break;
				case 2:
					Display.printMessageOnDisplay("Enter Qunantity");
					productQuantity=TakeUserInput.takeUserInput();
					if(validateProductQuantity(productQuantity))
					{
						Display.printMessageOnDisplay(cartFacadeObject.updateCartItem(productCode,Integer.parseInt(productQuantity)));
						status=true;
					}
					else
					{
						Display.printMessageOnDisplay("Invalid Quantity Entered");
					}
					break;
					
			
			}
		}
	
	}
	
	/**
	 * @method validateProductId(String productId)
	 * method for validating product id 
	 * @return boolean: true if available else false
	 * */
	
	public  boolean validateProductId(String productId)
	{
		return productControllerObject.getAllProductsCodeslist().contains(productId);
	}
	
	/**
	 * @method validateProductQuantity(String productQuantity)
	 * method for validating product Quantity
	 * @return boolean: true if valid Quantity entered else false
	 * */
	
	public  boolean validateProductQuantity(String productQuantity)
	{
		try{
			
			if(Integer.parseInt(productQuantity)>0)
				return true;
			else
				throw new NumberFormatException();
		}
		catch(NumberFormatException e){
			return false;
		}
		
	}
}
