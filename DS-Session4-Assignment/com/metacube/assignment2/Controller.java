package com.metacube.assignment2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
	GuestHouse guestHouseObject;
	/**
	 * @constructor 
	 * initializing GuestHouse variable
	 * */
	public Controller() {
		guestHouseObject=new GuestHouse("Sharma Guest House", 5);
	}
	/**
	 * @method takeIntegerInput()
	 * method to takeIntegerInput 
	 * */
	private int takeIntegerInput(){
		Scanner scanInput=new Scanner(System.in); 
		try{
			return scanInput.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Invalid Integer Input given "+e);
			return takeIntegerInput();
		}
		
	}
	
	/**
	 * @method takeStringInput()
	 * method for taking String Input along with null check
	 * */
	private String takeStringInput(){
		Scanner scanInput =new Scanner(System.in);
		String userInput=scanInput.nextLine();
		if(userInput!=null){
			return userInput;
		}else
		{
			return takeStringInput();
		}
	}
	/**
	 * @method takeValidAgeInputFormUser()
	 * method for taking valid age in given range 
	 * */
	private int takeValidAgeInputFormUser(){
		int userAge=takeIntegerInput();
		if(userAge>0&&userAge<=100){
			return userAge;
		}else{
			System.out.println("Invalid User Age Entered");
			return takeValidAgeInputFormUser();
		}
	} 
	
	/**
	 * @method  takeBookingInputAndBookRoom()
	 * method to take user Input for booking 
	 * */
	private String takeBookingInputAndBookRoom(){
		
		System.out.println("Enter Name :- ");
		String nameOfCoustmer=takeStringInput();
		System.out.println("Enter Address Place :-");
		String placeName=takeStringInput();
		System.out.println("Enter Age(age limit is 1 to 100 only):-");	
		int coustmerAge=takeValidAgeInputFormUser();
		
		Address coustmerAddress=new Address();
		coustmerAddress.setPlaceName(placeName);
		Customer coustmerObject=new Customer(nameOfCoustmer, coustmerAge, coustmerAddress);
		
		return guestHouseObject.allocateRoom(coustmerObject);		
		
	}
	
	/**
	 * @method takeUserInputForCheckOutAndDoCheckOut()
	 * method for taking roomNo as input , after validation doing checkout
	 * */
	private String takeUserInputForCheckOutAndDoCheckOut(){
		System.out.println("Enter Room No to check out : - ");
		int roomNoToCheckOut=takeIntegerInput();
		return guestHouseObject.checkOutFromGuestHouse(roomNoToCheckOut);	
	}
	
	/**
	 * @method showMenuAndCallMethod()
	 * method for showing menu to Customer 
	 * taking user input by calling appropriate method
	 * */
	public  void showMenuAndCallMethod(){
		
		System.out.println("Enter Your Choice\n"
				+ "1. Book Room \n"
				+ "2. Checkout \n"
				+ "3. Get All Booked Room Details \n"
				+ "4. Exit");
		int coustmerChoice=takeIntegerInput();
		switch(coustmerChoice){
			case 1: System.out.println("Booking room");
				takeBookingInputAndBookRoom();
				break;
			case 2:System.out.println("Checking out");
				System.out.println(takeUserInputForCheckOutAndDoCheckOut());
				break;
			case 3:
				System.out.println(guestHouseObject.getAllBookedRoomsDetails());
				break;
			case 4:return;
			default: System.out.println("Invalid Choice : Please choose right option");
		}
		showMenuAndCallMethod();
		
	}
	

	
}
