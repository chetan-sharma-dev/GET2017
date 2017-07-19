package pfsession4;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/*
 * here are positive, negative and Exception test cases
 * */
public class NqueenProblemTestCase {
	/*
	 * created single common object for all test cases
	 */
	NqueenProblem get_nqueen_status;

	@Before
	public void objectCreation() {
		get_nqueen_status = new NqueenProblem();
	}
	@Test
	public void nqueenProblemPositiveTestCase1(){
		int[][] input = new int[4][4];
	
		Assert.assertEquals(true, get_nqueen_status.getSolution(input));
	}
	
	public void nqueenProblemPositiveTestCase2(){
		int[][] input = new int[9][1];	
		Assert.assertEquals(false, get_nqueen_status.getSolution(input));
	}
	

	@Test
	public void nqueenProblemNegativeTestCase1(){
		int[][] input = new int[3][3];
		Assert.assertEquals(true, get_nqueen_status.getSolution(input));
	}
	@Test
	public void nqueenProblemExceptionTestCase1(){
		int[][] input = new int[1][0];
	
		Assert.assertEquals(false, get_nqueen_status.getSolution(input));
	}
	@Test
	public void nqueenProblemExceptionTestCase2(){
		int[][] input = new int[1][9];
	
		Assert.assertEquals(false, get_nqueen_status.getSolution(input));
	}
}
