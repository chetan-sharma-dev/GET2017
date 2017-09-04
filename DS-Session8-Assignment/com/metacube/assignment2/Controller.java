package com.metacube.assignment2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Controller {
	
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
	
	/**
	 * @method takeUserInputForListToBeSorted()
	 * method taking input for sorting list and storing these input into list
	 * @return list of user input
	 * */
	public List<Integer> takeUserInputForListToBeSorted(){
		System.out.println("How Many Elements you want to Enter for sorting :-");
		int noOfElements=takeIntegerInput();
		List<Integer> userInputList=new ArrayList<Integer>();
		/**
		 * taking for user , how many no's he want to enter
		 * if user enter valid input then taking these input from user and storing these input in list 
		 * at last returning list of user inputs
		 * */
		if(noOfElements<=0){
			System.out.println("Error!!! Negative No entered");
			return takeUserInputForListToBeSorted();
		}
		for(int i=0;i<noOfElements;i++){
			System.out.println("Enter element "+i);
			userInputList.add(takeIntegerInput());
		}
		return userInputList;
	}
	
	/**
	 * @method sortUserInput()
	 * method for taking user input and sorting the input by calling sorting input
	 * */
	public void sortUserInput(){
		List<Integer> userInputList=takeUserInputForListToBeSorted();
		SortingSystem sortingSystemObject=new SortingSystem();
		System.out.println(sortingSystemObject.showMenuAndCallSortingMethods(userInputList));
		
	}
	
}
