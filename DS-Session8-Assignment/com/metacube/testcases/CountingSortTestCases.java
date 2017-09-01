package com.metacube.testcases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.metacube.sort.CountingSort;

@RunWith(Parameterized.class)
public class CountingSortTestCases {

	CountingSort countingSortObject;
	
	@Before
	public void setUpObject() {
		countingSortObject=new CountingSort();
	}
	
	@Parameters
	public static Collection<Object[]> insert() {
	return Arrays.asList(new Object[][] { 
			{ new ArrayList<Integer>(Arrays.asList(10,-2,2,0,123)), new ArrayList<Integer>(Arrays.asList(-2, 0 ,2 ,10, 123))}, 
			{null,null}
			});
	}

	@Parameter(0)
	public List<Integer> listToBeSorted;
	@Parameter(1)
	public List<Integer> expectedSortedList;
	
	@Test
	public void countingSortTestCases(){
		List<Integer> actualSortedList=countingSortObject.sort(listToBeSorted);
		assertEquals(expectedSortedList,actualSortedList);
		
	}

	
	
}
