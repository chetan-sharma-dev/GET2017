package view;

import java.util.Iterator;
import java.util.List;

import controller.MainController;
/**
 * @class 
 * class for showing menu to user, taking user input through some console and 
 * showing appropriate message to user
 * */
public class Display {
	/**
	 * all required objects created 
	 * */
	private static Display displayObject; 
	private static MainController mainControllerObject;
	/**
	 * @constructor 
	 * main controller object initialized
	 * */
	private Display(){
		mainControllerObject=MainController.getInstance();
	}
	/**
	 * @method getInstance()
	 * returning instance of single class
	 * */
	public static Display getInstance(){
		if(displayObject==null)
		{
			synchronized (Display.class) {
				if(displayObject==null)
				{
					displayObject=new Display();
				}
			}
		}
		return displayObject;
	}
	
	/**
	 * @method displayMenu()
	 * method for showing displaying menu
	 * */
	public static void displayMenu(){
		
		System.out.println("1. Show all product \n"
				+ "2. DisplayCart \n"
				+ "3. Add product to cart \n"
				+ "4. Edit procuct qunantity \n"
				+ "5. Delete product from \n"
				+ "6. Delete all products \n"
				+ "7. Exit");
		mainControllerObject.getResponse(TakeUserInput.takeUserInput());
		
	}
	
	/**
	 * @method displayproductList()
	 * iterating list of product list and showing it on user view ( console )
	 * */
	public static void displayproductList(List<String> productList){
		Iterator<String> iterateList=productList.iterator();
		printMessageOnDisplay("-----------------PRODUCT LIST-----------------");
		while(iterateList.hasNext())
		{
			printMessageOnDisplay(iterateList.next());
		}
		printMessageOnDisplay("----------------------------------------------");
		
	}
	
	/**
	 * @method displayCartItemList()
	 * displaying cart Item list on user view ( console )
	 * */
	public static void displayCartItemList(List<String> cartItemList){
		if(cartItemList.size()!=0)
		{
			printMessageOnDisplay("-----------------CART ITEMS LIST-----------------");
			Iterator<String> iterateList=cartItemList.iterator();
			while(iterateList.hasNext())
			{
				printMessageOnDisplay(iterateList.next());
			}
			printMessageOnDisplay("-------------------------------------------------");
			
		}
		else
		{
			printMessageOnDisplay("-------------Cart is Empty---------------");
		}
	}
	
	/**
	 * @method printMessageOnDisplay()
	 * method printing message on user view (console), which is passed in parameter
	 * */
	public static void printMessageOnDisplay(String message)
	{
		System.out.println(message);
	}
	
}
