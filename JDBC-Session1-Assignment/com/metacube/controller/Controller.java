package com.metacube.controller;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.metacube.dao.MysqlDao;
import com.metacube.dbpojos.Titles;

/**
 * @class
 * controller class for getting data from database
 * */
public class Controller {

	private  MysqlDao daoObject=new MysqlDao();
	public Controller() {
		daoObject=new MysqlDao();
	}
	/**
	 * @method takeIntegerInput()
	 * method to takeIntegerInput 
	 * */
	public int takeIntegerInput(){
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
	public String takeStringInput(){
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
	 * @method showMenuTakeInputAndCallMethods()
	 * method showing menu and accordingly calling methods of DAO
	 * */
	public void showMenuTakeInputAndCallMethods(){
		System.out.println("Enter Your Choice\n"
				+ "1. Fetch all the books titles , published by author \n"
				+ "2. Get Book issue Status \n"
				+ "3. Delete all those books which were not issued in last 1 year. \n"
				+ "4. exit");
		int userChoice=takeIntegerInput();
		switch(userChoice){
		case 1:
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("Enter Author name :-");
			String authorName=takeStringInput();
			List<Titles> listOfBooksTitles=daoObject.getBooksTitlesPublishedByGivenAuthor(authorName);
			System.out.println("------------------------------------------------------------------------------------");
			printListOfBooksTitles(listOfBooksTitles, authorName);
			System.out.println("------------------------------------------------------------------------------------");
			break;
		case 2:
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println("Enter Book Name to get availability :-");
			String bookName=takeStringInput();
			System.out.println("------------------------------------------------------------------------------------");
			System.out.println(daoObject.getBookAvailabilityStatus(bookName));
			System.out.println("------------------------------------------------------------------------------------");
			break;
		case 3:
			System.out.println("------------------------------------------------------------------------------------");
			int noOfRecordsDeleted=daoObject.deleteDataFromBooksTableNotIssuedInLastOneYear();
			if(noOfRecordsDeleted>0){
				System.out.println("No of records deleted = "+noOfRecordsDeleted);
			}else if(noOfRecordsDeleted==0){
				System.out.println("No Book record found which is not issued in last one year");
			}
			System.out.println("------------------------------------------------------------------------------------");
			break;
		case 4: 
			return;
		default:
			System.out.println("Invalid choice entered");
		
		}
		showMenuTakeInputAndCallMethods();
	}
	
	/**
	 * @method printListOfBooksTitles()
	 * method to print list of book titles with description
	 * */
	public void printListOfBooksTitles(List<Titles> listOfBooksTitles,String authorName){
	
		if(listOfBooksTitles.size()>0){
			Iterator<Titles> itr=listOfBooksTitles.iterator();
			System.out.println("TitleId\t\t titleName\t\t SubjectId\t\t PublisherId");
			System.out.println("------------------------------------------------------------------------------------");
			while(itr.hasNext()){
				System.out.println(itr.next().toString());
			}
		}else{
			System.out.println("No Book issued By Mr. "+authorName);
		}
	}
	
}
