 
package pfsession;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LongestSequenceUnitTest {
LongestSequence find_longest_sequence;
	
	@Before
	public void setUp(){
		find_longest_sequence = new LongestSequence();
	}
    
	@Test
    public void findLongestSequenceTest1() {
    int[] input = {1,2,3,2,3,4,5,3,4,2,2,3,4,5,6,7,8,1,2,4,5,6,7,8,9};
	int[] expected= {1,2,4,5,6,7,8,9};
	int[] actual_output = find_longest_sequence.longestSequence(input);
	
	Assert.assertArrayEquals(expected, actual_output);
    }
	
	@Test
    public void findLongestSequenceTest2() {
		int[] input = {2,2,2,2,2,2,2,2,2,2,2,2,2};
		int[] expected= {2};
	int[] actual_output = find_longest_sequence.longestSequence(input);
	
	Assert.assertArrayEquals(expected, actual_output);
    }
	@Test
	public void findLongestSequenceTest3() {
		int[] input = {2,3,2,3,2,3,2,3,2,3,2,3,2};
		int[] expected= {2,3};
	int[] actual_output = find_longest_sequence.longestSequence(input);
	
	Assert.assertArrayEquals(expected, actual_output);
    }

	@Test
	public void findLongestSequenceTest4() {
		int[] input = {2,3,2,3,5,2,3,2,3,2,3,2,3,4,2};
		int[] expected= {2,3,5};
	int[] actual_output = find_longest_sequence.longestSequence(input);
	
	Assert.assertArrayEquals(expected, actual_output);
    }
	@Test
	public void findLongestSequenceTest5() {
		int[] input = {9};
		int[] expected= {9};
	int[] actual_output = find_longest_sequence.longestSequence(input);
	
	Assert.assertArrayEquals(expected, actual_output);
    }
	
	@Test
	public void findLongestSequenceTest6() {
		int[] input = {};
		int[] expected= {};
		int[] actual_output = find_longest_sequence.longestSequence(input);
	
	Assert.assertArrayEquals(expected, actual_output);
    }
}
