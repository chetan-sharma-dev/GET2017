package pfsession4;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * here are positive, negative and Exception test cases
 * */

public class GetStringPermutaionsTest {
	/*
	 * created single common object for all test cases
	 */
	GetPermutation get_permuted_string;

	@Before
	public void objectCreation() {
		 get_permuted_string = new GetPermutation();
	}
	@Test
	public void getStringPermutaionPositiveRepeatedTest(){
	
		List<String> expectedMoves=new ArrayList<String>();
		expectedMoves.add("AAC");
		expectedMoves.add("ACA");		
		expectedMoves.add("CAA");
		
		Assert.assertEquals(expectedMoves, get_permuted_string.permuteString("AAC"));
	}
	@Test
	public void getStringPermutaionPositiveTest(){
	
		List<String> expectedMoves=new ArrayList<String>();
		expectedMoves.add("ABC");
		expectedMoves.add("ACB");		
		expectedMoves.add("BAC");
		expectedMoves.add("BCA");
		expectedMoves.add("CAB");		
		expectedMoves.add("CBA");
		
		
		Assert.assertEquals(expectedMoves, get_permuted_string.permuteString("ABC"));
	}
	

	@Test
	public void getStringPermutaionNegativeTest(){
	
		List<String> expectedMoves=new ArrayList<String>();
		expectedMoves.add("AAC");
		expectedMoves.add("ACA");
		expectedMoves.add("AAC");		
		expectedMoves.add("ACA");		
		expectedMoves.add("CAA");
		expectedMoves.add("CAA");
		
		
		Assert.assertEquals(expectedMoves, get_permuted_string.permuteString("AAC"));
	}
	@Test
	public void getStringPermutaionExceptionTest(){
	
		List<String> expectedMoves=new ArrayList<String>();
		expectedMoves.add("");
	
		Assert.assertEquals(expectedMoves, get_permuted_string.permuteString(""));
	}

}
