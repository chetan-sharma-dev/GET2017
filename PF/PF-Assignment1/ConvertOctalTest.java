package pfsession;
/*test cases for binary to octal conversion
 * */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ConvertOctalTest {
	/*
	 * created single common object for all test cases
	 */
	ConvertionBinaryToOctal convert_to_octal;

	@Before
	public void setUp() {
		convert_to_octal = new ConvertionBinaryToOctal();
	}
	/*
	 * this will show exception as this is negative no not a binary no
	 */
	@Test
	public void getOctalTest1() {

		int oct = convert_to_octal.convertBinaryToOctal(-1);
		assertEquals(66, oct);
	}
	/*
	 * this is negative test should fail . we passed here wrong expected value
	 */
	@Test
	public void getOctalTest2() {
		int var = Integer.parseInt("0001000");
		int oct = convert_to_octal.convertBinaryToOctal(var);
		assertEquals(4, oct);
	}
	/*
	 * this is Positive test, should not fail .
	 */
	@Test
	public void getOctalTest3() {
		int var = Integer.parseInt("110101");
		int oct = convert_to_octal.convertBinaryToOctal(var);
		assertEquals(65, oct);
	}
	/*
	 * this is Negative test, here we passed non binary no .
	 */
	@Test
	public void getOctalTest4() {
		int var = Integer.parseInt("abcd");
		int oct = convert_to_octal.convertBinaryToOctal(var);
		assertEquals(65, oct);

	}
	/*
	 *here we Are checking for null as a string
	 */
	@Test
	public void getOctalTest5() {
		int var = 0;
		int oct = 0;
		try {
			var = Integer.parseInt("null");
			oct = convert_to_octal.convertBinaryToOctal(var);

		} catch (Exception e) {
			System.out.println(e);
		}
		assertEquals(65, oct);
	}
	/*
	 * it's non binary no so it should fail.
	 */
	@Test
	public void getOctalTest6() {
		int var = Integer.parseInt("1256");
		int oct = convert_to_octal.convertBinaryToOctal(var);
		assertEquals(65, oct);

	}
}
