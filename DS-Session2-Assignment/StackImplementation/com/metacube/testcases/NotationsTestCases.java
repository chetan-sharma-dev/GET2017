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
import com.metacube.notations.Notations;

@RunWith(Parameterized.class)
public class NotationsTestCases {
	Notations notationObject;

	@Before
	public void setUpObject() {
		notationObject = new Notations();
	}

	@Parameters
	public static Collection<Object[]> insert() {
		return Arrays.asList(new Object[][] {
				{ "((123+12)^10)+4*6", "12312+10^46*+" },
				{ "((a+b*c^d-e)^(f+g*h)-i)", "abcd^*+e-fgh*+^i-" },
				{ "1+3-2", "13+2-" },
				{ "(123+12)^10)+4*6", "Invalid string entered" },
				{ "((123+12)^10+4*6", "Invalid string entered" } });
	}

	@Parameter(0)
	public String infixString;
	@Parameter(1)
	public String expectedPostfixOutput;

	@Test
	public void notationTestsCases() {
		String actualPostfixOutput = notationObject
				.getPostFixNotation(infixString);
		assertEquals(expectedPostfixOutput, actualPostfixOutput);
	}

}
