package com.metacube.assignment1;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @class Controller
 * */
public class Controller {
	/*
	 * creating scanner and PrintingJobPool common object 
	 * */
		Scanner scanInput=new Scanner(System.in);
		private PrintingJobPool printerObject;

	/**
	 * @Constructor Controller()
	 * constructor initializing objects; 
	 * */
		public Controller() {
			printerObject=new PrintingJobPool();
		}
		
		public int takeIntegerUserinput(){
			try{
				scanInput=new Scanner(System.in);
				return scanInput.nextInt();
			}catch(InputMismatchException e){
				System.out.println("Invalid input");
				return takeIntegerUserinput();
			}
		}
	/**
	 * @method takeUserTypeAndRequestPrinting()
	 * method for showing menu and taking user input
	 * */
	public void takeUserTypeAndRequestPrinting(){
	
		System.out.println("Select Your Designation \n"
				+ "1.Under Graduate \n"
				+ "2.Graduate \n"
				+ "3.Professor \n"
				+ "4.Department Chair");
		int requesterChoiceInput=takeIntegerUserinput();
		 scanInput.nextLine();
		String requesterDocumentData ="";
			if(requesterChoiceInput>=1&&requesterChoiceInput<=4)
			{	
				System.out.println("Enter Your Document data to print : - ");
				requesterDocumentData = scanInput.nextLine();
				printerObject.requestPrint(requesterDocumentData, requesterChoiceInput);
				return;
			}else{
				System.out.println("Invalid User Input");
				takeUserTypeAndRequestPrinting();
			}
			
	}
	
	/**
	 * @method printMenu()
	 * method printing Menu 
	 * */
	public void printMenu()
	{
		System.out.println("Select Operation you want to do\n"
				+ "1. Request Print \n"
				+ "2. Print All Jobs \n"
				+ "3. Exit");
			int requesterChoiceInput=takeIntegerUserinput();
			switch(requesterChoiceInput)
			{
				case 1:takeUserTypeAndRequestPrinting(); break;
				case 2:printAllJobs(); break;
				case 3:return;
				default:System.out.println("wrong input");
			}
		printMenu();
	}
	
	/**
	 * @method printAllJobs()
	 * method for printing all jobs
	 * */
	public void printAllJobs(){
		List<String> dataToPrint=printerObject.getPrintOfAllJobs();
		Iterator<String> itr=dataToPrint.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		
	}
	
	
	public static void main(String[] args) {
		Controller controllerObject=new Controller();
		controllerObject.printMenu();
	}
}
