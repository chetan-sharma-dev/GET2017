package pfsession4;



import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/*
 * here are positive, negative and Exception test cases
 * some of test cases are for expected array output and some are for input array only
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
	
		Assert.assertEquals(true, get_nqueen_status.getSolution(input,0,input.length));
	}
	@Test
	public void nqueenProblemPositiveTestCase2(){
		int[][] input = new int[9][1];	
		Assert.assertEquals(false, get_nqueen_status.getSolution(input,0,input.length));
	}
	
	@Test
	public void nqueenProblemPositiveTestCase3(){
		int[][] input = new int[4][4];
		int[][] expected_output={{0,0,1,0},
				{1,0,0,0},
				{0,0,0,1},
				{0,1,0,0}};
		get_nqueen_status.getSolution(input,0,input.length);
		for(int i=0;i<input.length;i++)
		{
			Assert.assertArrayEquals(expected_output[i], input[i]);
		}
	}
	

	@Test
	public void nqueenProblemNegativeTestCase1(){
		int[][] input = new int[3][3];
		Assert.assertEquals(true, get_nqueen_status.getSolution(input,0,input.length));
	}
	
	@Test
	public void nqueenProblemNegativeTestCase2(){
		int[][] input = new int[4][4];
		int[][] expected_output={{0,0,1,0},
				{0,0,0,0},
				{0,0,0,1},
				{0,1,0,0}};
		get_nqueen_status.getSolution(input,0,input.length);
		for(int i=0;i<input.length;i++)
		{
			Assert.assertArrayEquals(expected_output[i], input[i]);
		}
	}
	@Test
	public void nqueenProblemExceptionTestCase1(){
		int[][] input = new int[1][0];
	
		Assert.assertEquals(false, get_nqueen_status.getSolution(input,0,input.length));
	}
	@Test
	public void nqueenProblemExceptionTestCase2(){
		int[][] input = new int[1][9];
	
		Assert.assertEquals(false, get_nqueen_status.getSolution(input,0,input.length));
	}
}
