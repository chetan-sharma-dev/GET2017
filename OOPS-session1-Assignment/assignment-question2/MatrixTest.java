package oopsassignment1;

import org.junit.Assert;
import org.junit.Test;

/**
 * @class MatrixTest having positive ,negative and Exception teast cases
 * 
 * */

public class MatrixTest {
	/*
	 * created single common object for all test cases
	 */
	Matrix access_matrix_method;

	/*
	 * positive test case of addElement method should succeed
	 */
	@Test
	public void matrixAddElementPositiveTestCase() {

		access_matrix_method = new Matrix(2, 2);
		access_matrix_method.addElements(0, 0, 4);
		access_matrix_method.addElements(0, 1, 5);

		int[][] expected_output = { { 4, 5 }, { 0, 0 } };
		int[][] actual_output = access_matrix_method.show();
		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}

	/*
	 * Negative test cases of matrixAddElemenry method should fail
	 */

	@Test
	public void matrixAddElementNegativeTestCase() {

		access_matrix_method = new Matrix(2, 2);
		access_matrix_method.addElements(0, 0, 4);
		access_matrix_method.addElements(0, 1, 5);
		access_matrix_method.addElements(1, 0, 6);
		access_matrix_method.addElements(1, 1, 7);
		int[][] expected_output = { { 4, 5 }, { 6, 8 } };
		int[][] actual_output = access_matrix_method.show();
		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}

	/*
	 * Exception test cases of matrixAddElemenry method should return exception
	 * message due to negative index
	 */
	@Test
	public void matrixAddElementExceptionTestCase() {

		access_matrix_method = new Matrix(2, 2);
		access_matrix_method.addElements(0, 0, 4);
		access_matrix_method.addElements(0, 1, 5);
		access_matrix_method.addElements(1, -1, 6);
		access_matrix_method.addElements(1, 1, 7);
		int[][] expected_output = { { 4, 5 }, { 6, 8 } };
		int[][] actual_output = access_matrix_method.show();
		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}

	/*
	 * positive test case
	 */
	@Test
	public void matrixTransposePositiveTestCase() {

		access_matrix_method = new Matrix(2, 2);
		access_matrix_method.addElements(0, 0, 4);
		access_matrix_method.addElements(0, 1, 5);
		access_matrix_method.addElements(1, 0, 6);
		access_matrix_method.addElements(1, 1, 7);
		int[][] expected_output = { { 4, 6 }, { 5, 7 } };
		access_matrix_method = access_matrix_method.transpose();
		int[][] actual_output = access_matrix_method.show();

		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}

	/*
	 * negative test case for matrixTranapose
	 */
	@Test
	public void matrixTransposeNegativeTestCase() {

		access_matrix_method = new Matrix(2, 2);
		access_matrix_method.addElements(0, 0, 4);
		access_matrix_method.addElements(0, 1, 5);
		access_matrix_method.addElements(1, 0, 6);
		access_matrix_method.addElements(1, 1, 7);
		int[][] expected_output = { { 4, 8 }, { 5, 7 } };
		access_matrix_method = access_matrix_method.transpose();
		int[][] actual_output = access_matrix_method.show();

		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}

	/*
	 * Exception test cases of matrixTranspose method should return exception
	 * message due to empty matrix
	 */

	@Test
	public void matrixTransposeExceptionTestCase() {

		access_matrix_method = new Matrix(0, 0);

		int[][] expected_output = new int[0][0];
		access_matrix_method = access_matrix_method.transpose();
		int[][] actual_output = access_matrix_method.show();
		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}
	/*
	 * Positive test 
	 * matrixMultiply method
	 * */	
	@Test
	public void matrixMultiplyPositiveTestCase() {

		access_matrix_method = new Matrix(3, 2);
		Matrix access_matrix_method1 = new Matrix(2, 3);

		access_matrix_method.addElements(0, 0, 1);
		access_matrix_method.addElements(0, 1, 2);
		access_matrix_method.addElements(1, 0, 3);
		access_matrix_method.addElements(1, 1, 4);
		access_matrix_method.addElements(2, 0, 5);
		access_matrix_method.addElements(2, 1, 6);
		access_matrix_method1.addElements(0, 0, 1);
		access_matrix_method1.addElements(0, 1, 2);
		access_matrix_method1.addElements(0, 2, 3);
		access_matrix_method1.addElements(1, 0, 4);
		access_matrix_method1.addElements(1, 1, 5);
		access_matrix_method1.addElements(1, 2, 6);

		int[][] expected_output = { { 9, 12, 15 }, { 19, 26, 33 },
				{ 29, 40, 51 } };
		int[][] actual_output = access_matrix_method
				.multiply(access_matrix_method1);
		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}
	/*
	 * Negative test 
	 * matrixMultiply method
	 * */	
	@Test
	public void matrixMultiplyNegativeTestCase() {

		access_matrix_method = new Matrix(3, 2);
		Matrix access_matrix_method1 = new Matrix(2, 3);

		access_matrix_method.addElements(0, 0, 1);
		access_matrix_method.addElements(0, 1, 2);
		access_matrix_method.addElements(1, 0, 3);
		access_matrix_method.addElements(1, 1, 4);
		access_matrix_method.addElements(2, 0, 5);
		access_matrix_method.addElements(2, 1, 6);
		access_matrix_method1.addElements(0, 0, 1);
		access_matrix_method1.addElements(0, 1, 2);
		access_matrix_method1.addElements(0, 2, 3);
		access_matrix_method1.addElements(1, 0, 4);
		access_matrix_method1.addElements(1, 1, 5);
		access_matrix_method1.addElements(1, 2, 6);

		int[][] expected_output = { { 9, 12, 15 }, { 19, 26, 33 },
				{ 29, 40, 1 } };
		int[][] actual_output = access_matrix_method
				.multiply(access_matrix_method1);
		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}

	/*
	 * Exception test cases of matrixMultiply method should return exception
	 * message due to fail matrix multiplication condition index
	 */
	@Test
	public void matrixMultiplyExceptionTestCase() {

		access_matrix_method = new Matrix(3, 2);
		Matrix access_matrix_method1 = new Matrix(2, 2);

		access_matrix_method.addElements(0, 0, 1);
		access_matrix_method.addElements(0, 1, 2);
		access_matrix_method.addElements(1, 0, 3);
		access_matrix_method.addElements(1, 1, 4);
		access_matrix_method.addElements(2, 0, 5);
		access_matrix_method.addElements(2, 1, 6);
		access_matrix_method1.addElements(0, 0, 1);
		access_matrix_method1.addElements(0, 1, 2);
		access_matrix_method1.addElements(1, 0, 4);
		access_matrix_method1.addElements(1, 1, 5);

		int[][] expected_output = new int[0][0];

		int[][] actual_output = access_matrix_method
				.multiply(access_matrix_method1);
		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}

	/*
	 * Positive test case matrixShow method
	 */
	@Test
	public void matrixShowPositiveTestCase() {

		access_matrix_method = new Matrix(2, 2);
		access_matrix_method.addElements(0, 0, 4);
		access_matrix_method.addElements(0, 1, 5);
		access_matrix_method.addElements(1, 0, 6);
		access_matrix_method.addElements(1, 1, 7);
		int[][] expected_output = { { 4, 5 }, { 6, 7 } };
		int[][] actual_output = access_matrix_method.show();
		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}

	/*
	 * Negative test matrixShow method
	 */
	@Test
	public void matrixShowNegativeTestCase() {

		access_matrix_method = new Matrix(2, 2);
		access_matrix_method.addElements(0, 0, 4);
		access_matrix_method.addElements(0, 1, 5);
		access_matrix_method.addElements(1, 0, 6);
		access_matrix_method.addElements(1, 1, 7);
		int[][] expected_output = { { 4, 7 }, { 6, 8 } };
		int[][] actual_output = access_matrix_method.show();
		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}

	/*
	 * Exception test cases of matrixShow method should return exception message
	 * due to negative index
	 */

	@Test
	public void matrixShowExceptionTestCase() {

		access_matrix_method = new Matrix(0, 0);

		int[][] expected_output = {};
		int[][] actual_output = access_matrix_method.show();
		for (int i = 0; i < expected_output.length; i++) {
			Assert.assertArrayEquals(expected_output[i], actual_output[i]);
		}

	}
}
