package oops_session3;



public class OrderFixedAmountPromotion extends Promotion {
	
	public OrderFixedAmountPromotion() {
		this.discount=0;
		this.isOrderFixed=true;
		this.isPercentage=false;
		this.minimumThresoldAmount=0;
	}

	public OrderFixedAmountPromotion(String discount,String minimumThresoldAmount) {
		
		this.discount=Double.parseDouble(discount);
		this.isOrderFixed=true;
		this.minimumThresoldAmount=Double.parseDouble(minimumThresoldAmount);
	}
/*
 * checking for order level discount applicability
 * */
	@Override
	public boolean isApplicable(int amountAfterProductlevelDiscount) {
		
		if(this.minimumThresoldAmount<	amountAfterProductlevelDiscount)
				return true;
		else
			return false;
		}

	public boolean isApplicable(double amountAfterProductlevelDiscount) {
		
		if(this.minimumThresoldAmount<	amountAfterProductlevelDiscount)
				return true;
		else
			return false;
		}
	
	/*
	 * returning discount amount 
	 * */
	@Override
	public double getDiscount(int amountAfterProductlevelDiscount) {

		return this.discount;
	}

	public double getDiscount(double amountAfterProductlevelDiscount) {

		return this.discount;
	}

	

}
