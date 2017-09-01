package com.metacube.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @class 
 * class for implementing Radix sort logic
 * */
public class RadixSort {
	/**
	 * @method radixSort()
	 * method for doing sorting using radix sort
	 * */
	public List<Integer> radixSort(List<Integer> list){
		if(list.size()>0)
		{
			int maxElement=Collections.max(list);
			int noOfDigitInMaxElement=getNoOfDigits(maxElement);
			int modulusFactor=10;
			/*
			 * calling sorting method according to position of digits from left to right
			 * resultant list will be sorted list  
			 * */
			for(int i=0;i<noOfDigitInMaxElement;i++){
				list=sortAtDigitPosition(list,modulusFactor);
				modulusFactor*=10;
			}
		}
		return list;
	}

	/**
	 * @method sortAtDigitPosition()
	 * method sort according to given position in list 
	 * */
	public List<Integer> sortAtDigitPosition(List<Integer> list,int modulusFactor){
		List[]  bucket = new List[10];
		List<Integer> listObject;
		/*
		 * we add same extracted index values in same bucket in order of they arrive 
		 * we extract digit from list element at some position from left using modulusFactor and divisionFactor 
		 * */
		Iterator<Integer> itr=list.iterator();
		int divisionFactor=modulusFactor/10;
		while(itr.hasNext()){
			int number=itr.next();
			int digit=(number%modulusFactor)/divisionFactor;
			if(bucket[digit]==null){
				listObject=new ArrayList<Integer>();
				listObject.add(number);
				bucket[digit]=listObject;
			}else{
				bucket[digit].add(number);
			}
		}
		
		/**
		 * after adding all elements in bucket we trace that bucket from top 
		 * if we have some list in bucket index then we iterate list and add in new updatedNewList
		 * at last returning that updated list
		 * */
		List<Integer> updatedNewList=new ArrayList<Integer>();
		for(int i=0;i<bucket.length;i++){
			if(bucket[i]!=null){
				listObject=bucket[i];
				itr=listObject.iterator();
				while(itr.hasNext()){
					updatedNewList.add(itr.next());
				}
			}
		}
		return updatedNewList;
	}
	
<<<<<<< HEAD
	/**
	 * method initiating sort in Radix sort
	 * */
	public List<Integer> sort(List<Integer> list) {
		if(list!=null){
			/*
			 * method for checking whether there are negative no or not in list 
			 * if yes, then converting them in positive no's first by adding absolute value of minimum negative no
			 * then apply sorting and then subtracting absolute no from sorted list elements in ordered to get previous list in sorted order
			 * else, directly apply sorting   
			 */
=======

	
	public List<Integer> sort(List<Integer> list) {
	
>>>>>>> f0988540e25be4773c01316f5089d8057f6734a5
		int minimumNumber = Collections.min(list);
		if(minimumNumber<0){
			minimumNumber=Math.abs(minimumNumber);
				Iterator<Integer> itr = list.iterator();
				int currentIndex = 0;
				while (itr.hasNext()) {
					int element = itr.next();
					list.set(currentIndex++, element + minimumNumber);
				}
<<<<<<< HEAD
				list = radixSort(list);
=======
				list = sortList(list);
>>>>>>> f0988540e25be4773c01316f5089d8057f6734a5
		
				itr = list.iterator();
				currentIndex = 0;
				while (itr.hasNext()) {
					int element = itr.next();
		
					list.set(currentIndex++, element - minimumNumber);
				}
		}else{
<<<<<<< HEAD
			list = radixSort(list);
		}
	}
		return list;
	}
	
	/**
	 * @method
	 * method to get no of digits in given no
	 * */
=======
			list = sortList(list);
		}
		return list;
	}
	
>>>>>>> f0988540e25be4773c01316f5089d8057f6734a5
	public int getNoOfDigits(int number){
		return String.valueOf(number).length();
	}
	
	public static void main(String[] args) {
		List<Integer> list=new ArrayList<Integer>();
		list.add(0);
		list.add(-12345);
		list.add(53);
		list.add(-2);
		list.add(1);
		RadixSort r=new RadixSort();
		System.out.println(r.sort(list));
		
	}

}
