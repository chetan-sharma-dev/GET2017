package com.metacube.testcases;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.metacube.binarysearch.BinarySearch;

public class BinarySearchTestCaseForStringTypeData {
	BinarySearch<String> search;

	@Before
	public void setUpObject() {
	search = new BinarySearch<String>();
	}

	@Parameters
	public static Collection<Object[]> insert() {
	return Arrays.asList(new Object[][] { { "hello", 3 }, {"Hello" , 1 }, { "he", 2 },
	{ "chetan", -1 }, { "sharma", 4 } });
	}

	@Parameter(0)
	public String searchData;
	@Parameter(1)
	public int expectedPosition;

	@Test
	public void binarySearchTestsCases() {
		String[] arr = {"Hello","a","he","hello","sharma","z"};
	int actualPosition = search.binarySearch(arr,searchData);
	assertEquals(actualPosition, expectedPosition);
	}
}
