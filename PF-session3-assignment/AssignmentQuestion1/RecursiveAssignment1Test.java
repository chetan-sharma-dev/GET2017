package pfsession3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/*
 * here are positive, negative and Exception test cases
 * */
public class RecursiveAssignment1Test {
	RecursionAssignment1 calculate;
	@Before
	public void objectCreation() {
		calculate = new RecursionAssignment1();
	}
	@Test
	public void remainderPositiveTestCase1(){
		int expectedRemainder=calculate.rem(100, 3);
		Assert.assertEquals(1, expectedRemainder);
	}
	
	@Test
	public void remainderPositiveTestCase2(){
		int expectedRemainder=calculate.rem(2,1);
		Assert.assertEquals(0, expectedRemainder);
	}
	
	
	@Test
	public void remainderExceptionTestCase(){
		calculate.rem(2, 0);
	}
	
	@Test
	public void remainderNegativeTestCase(){
		int expectedgcd=calculate.gcd(-12,18);
		Assert.assertEquals(6, expectedgcd);
	}
	
	@Test
	public void gcdPositiveTestCase1(){
		int expectedgcd=calculate.gcd(2, 1);
		Assert.assertEquals(1, expectedgcd);
	}
	
	@Test
	public void gcdPositiveTestCase2(){
		int expectedgcd=calculate.gcd(12,18);
		Assert.assertEquals(6, expectedgcd);
	}
	
	
	
	@Test
	public void gcdExceptionTestCase(){
		int expectedgcd=calculate.gcd(2,0);
		Assert.assertEquals(2, expectedgcd);
	}
	
	@Test
	public void gcdNegativeTestCase(){
		int expectedgcd=calculate.gcd(100, 3);
		Assert.assertEquals(3, expectedgcd);
	}
	
	@Test
	public void largestDigitPositiveTestCase1(){
		int expected_largest_digit=calculate.largestDigit(1234567894);
		Assert.assertEquals(1, expected_largest_digit);
	}
	
	
	@Test
	public void largestDigitExceptionTestCase(){
		int expected_largest_digit=calculate.largestDigit(-1);
		Assert.assertEquals(2, expected_largest_digit);
	}
	
	@Test
	public void largestDigitNegativeTestCase(){
		int expected_largest_digit=calculate.largestDigit(123454321);
		Assert.assertEquals(6, expected_largest_digit);
	}
}
