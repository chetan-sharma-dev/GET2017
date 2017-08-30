package com.metacube.binarysearch;

import java.util.ArrayList;
import java.util.List;
/**
*@class BinarySearch
*class for searching element in given array using binary search algorithm
*/
public class BinarySearch<E extends Comparable>{

	/**
	 * @method binarySearch()
	 * method to search element in given sorted array using binary search algorithm
	 * */
	public int binarySearch(E[] array,E dataToBeSearched){
		 return searchElementInArray(array, 0, array.length-1,dataToBeSearched);
	}
	
	/**
	 * @method searchElementInArray()
	 * method to search element in given array using binary search algorithm recursively
	 * */
	private int searchElementInArray(E[] array,int leftIndex,int rightIndex,E dataToBeSearched){
		/**
		 * checking whether we are there element to trace or not
		 * if rightIndex > leftIndex than we do search else return -1
		 * */
		if(rightIndex>=leftIndex)
		{
			/*
			 * calculating mid index 
			 * then searching whether the element is on mid index or not
			 * if yes , checking for repeated condition 
			 * else if current array element is less than the mid indexed value in array, 
			 * we call same method  recursively for searching element in left sub array
			 * else ,we call same method  recursively for searching element in right sub array
			 * */
			int mid = (leftIndex + rightIndex) / 2;
			if (array[mid] == dataToBeSearched) {
				/*
				 * In case of repeated element we have to return the index of first occurrence 
				 * so here ,if we are having same data at left of the given index element then search in left subtree
				 * else we return current element index
				 * */
				if (mid != 0 && array[mid - 1] == dataToBeSearched) {
					return searchElementInArray(array, leftIndex, mid - 1,
							dataToBeSearched);
				}
				return mid;
			} else if (dataToBeSearched.compareTo(array[mid]) < 0) {
				return searchElementInArray(array, leftIndex, mid - 1,
						dataToBeSearched);
			} else {
				return searchElementInArray(array, mid + 1, rightIndex,
						dataToBeSearched);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch<String> obj=new BinarySearch<String>();
		String[] arr = {"A","Ba","Hello","Hello","Hello","sharma","z"};
		System.out.println(obj.binarySearch(arr,"Hello"));
	}
	
}

