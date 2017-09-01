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
import com.metacube.stack.Stack;

@RunWith(Parameterized.class)
public class StackTestCase {
	Stack stackObject;
	
	@Before
	public void setUpObject() {
		stackObject=new Stack();
	}
	
	@Parameters
	public static Collection<Object[][]> insert() {
		return Arrays.asList(new Object[][][] {
				{{1,2,3},{3,2,1} },
				{{1,"hel","one",9},{9,"one","hel",1}}
		});
	}
	
	@Parameter(0)
	public Object[] dataToInsert;
	@Parameter(1)
	public Object[] expectedOutput;
	
	@SuppressWarnings("deprecation")
	@Test
	public void stackTestsCases() {
		for(int i=0;i<dataToInsert.length;i++){
			stackObject.push(dataToInsert[i]);
		}
		Object[] actualOutput=new Object[expectedOutput.length];
		for(int i=0;i<dataToInsert.length;i++){
			actualOutput[i]=stackObject.pop();
		}
		assertEquals(expectedOutput, actualOutput);
	}
}
