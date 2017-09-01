package com.metacube.testcases;

import static org.junit.Assert.*;

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
public class BinarySearchTestCaseForIntegerTypeData<E> {
	BinarySearch<Integer> search;

	@Before
	public void setUpObject() {
	search = new BinarySearch<Integer>();
	}

	@Parameters
	public static Collection<Integer[]> insert() {
	return Arrays.asList(new Integer[][] { { 2, 1 }, { 10, -1 }, { 4, 10 },
	{ 3, 6 }, { 123, -1 } });
	}

	@Parameter(0)
	public Integer searchData;
	@Parameter(1)
	public int expectedPosition;

	@Test
	public void binarySearchTestsCases() {
	Integer[] arr = { 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8, 9 };
	int actualPosition = search.binarySearch(arr,searchData);
	assertEquals(actualPosition, expectedPosition);
	}
	

}
