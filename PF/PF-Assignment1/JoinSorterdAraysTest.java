package pfsession;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JoinSorterdAraysTest {
	/*
	 * created single common object for all test cases
	 */
	JoinSortedArrays merge_arrays;

	@Before
	public void setUp() {
		merge_arrays = new JoinSortedArrays();
	}
	/*
	 * positive test case
	 */
	@Test
	public void joinSortedArrayTest1() {
		int[] a = { 1, 3, 5, 7 };
		int[] b = { -1, 2, 4, 6, 8, 9, 10 };
		int[] c = new int[a.length + b.length];
		int[] expected = { -1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		c = merge_arrays.join(a, a.length, b, b.length, c);

		Assert.assertArrayEquals(expected, c);
	}
	/*
	 * negative test case
	 */
	@Test
	public void joinSortedArrayTest2() {
		int[] a = { 0, 5, 9, 19,25 };
		int[] b = { -10, -2, 6, 10, 55 };
		int[] c = new int[a.length + b.length];
		//int[] expected = { -10, -2, 0, 5, 6, 9, 10, 19, 25, 55};
		int[] expected = { -10, -2, 1, 5, 6, 9, 10, 19, 25, 55};
		c = merge_arrays.join(a, a.length, b, b.length, c);

		Assert.assertArrayEquals(expected, c);
	}
}
