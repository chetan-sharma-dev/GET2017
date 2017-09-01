package com.metacube.assignment2;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.metacube.sort.BubbleSort;
import com.metacube.sort.CountingSort;
import com.metacube.sort.QuickSort;
import com.metacube.sort.RadixSort;

public class SortingSystem {

	/**
	 * @method takeIntegerInput()
	 * taking integer input 
	 * */
	private int takeIntegerInput(){
		try{
			Scanner scanInput=new Scanner(System.in);
			return scanInput.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Invalid integer input"+e);
			return takeIntegerInput();
		}
	}

	
	
	public String showMenuAndCallSortingMethods(List<Integer> userInputList){
		System.out.println("Enter your choice (Select a sorting technique) :- \n"
				+ "1. Comparison Sorting \n"
				+ "2. Linear Sorting \n"
				+ "3. Exit");
		int choice=takeIntegerInput();
		switch(choice){
			case 1: 
				System.out.println("Comparison Sorting");
				if(userInputList.size()<=10){
					BubbleSort<Integer> bubbleSortObject=new BubbleSort<Integer>();
					return "Bubble Sort Used : "+bubbleSortObject.sortList(userInputList).toString();
				}else{
					QuickSort<Integer> quickSortObject=new QuickSort<Integer>();
					return "Bubble Sort Used : "+quickSortObject.sortList(userInputList).toString();
				}
			case 2:
				System.out.println("Linear Sorting");
				int largestNo=Collections.max(userInputList);
				int minimumNo=Collections.min(userInputList);
			
				int noOfDigitsInLargestNo=String.valueOf(largestNo).length();
				int noOfDigitsInMinimumNo=String.valueOf(minimumNo).length();
				
				int maximumDigits=(noOfDigitsInLargestNo>noOfDigitsInMinimumNo)?noOfDigitsInLargestNo:noOfDigitsInMinimumNo;
			
				if(maximumDigits>2){
					RadixSort radixSortObject=new RadixSort();
					return "Radix Sort Used : \n Sorted list is : "+radixSortObject.sort(userInputList).toString();	
				}else{
					CountingSort countingSortObject=new CountingSort();
					return "Counting Sort Used : \n Sorted list is : "+countingSortObject.sort(userInputList).toString();
				}
			case 3:
				return "Exit";
			default:
				System.out.println("Invalid choice entered");	
		}
		return showMenuAndCallSortingMethods(userInputList);
	}
	
	

}
