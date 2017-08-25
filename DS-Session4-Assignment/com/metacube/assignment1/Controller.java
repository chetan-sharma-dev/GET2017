package com.metacube.assignment1;
import java.util.Scanner;


public class Controller {
		Scanner scanInput=new Scanner(System.in);
		private PrintingJobPool printerObject;

		public Controller() {
			printerObject=new PrintingJobPool();
		}
	public void takeUserTypeAndRequestPrinting(){
	
		System.out.println("Select Your Designation \n"
				+ "1.Under Graduate \n"
				+ "2.Graduate \n"
				+ "3.Professor \n"
				+ "4.Department Chair");
		int requesterChoiceInput=scanInput.nextInt();
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
	
	public void printMenu()
	{
		System.out.println("Select Operation you want to do\n"
				+ "1. Request Print \n"
				+ "2. Print All Jobs \n"
				+ "3. Exit");
			int requesterChoiceInput=scanInput.nextInt();
			switch(requesterChoiceInput)
			{
				case 1:takeUserTypeAndRequestPrinting(); break;
				case 2:printAllJobs(); break;
				case 3:return;
				default:System.out.println("wrong input");
			}
		printMenu();
	}
	
	public void printAllJobs(){
		printerObject.printAllJobs();
	}
	
	public static void main(String[] args) {
		Controller controllerObject=new Controller();
		controllerObject.printMenu();
	}
}
