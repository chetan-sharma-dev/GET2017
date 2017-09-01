package com.metacube.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/**
 * @class 
 * class for implementing Counting sort logic
 * */
public class CountingSort {
	List<Integer> frequencyCountingList;
	List<Integer> resultIndexList;
	List<Integer> uniqueValuesOfList;
	
<<<<<<< HEAD
	/**
	 * @method initializeAllList()
	 * method for initializing all Lists variables 
	 * */
	private void initializeAllList(int listSize){
=======
	public void initializeAllList(int listSize){
>>>>>>> f0988540e25be4773c01316f5089d8057f6734a5
		frequencyCountingList=Arrays.asList(new Integer[listSize]);
		resultIndexList=Arrays.asList(new Integer[listSize]);
		uniqueValuesOfList=new ArrayList<Integer>();
		
	}
	
	/**
	 * @method initializeFrequencyCountingList()
	 * method for initializing frequency list of characters
	 * @param take a list as parameter for initializing frequency of each no
	 * */
	private void initializeFrequencyCountingList(List<Integer> list){
		/*
		 * iterating list and initializing frequencyCounter list
		 * along with it we create a list of unique Values Of Lists also
		 * */
		Iterator<Integer> itr=list.iterator();
		while(itr.hasNext()){
			int element=itr.next();
			if(frequencyCountingList.get(element)==null){
				frequencyCountingList.set(element,1);
			}else{
				frequencyCountingList.set(element,frequencyCountingList.get(element)+1);
			}
			if(!uniqueValuesOfList.contains(element)){
				uniqueValuesOfList.add(element);
			}
		}
		// sorting unique values
		Collections.sort(uniqueValuesOfList);
	}
<<<<<<< HEAD

	/**
	 * @method initializeResultIndexList()
	 * method for initializing resultIndex of element position in counting sort using frequencyCounting list
	 * */
	private void initializeResultIndexList() {
		Iterator<Integer> itr = uniqueValuesOfList.iterator();
		/**
		 * iterating uniqueValuesIndex and initializing the same numbered index in resultIndexList
		 * */
=======
	
	public void initializeResultIndexList() {
		Iterator<Integer> itr = uniqueValuesOfList.iterator();
>>>>>>> f0988540e25be4773c01316f5089d8057f6734a5
		int previousElementPosition = 0;
		while (itr.hasNext()) {
			int element = itr.next();
			resultIndexList.set(element, frequencyCountingList.get(element)+ previousElementPosition);
			previousElementPosition += frequencyCountingList.get(element);

		}
	}

<<<<<<< HEAD
	/**
	 * @method countingSort()
	 * method initiating counting sort
	 * */
	private List<Integer> countingSort(List<Integer> list) {
		/**
		 * first of all according to list initializing all data members of class
		 * */
=======
	public List<Integer> sortList(List<Integer> list) {
>>>>>>> f0988540e25be4773c01316f5089d8057f6734a5
		initializeAllList(Collections.max(list) + 1);
		initializeFrequencyCountingList(list);
		initializeResultIndexList();

<<<<<<< HEAD
		/**
		 * iterating list from start to end ,
		 * and picking position from result index list and decrementing the index counter after tracing particular element
		 * */
=======
>>>>>>> f0988540e25be4773c01316f5089d8057f6734a5
		Iterator<Integer> itr = list.iterator();
		List<Integer> sortedList = Arrays.asList(new Integer[list.size()]);
		while (itr.hasNext()) {
			int element = itr.next();
			resultIndexList.set(element, resultIndexList.get(element) - 1);
			sortedList.set(resultIndexList.get(element), element);

		}
		return sortedList;
	}

<<<<<<< HEAD
	/**
	 * @method sort()
	 * method take calls counting sort method to sort
	 * and do some initial checking for negative no's and null values
	 * */
	public List<Integer> sort(List<Integer> list) {
		if(list!=null){
			/*
			 * method for checking whether there are negative no or not in list 
			 * if yes, then converting them in positive no's first by adding absolute value of minimum negative no
			 * then apply sorting and then subtracting absolute no from sorted list elements in ordered to get previous list in sorted order
			 * else, directly apply sorting   
			 */
			 int minimumNumber = Collections.min(list);
			if(minimumNumber<0){
				minimumNumber=Math.abs(minimumNumber);
					Iterator<Integer> itr = list.iterator();
					int currentIndex = 0;
					while (itr.hasNext()) {
						int element = itr.next();
						list.set(currentIndex++, element + minimumNumber);
					}
					
					list = countingSort(list);
			
					itr = list.iterator();
					currentIndex = 0;
					while (itr.hasNext()) {
						int element = itr.next();
						list.set(currentIndex++, element - minimumNumber);
					}
			}else{
				list = countingSort(list);
			}
=======
	public List<Integer> sort(List<Integer> list) {

		int minimumNumber = Collections.min(list);
		if(minimumNumber<0){
			minimumNumber=Math.abs(minimumNumber);
				Iterator<Integer> itr = list.iterator();
				int currentIndex = 0;
				while (itr.hasNext()) {
					int element = itr.next();
					list.set(currentIndex++, element + minimumNumber);
				}
				list = sortList(list);
		
				itr = list.iterator();
				currentIndex = 0;
				while (itr.hasNext()) {
					int element = itr.next();
		
					list.set(currentIndex++, element - minimumNumber);
				}
		}else{
			list = sortList(list);
>>>>>>> f0988540e25be4773c01316f5089d8057f6734a5
		}
		return list;
	}
	
<<<<<<< HEAD
	/**
	 * main method 
	 * */
=======
>>>>>>> f0988540e25be4773c01316f5089d8057f6734a5
	public static void main(String[] args) {
		CountingSort c=new CountingSort();
		List<Integer> list=new ArrayList<Integer>();
		list.add(1232);
		list.add(150);
		list.add(5);
		list.add(250);
		list.add(6);

<<<<<<< HEAD
		System.out.println(c.sort(null));
=======
>>>>>>> f0988540e25be4773c01316f5089d8057f6734a5
		System.out.println(c.sort(list).toString());
	}
}
