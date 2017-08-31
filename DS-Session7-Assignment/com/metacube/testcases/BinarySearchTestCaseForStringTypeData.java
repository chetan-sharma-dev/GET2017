package com.metacube.testcases;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.metacube.binarysearch.BinarySearch;
@RunWith(Parameterized.class)
public class BinarySearchTestCaseForStringTypeData {
	BinarySearch<String> search;

	@Before
	public void setUpObject() {
	search = new BinarySearch<String>();
	}

	@Parameters
	public static Collection<Object[]> insert() {
	return Arrays.asList(new Object[][] { { "hello", 2 }, {"Hello" , 0 }, { "he", 1 },
	{ "chetan", -1 }, { "sharma", 5 } });
	}

	@Parameter(0)
	public String searchData;
	@Parameter(1)
	public int expectedPosition;

	@Test
	public void binarySearchTestsCases() {
		String[] arr = {"Hello","he","hello","hello","hello","sharma","z"};
		int actualPosition = search.binarySearch(arr,(String)searchData);
		assertEquals(actualPosition, expectedPosition);
	}
}
