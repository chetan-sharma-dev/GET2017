package facade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import dao.InMemoryProductDao;
import model.Cart;
import model.OrderedItem;
import model.Product;
/**
 * @class
 * class for handling cart related business logics
 * */
public class CartFacade {
	/*
	 * all required Objects created once
	 * */
	private static CartFacade cartFacadeObject; 
	private Cart cartObject;
	private static Double totalCost;
	
	/**
	 * @constructor  initializing all objects
	 * */
	private CartFacade()
	{
		cartObject=new Cart();
	}
	/**
	 * @method getInstance()
	 * method for getting instance of CartFacade which is singleton class
	 * here double checking mechanism used for instance
	 * */
	public static CartFacade getInstance(){
		if(cartFacadeObject==null)
		{
			synchronized (CartFacade.class) {
				if(cartFacadeObject==null){
					cartFacadeObject=new CartFacade();
				}
			}
		}
		return cartFacadeObject;
	}
	
	/**
	 * @method getAllCartItems
	 * method returning allCartItems list
	 * */
	public List<String> getAllCartItems(){	
		return stringify(cartObject.getOrderedItems());	
	}
	/**
	 * @method totalCalculation()
	 * method calculating total for cart Items
	 * */
	public void totalCalculation(){
		/*
		 * getting HashMap of cart items
		 * */
		HashMap<String,OrderedItem> hashMapOfCartItems=cartObject.getOrderedItems();
		totalCost=0.0;
		/*
		 * checking for null value
		 * if hashMap is having some items then only calculating total
		 * else not calculating total 
		 * */
		if(hashMapOfCartItems!=null)
		{ 
			/*
			 * getting list of all product id's 
			 * and by iterating the list getting added item's quantity and price information 
			 * using these informations calculating total
			 * */
			OrderedItem orderedItemObject;
			List<String> keyList = new ArrayList<String>(hashMapOfCartItems.keySet());
			Iterator<String> keyListIterator=keyList.iterator();
			while(keyListIterator.hasNext()){
				orderedItemObject=hashMapOfCartItems.get(keyListIterator.next());
				totalCost+=orderedItemObject.getTotalPrice();
			}
		}
	}
	/**
	 * @method stringify()
	 * method converting given HashMap of cartItems in List of Strings
	 * */
	public List<String> stringify(HashMap<String,OrderedItem> hashMapOfCartItems){
		if(hashMapOfCartItems!=null)
		{
			List<String> cartItemsDetails=new ArrayList<String>();
			/*
			 * getting keySet and converting it into keyList
			 * */
			List<String> keyList = new ArrayList<String>(hashMapOfCartItems.keySet());
			Iterator<String> keyListIterator=keyList.iterator();
			
			OrderedItem orderedItemObject;
			Product productObject;
			int purchasedQuantity;
			String productCode;
			String productName;
			Double productCost;
			Double productSubtotal;
			/*
			 * Iterating list and it's items information 
			 * using these all informations creating new string line of ordered item details 
			 * and adding this information in string list 
			 * at last returning this list 
			 * */
			while(keyListIterator.hasNext()){
				
				orderedItemObject=hashMapOfCartItems.get(keyListIterator.next());
				productObject=orderedItemObject.getProductObject();
				productCode=productObject.getProductCode();
				productName=productObject.getProductName();
				productCost=productObject.getProductCost();
		
				purchasedQuantity=orderedItemObject.getQuantity();
				productSubtotal=orderedItemObject.getTotalPrice();
				
				String orderedProductDescription = productCode+"\t"+productName+" \t("+purchasedQuantity+" x "+productCost+" ) = "+productSubtotal;
				
				cartItemsDetails.add(orderedProductDescription);
			}
			return cartItemsDetails;
		}
		else{
				return null;
		}
	}
	
	/**
	 * @method addItem()
	 * method for adding new items in cart 
	 * returning appropriate message according to operation performed
	 * */
	public String addItem(String productCode,int productQuantity){
		Product productObject=InMemoryProductDao.getInstance().getProductObjectByProductCode(productCode);
		String successMessage="";
		/*
		 * if product is already available in cart then update quantity
		 * else add new item in cart 
		 * */
		if(!isProductAvailbleInCart(productCode))
		{
			cartObject.addItemInCart(productObject, productQuantity);
			successMessage="--------------Successfully added Product in cart--------------- ";
		}else{
			cartObject.updateQuantityOfAlreadyAddedProduct(productObject, productQuantity);
			successMessage="--------------Successfully updated prevoius Product Quntity in cart--------------- ";
		}
		/*
		 * after adding new item recalculating total
		 * */
		cartFacadeObject.totalCalculation();
		return successMessage;
	}

	/**
	 * @method updateCartItem()
	 * method for updating cartItem Quantity
	 * */
	public String updateCartItem(String productCode,int productQuantity){
		/*
		 * checking whether the product is available or not in cart 
		 * if available , Updating it with new values
		 * else, returning Error Message to Controller
		 * */
		if(isProductAvailbleInCart(productCode))
		{	
			Product productObject=InMemoryProductDao.getInstance().getProductObjectByProductCode(productCode);
			cartObject.updateItemInCart(productObject, productQuantity);
			cartFacadeObject.totalCalculation();
			return "Successfully Updated Quantity";
		}
		else
		{
			return "Entered Item is not present in cart";
		}
	}
	/**
	 * @method deleteItem()
	 * method for deleting cart items
	 * */
	public String deleteItem(String productCode){
		if(isProductAvailbleInCart(productCode))
		{	cartObject.deleteItemFromCart(productCode);
			cartFacadeObject.totalCalculation();
			return "-----------Item successfully removed from cart--------";
		}
		else
		{
			return "----------Entered Item is not in Your Cart------------";
		}
	}

	/**
	 * @method deleteAllItemsFromCart()
	 * method deletingproduct from cart if available ,else returning error message
	 * */
	public String deleteAllItemsFromCart(){
		if(cartObject.getOrderedItems().size()!=0)
		{	
			cartObject.getOrderedItems().clear();
			cartFacadeObject.totalCalculation();
			return "-----------All Items successfully removed from cart--------";
		}
		else
		{
			return "----------Your Cart Is Already Empty------------";
		}
	}
	/**
	 * @method getAllProductCodesInCart()
	 * method returning list of all products 
	 * */
	public List<String> getAllProductCodesInCart()
	{
		List<String> listOfProductsCodeInCart=new ArrayList<String>();
		/*
		 * adding keySet collection values in list and returning list 
		 * */
		listOfProductsCodeInCart.addAll(cartObject.getOrderedItems().keySet());
		return listOfProductsCodeInCart;
	}
	/**
	 * @method isProductAvailbleInCart()
	 * method checking whether the product is available in cart or not
	 * */
	public boolean isProductAvailbleInCart(String productCode){
		return getAllProductCodesInCart().contains(productCode);
	}
	
}
