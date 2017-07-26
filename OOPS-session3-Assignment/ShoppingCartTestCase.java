package oops_session3;




import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShoppingCartTestCase {


	@Test
	public void TestPositiveProductPromotionIsApplicable() {
		try {
			int noOfProductPromotions = FileOperations
					.countNoOfLinesInFile(AllConstants.PRODUCT_PROMOTION_CSV_FILE_PATH);
			Promotion[] productPromotionObject = Main
					.initializePromotionDetails(
							AllConstants.PRODUCT_PROMOTION_CSV_FILE_PATH,
							noOfProductPromotions);
			boolean result = productPromotionObject[1].isApplicable(1001);
			assertEquals(true, result);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	@Test
	public void TestNegativeProductPromotionIsApplicable() {
		try {
			int noOfProductPromotions = FileOperations
					.countNoOfLinesInFile(AllConstants.PRODUCT_PROMOTION_CSV_FILE_PATH);
			Promotion[] productPromotionObject = Main
					.initializePromotionDetails(
							AllConstants.PRODUCT_PROMOTION_CSV_FILE_PATH,
							noOfProductPromotions);
			boolean result = productPromotionObject[0].isApplicable(1001);
			assertEquals(false, result);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	

	@Test
	public void TestPositiveOrderPromotionIsApplicable() {
		try {
			int noOfOrderPromotions = FileOperations
					.countNoOfLinesInFile(AllConstants.ORDER_PROMOTION_CSV_FILE_PATH);
			Promotion[] orderPromotionObject = Main
					.initializePromotionDetails(
							AllConstants.ORDER_PROMOTION_CSV_FILE_PATH,
							noOfOrderPromotions);
			boolean result = orderPromotionObject[0].isApplicable(2001);
			assertEquals(true, result);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
	
	@Test
	public void TestNegativeOrderPromotionIsApplicable() {
		try {
			int noOfOrderPromotions = FileOperations
					.countNoOfLinesInFile(AllConstants.ORDER_PROMOTION_CSV_FILE_PATH);
			Promotion[] orderPromotionObject = Main
					.initializePromotionDetails(
							AllConstants.ORDER_PROMOTION_CSV_FILE_PATH,
							noOfOrderPromotions);
			boolean result = orderPromotionObject[1].isApplicable(100);
			assertEquals(false, result);
		} catch (Exception e) {
			System.out.println("Error" + e.getMessage());
		}
	}
}
