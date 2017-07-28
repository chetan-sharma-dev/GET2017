package oops_session3;

import java.util.List;


/*
 * abstract class for all type promotion classes
 * */
abstract public class Promotion {
	
	public double discount;
	public List<Integer> discountedProductList;
	/*
	 * checking if promotion type is order promotion or product promotion
	 * */
	public boolean isOrderFixed=false; 
	public double minimumThresoldAmount;
	/*
	 * checking if promotion discount is in percentage or not
	 * */
	public boolean isPercentage=false;
	
	/*
	 * abstract methods for checking applicability and getting discount amount 
	 * */
	abstract public boolean isApplicable(int productId);
	abstract public double getDiscount(int productId);
	
}
