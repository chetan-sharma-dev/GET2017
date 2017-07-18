package pfsession3;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * here are positive, negative and Exception test cases
 * */
public class QuickSortTestCase {
	/*
	 * created single common object for all test cases
	 */
	QuickSort sort_quick;

	@Before
	public void objectCreation() {
		 sort_quick = new QuickSort();
	}
	
	@Test
	public void quickSortPositiveTestCase() {
		int[] input_array = { 1,12,3,-1,15,9,80,-8,0 };
		int[] expected_output={-8,-1,0,1,3,9,12,15,80};
		sort_quick.quickSort(input_array, 0, input_array.length - 1);
		Assert.assertArrayEquals(expected_output,input_array);

	
	}
	@Test
	public void quickSortNegativeTestCase() {
		int[] input_array = { 1,12,3,-1,15,9,80,-8,02,55,99 };
		int[] expected_output={-8,-1,1,2,3,9,12,15,55,99,80};
		sort_quick.quickSort(input_array, 0, input_array.length - 1);
		Assert.assertArrayEquals(expected_output,input_array);

	/*
	 * exception handled
	 * */
	}
	@Test
	public void quickSortExceptionTestCase() {
		int[] input_array = { };
		int[] expected_output={-8,-1,1,2,3,9,12,15,55,99,80};
		sort_quick.quickSort(input_array, 0, input_array.length - 1);
		Assert.assertArrayEquals(expected_output,input_array);

	
	}
}
