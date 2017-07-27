package oops_session3;




import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoppingCartTestCase {

int noOfProducts,noOfProductPromotions,noOfOrderPromotions;
	Product[] productObject;
	Promotion[] productPromotionObject;
	 Promotion[] orderPromotionObject;
	@Before
	public void setUp(){
		try{
		 noOfProducts=FileOperations.countNoOfLinesInFile(AllConstants.PRODUCT_LIST_CSV_FILE_PATH);
			
		 noOfProductPromotions = FileOperations.countNoOfLinesInFile(AllConstants.PRODUCT_PROMOTION_CSV_FILE_PATH);
		 noOfOrderPromotions = FileOperations
					.countNoOfLinesInFile(AllConstants.ORDER_PROMOTION_CSV_FILE_PATH);
		 productObject=Product.initializeProductDetails(AllConstants.PRODUCT_LIST_CSV_FILE_PATH, noOfProducts);

		 productPromotionObject = Main.initializePromotionDetails(AllConstants.PRODUCT_PROMOTION_CSV_FILE_PATH,noOfProductPromotions);
		 orderPromotionObject = Main.initializePromotionDetails(AllConstants.ORDER_PROMOTION_CSV_FILE_PATH,noOfOrderPromotions);
		}catch(Exception e){
			System.out.println("Error" + e.getMessage());
		}
	}
	
	@Test
	public void TestGetPromotionObject(){
		String[] promotionDetails={"OrderFixedAmountPromotion","100.00","1000.00"};
		Promotion resultObject=Main.getPromotionObject(promotionDetails);
		Assert.assertEquals(resultObject.discount,100,2);
	}

	// testcase to check if product promotion is applicable or not
	@Test
	public void testPositiveProductPromotionIsApplicable() {
		try {
			
			boolean result = productPromotionObject[1].isApplicable(1001);
			assertEquals(true, result);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	// testcase to check if product promotion is applicable or not
	@Test
	public void testNegativeProductPromotionIsApplicable() {
		try {
			
			boolean result = productPromotionObject[0].isApplicable(1001);
			assertEquals(false, result);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	// testcase to check if order promotion is applicable or not
	@Test
	public void testPositiveOrderPromotionIsApplicable() {
		try {
			
			
			boolean result = orderPromotionObject[0].isApplicable(2000);
			assertEquals(true, result);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	// testcase to check if order promotion is applicable or not
	@Test
	public void testNegativeOrderPromotionIsApplicable() {
		try {
		
			boolean result = orderPromotionObject[1].isApplicable(100);
			assertEquals(false, result);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	//testcase to check function for returning number of lines
	@Test
	public void testCountNumberOfLineInFile(){
		try{
		int result=FileOperations.countNoOfLinesInFile(AllConstants.PRODUCT_LIST_CSV_FILE_PATH);
		assertEquals(3, result);
		}
		catch(Exception e){
			System.out.println("Error" + e.getMessage());
		}
	}
	
	//testcase to check correct initialisation of order promotion object
	@Test
	public void testInitializeOrderPromotionDetailsPositive(){
		try{
			
			Promotion[] expected = new Promotion[3];
			expected[0]=new OrderFixedAmountPromotion();
			expected[1]=new OrderFixedAmountPromotion();
			expected[2]=new OrderFixedPercentPromotion();
			expected[0].discount=100.00;
			expected[1].discount=200.00;
			expected[2].discount=10.00;
			for(int i=0;i<noOfOrderPromotions;i++){
				Assert.assertEquals(expected[i].discount,orderPromotionObject[i].discount ,0.01);
			}
			
		
		}
		catch(Exception e){
			System.out.println("Error" + e.getMessage());
		}		
	}
	

	//testcase to check correct initialisation of product promotion object
	@Test
	public void testInitializeProductPromotionDetailsPositive(){
		try{
			
			
			Promotion[] expected=new Promotion[3];
			expected[0]=new ProductFixedAmountPromotion();
			expected[1]=new ProductFixedAmountPromotion();
			expected[2]=new ProductFixedPercentPromotion();
			expected[0].discount=350.00;
			expected[1].discount=100.00;
			expected[2].discount=15.00;
			for(int i=0;i<noOfProductPromotions;i++){
				Assert.assertEquals(expected[i].discount,productPromotionObject[i].discount , 0.01);
			}
		}
		catch(Exception e){
			System.out.println("Error" + e.getMessage());
		}		
	}
	
	// test to check functionality of calculate product promotion to apply
	@Test
	public void testCalculateProductPromotionToApplyPositive(){
		try{
		
			Order orderObject =new Order();
			orderObject.setOrderedProductList(1001, 2);
			orderObject.setOrderedProductList(1002, 1);
			
			PromotionResult promotionResultObject=new PromotionResult();
		
			promotionResultObject.calculateProductPromotionToApply(orderObject, productPromotionObject);
			double result=orderObject.getProductLevelDiscount();
			Assert.assertEquals(271.85, result,0.01);
		}catch(Exception e){
			System.out.println("Error");
			e.printStackTrace();
		}
	}
	
	// test to check functionality of calculate order promotion to apply
	@Test
	public void testCalculateOrderPromotionToApplyPositive(){
		try{
			Order orderObject =new Order();
			orderObject.setOrderedProductList(1001, 2);
			orderObject.setOrderedProductList(1002, 1);
			PromotionResult promotionResultObject=new PromotionResult();
			promotionResultObject.calculateProductPromotionToApply(orderObject, productPromotionObject);
			promotionResultObject.calculateOrderPromotionToApply(orderObject, orderPromotionObject);
			double result=orderObject.getOrderLevelDiscount();
			Assert.assertEquals(100.00, result,0.01);
		}catch(Exception e){
			System.out.println("Error"+e.getMessage());
		}
	}
	
}
