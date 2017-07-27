package oops_session3;

public class OrderFixedPercentPromotion extends Promotion {
	
	public OrderFixedPercentPromotion() {
		this.discount=0;
		this.isOrderFixed=true;
		this.isPercentage=true;
		this.minimumThresoldAmount=0;
	}

	public OrderFixedPercentPromotion(String discount,String minimumThresoldAmount) {
		
		this.discount=Double.parseDouble(discount);
		this.isOrderFixed=true;
		this.isPercentage=true;
		this.minimumThresoldAmount=Double.parseDouble(minimumThresoldAmount);
	}

	/*
	 * checking for order level discount applicability
	 * */
	@Override
	public boolean isApplicable(int productId) {
		
		
		return false;
	}

	public boolean isApplicable(double amountAfterProductlevelDiscount) {
		
		if(this.minimumThresoldAmount<	amountAfterProductlevelDiscount)
				return true;
		else
			return false;
		}
	/*
	 * returning discount amount after calculating percentages
	 * */
	@Override
	public double getDiscount(int amountAfterProductlevelDiscount) {

		return (amountAfterProductlevelDiscount*this.discount)/100;
	}

	

}
