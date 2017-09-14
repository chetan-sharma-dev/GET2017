package com.metacube.testcases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.metacube.dao.MysqlDao;

public class TestCasesForQuries {
	
	MysqlDao daoObject;
	
	@Before
	public void initializeReferences(){
		daoObject=new MysqlDao();
	}
	
	@Test
	public void negativeTestCaseForGetBookAvailabilityStatus1(){
		String actualOutput=daoObject.getBookAvailabilityStatus("Gone Girl");
		String expectedOutput="Not Available";
		assertEquals(actualOutput,expectedOutput);
	}
	
	@Test
	public void positiveTestCaseForGetBookAvailabilityStatus(){
		String actualOutput=daoObject.getBookAvailabilityStatus("Black Beauty");
		String expectedOutput="Available";
		assertEquals(actualOutput,expectedOutput);
	}
	@Test
	public void negativeTestCaseForGetBookAvailabilityStatus2(){
		String actualOutput=daoObject.getBookAvailabilityStatus("GOT");
		String expectedOutput="Not Available";
		assertEquals(actualOutput,expectedOutput);
	}
	
	@Test
	public void positiveTestCaseForDeleteDataFromBooksTableNotIssuedInLastOneYear(){
		int actualOutput=daoObject.deleteDataFromBooksTableNotIssuedInLastOneYear();
		int expectedOutput=0;
		assertEquals(actualOutput,expectedOutput);
	}
	
}
