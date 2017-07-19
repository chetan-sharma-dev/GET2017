package pfsession4;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
/*
 * here are positive, negative and Exception test cases
 * */
public class TowerOfHanoiTest {
	/*
	 * created single common object for all test cases
	 */
	TowerOfHanoi get_moves;

	@Before
	public void objectCreation() {
		get_moves = new TowerOfHanoi();
	}
	@Test
	public void testForAnyNumber(){
	
		List<String> expectedMoves=new ArrayList<String>();
		expectedMoves.add("Move Disk 1 from A to B");
		expectedMoves.add("Move Disk 2 from A to C");		
		expectedMoves.add("Move Disk 1 from B to C");
		expectedMoves.add("Move Disk 3 from A to B");
		expectedMoves.add("Move Disk 1 from C to A");
		expectedMoves.add("Move Disk 2 from C to B");
		expectedMoves.add("Move Disk 1 from A to B");
		Assert.assertEquals(expectedMoves, get_moves.towerOfHanoi("A", "B", "C", 3));
	}
	@Test
	public void NegativeTestForAnyNumber(){
	
		List<String> expectedMoves=new ArrayList<String>();
		expectedMoves.add("Move Disk 1 from A to B");
		expectedMoves.add("Move Disk 2 from A to C");		
		expectedMoves.add("Move Disk 1 from B to C");
		expectedMoves.add("Move Disk 3 from A to B");
		expectedMoves.add("Move Disk 1 from C to A");
		expectedMoves.add("Move Disk 2 from C to B");
		expectedMoves.add("Move Disk 2 from A to B");
		Assert.assertEquals(expectedMoves, get_moves.towerOfHanoi("A", "B", "C", 3));
	}
	@Test
	public void testForOneDisk(){
		
		List<String> expectedMoves=new ArrayList<String>();
		expectedMoves.add("Move Disk 1 from A to B");
		Assert.assertEquals(expectedMoves,get_moves.towerOfHanoi("A", "B", "C", 1));
	}
	@Test
	public void ExceptionTestCase(){
		
		List<String> expectedMoves=new ArrayList<String>();
		expectedMoves.add("");
		Assert.assertEquals(expectedMoves,get_moves.towerOfHanoi("", "B", "C", 2));
	}

}
