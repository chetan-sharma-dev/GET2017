package com.metacube.assignment2;


import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;



@RunWith(Parameterized.class)
public class UniqueCharTestCase {
	static UniqueCharacters uniqueCharacters;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		uniqueCharacters = new UniqueCharacters();
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][] {
				{ "chetan", 6 },
				{ "chetan sharma", 9 },
				{ "@#$%^&*()!_+", 12 },
				{ "           ", 0 },
				{ "aABb", 4 },
				{ "1234567890", 10 },
				{ "aABb", 4 },
				{ "css", 2 },
				{ null, -1 } });
	}

	@Parameter(0)
	public String input;
	@Parameter(1)
	public int expected;

	@Test
	public void forGivenInputAndExpectedOutput() {
		int actual = uniqueCharacters.findTotalUniqueCharacters(input);
		assertEquals(actual, expected);
	}
}