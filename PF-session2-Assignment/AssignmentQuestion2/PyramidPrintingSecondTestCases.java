package pfsession;

import static org.junit.Assert.*;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class PyramidPrintingSecondTestCases {
	PyramidPrintingSecond printing_pyramid;

	@Before
	public void objectCreation() {
		printing_pyramid = new PyramidPrintingSecond();
	}

	
	@Test
	public void spaceHappyTestCase() {
		String expected_space_string = "        ";
		String actual_output_space_string = printing_pyramid.spaceString(5, 5);
		assertEquals(expected_space_string, actual_output_space_string);

	}

	@Test
	public void spaceUnhappyTestCase() {
		String expected_space_string = "    ";
		String actual_output_space_string = printing_pyramid.spaceString(2, 5);
		assertEquals(expected_space_string, actual_output_space_string);

	}

	@Test(expected=NumberFormatException.class)
	public void spaceExceptionTestCase() {
		String expected_space_string = "        ";
		String actual_output_space_string = printing_pyramid.spaceString(6, 5);
		assertEquals(expected_space_string, actual_output_space_string);

	} 
	
	@Test
	public void numberHappyTestCase() {
		String expected_space_string = "1 2 3 4 5 ";
		String actual_output_space_string = printing_pyramid.numberString(1, 5);
		assertEquals(expected_space_string, actual_output_space_string);

	}

	@Test
	public void numberUnhappyTestCase() {
		String expected_space_string = "1 2 3 ";
		String actual_output_space_string = printing_pyramid.numberString(2, 5);
		assertEquals(expected_space_string, actual_output_space_string);

	}

	@Test(expected = NumberFormatException.class)
	public void numberExceptionTestCase() {
		String expected_space_string = "1 2 3 ";
		String actual_output_space_string = printing_pyramid.numberString(-2, 5);
		assertEquals(expected_space_string, actual_output_space_string);

	}
	
	@Test
	public void pyramidPrintingHappyCase() {
		String[] expected_space_string = { "1 2 ", "  1 " };
		String[] actual_output_space_string = printing_pyramid.printpyramid(2);
		assertTrue(Arrays.equals(expected_space_string,
				actual_output_space_string));

	}

	@Test
	public void pyramidPrintingUnhappyCase() {
		
		String[] expected_space_string = { "1 2 3 ", "1 2  ", " 1" };
		String[] actual_output_space_string = printing_pyramid.printpyramid(3);
		assertTrue(Arrays.equals(expected_space_string,
				actual_output_space_string));
	}

	@Test(expected = NumberFormatException.class)
	public void printPyramidZeroTest() {
		String[] expected_space_string = { "        " };
		String[] actual_output_space_string = printing_pyramid.printpyramid(0);

		assertArrayEquals(expected_space_string, actual_output_space_string);

	}

	
}
