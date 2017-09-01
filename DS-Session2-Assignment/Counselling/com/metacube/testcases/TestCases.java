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

import com.metacube.entity.Student;
import com.metacube.queue.MyQueue;

@RunWith(Parameterized.class)
public class TestCases {
	MyQueue queueObject;
	
	@Before
	public void setUpObject() {
		queueObject=new MyQueue();
	}
	
	@Parameters
	public static Collection<Object[][]> insert() {
		return Arrays.asList(new Object[][][] {
				{{1,2,3},{1,2,3} },
				{{"2","1","3"},{"2","1","3"}},
				{{"1",1,3},{"1",1,3}},
		});
	}
	
	@Parameter(0)
	public Object[] dataToInsert;
	@Parameter(1)
	public Object[] expectedOutput;
	
	@SuppressWarnings("deprecation")
	@Test
	public void queueTestsCases() {
		for(int i=0;i<dataToInsert.length;i++){
			queueObject.enqueue(dataToInsert[i]);
		}
		Object[] actualOutput=new Object[expectedOutput.length];
		for(int i=0;i<expectedOutput.length;i++){
			actualOutput[i]=queueObject.dequeue();
		}
		assertEquals(expectedOutput, actualOutput);
	}
}
