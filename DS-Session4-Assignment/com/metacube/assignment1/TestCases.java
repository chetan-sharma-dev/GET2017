package com.metacube.assignment1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestCases {
	PrintingJobPool printingJobPoolObject;
	
	@Before
	public void initialize(){
		printingJobPoolObject=new PrintingJobPool();
	}
	

	@Parameters
	public static Collection insert() {
		return Arrays.asList(new Object[][][] {
				{{"chetan",1},{"----------------------------------------------------------\n"
					+"Sequence No :1\n"
					+"Request Type :UNDER GRADUATE\n"
					+"Job Priority :1\n"
					+"Document Data :chetan\n"
					+"-------------------------------------------------------"} }
							});
	}
	
	@Parameter(0)
	public Object[] dataToInsert;
	@Parameter(1)
	public Object[] expectedOutput;

	@Test
	public void prinitingJobsTestsCases() {
		printingJobPoolObject.requestPrint((String)dataToInsert[0],(int)dataToInsert[1]);
		List<String> s=printingJobPoolObject.getPrintOfAllJobs();
		String actualOutput=s.get(0);
		assertEquals(expectedOutput[0], actualOutput);
	}
	
}
