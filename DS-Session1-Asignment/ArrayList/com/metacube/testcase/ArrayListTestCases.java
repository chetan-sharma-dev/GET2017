package com.metacube.testcase;
import static org.junit.Assert.*;
import java.util.Iterator;
import org.junit.Before;
import org.junit.Test;
import com.metacube.arraylist.ArrayList;
import com.metacube.enums.SortingOrder;
import com.metacube.listinterface.List;
public class ArrayListTestCases<E extends Comparable<E>> {
	List<String> arrayListObject;

	@Before
	public void setUpObject() {
		arrayListObject = new ArrayList<String>();
		arrayListObject.add("Abc");
		arrayListObject.add("xyz");
	}

	@Test
	public void positiveTestCaseForSize()
	{
		int actualOutput=arrayListObject.size();
		int expectedOutput=2;
		assertEquals(expectedOutput,actualOutput);
	}
	
	@Test
	public void positiveTestCaseForAddingElementAtLast()
	{
		boolean actualOutput=arrayListObject.add("LL");
		boolean expectedOutput=true;
		assertEquals(expectedOutput, actualOutput);	
	}
	
	
	@Test
	public void addElementAtIndexPositiveTestCase()
	{
		int previousSize=arrayListObject.size();
		arrayListObject.add(previousSize-1, "second LAST");
		int currentSize=arrayListObject.size();
		assertEquals(previousSize+1, currentSize);
	}
	
	@Test(expected = IndexOutOfBoundsException.class )
	public void addElementAtIndexExceptionTestCase()
	{
		int previousSize=arrayListObject.size();
		arrayListObject.add(-1, "second LAST");
		int currentSize=arrayListObject.size();
		assertEquals(previousSize+1, currentSize);
	}
	
	@Test
	public void indexOfPositiveTestCase() throws Exception 
	{
		arrayListObject.add(1,"chetan");
		int actualOutput=arrayListObject.indexOf("chetan");
		int expectedOutput=1;
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void indexOfNegativeTestCase() throws Exception 
	{
		int actualOutput=arrayListObject.indexOf("sharma");
		int expectedOutput=-1;
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void removeFromPositionPositiveTestCase()
	{
		String actualOutput=arrayListObject.remove(0);
		String expectedOutput="Abc";
		assertEquals(expectedOutput, actualOutput);
		
	}
	
	@Test(expected = IndexOutOfBoundsException.class )
	public void removeFromExceptionTestCase()
	{
		String actualOutput=arrayListObject.remove(-1);
		String expectedOutput="Abc";
		assertEquals(expectedOutput, actualOutput);	
	}
	
	@Test
	public void removeByValuePositiveTestCase() throws Exception
	{
		boolean actualOutput=arrayListObject.remove("xyz");
		boolean expectedOutput=true;
		assertEquals(expectedOutput, actualOutput);
		
	}
	
	@Test
	public void removeByValueNegativeTestCase() throws Exception
	{
		boolean actualOutput=arrayListObject.remove("");
		boolean expectedOutput=false;
		assertEquals(expectedOutput, actualOutput);	
	}
	
	@Test
	public void sortTestCase(){
		List<String> listObject=new ArrayList<String>();
		listObject.add("50");
		listObject.add("30");
		listObject.add("40");
		listObject.add("60");
		listObject.add("70");
		listObject.add("10");
		listObject.add("20");
		
		System.out.println("Before sorting");
		Iterator<String> itr=listObject.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+",");
		}
		System.out.println("\nAfter sorting");
		listObject.sort(SortingOrder.Ascending);
		 itr=listObject.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+",");
		}
		
		
	}
	@Test
	public void addListTestCase(){
		List<String> listObject=new ArrayList<String>();
		listObject.add("50");
		listObject.add("60");
		listObject.add("20");
		
		List<String> secondListObject=new ArrayList<String>();
		secondListObject.add("30");
		secondListObject.add("40");
		secondListObject.add("70");
		secondListObject.add("10");
		System.out.println("\nBefore adding new List");
		Iterator<String> itr=listObject.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+",");
		}
		
		System.out.println("\nAfter adding new list");
		listObject.addList(secondListObject);
		 itr=listObject.iterator();
		while(itr.hasNext())
		{
			System.out.print(itr.next()+",");
		}
		
		
	}
	
}
