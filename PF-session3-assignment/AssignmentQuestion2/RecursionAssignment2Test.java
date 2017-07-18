package pfsession3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/*
 * here are positive, negative and Exception test cases
 * */

public class RecursionAssignment2Test {
	/*
	 * created single common object for all test cases
	 */
	RecursionAssignment2 search_element;

	@Before
	public void objectCreation() {
		 search_element = new RecursionAssignment2();
	}
	@Test
	public void linearSearchPositiveTest(){
		int [] input={3,15,22,29,40, 55, 77};
		boolean actual_output=search_element. linearSearch(input,0,77);
		Assert.assertEquals(true, actual_output);
	}
	@Test
	public void linearSearchNegativeTest(){
		int [] input={2,5,8,9,10, 77};
		boolean actual_output=search_element. linearSearch(input,0,88);
		Assert.assertEquals(true, actual_output);
	}
	@Test
	public void linearSearchExceptionTest(){
		int [] input={};
		boolean actual_output=search_element. linearSearch(input,0, 10);
		Assert.assertEquals(true, actual_output);
	}
	@Test
	public void binarySearchPositiveTest(){
		int [] input={1,6,7,12,58,63,75,96};
		String actual_output=search_element. binarySearch(input,0,input.length-1,75);
		Assert.assertEquals("found", actual_output);
	}
	@Test
	public void binarySearchNegativeTest(){
		int [] input={1,9,19};
		String actual_output=search_element. binarySearch(input,0,input.length-1,88);
		Assert.assertEquals("found", actual_output);
	}
	@Test
	public void binarySearchExceptionTest(){
		int [] input={};
		String actual_output=search_element. binarySearch(input,0,input.length-1, 10);
		Assert.assertEquals("found", actual_output);
	}

}
