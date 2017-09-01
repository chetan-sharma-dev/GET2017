package com.metacube.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.metacube.dao.CollegeDao;
import com.metacube.dao.StudentDao;
import com.metacube.entity.College;
import com.metacube.entity.Student;
import com.metacube.queue.MyQueue;
/**
 * @class 
 * class for handling operations of Counseling 
 * */
public class Controller {
	private List<Student> listOfStudentObjects;
	private List<Student> listOfUnallottedStudentObjects;
	private Map<String,College> mapOfCollegeObjects;
	private Scanner scanInput;
	private MyQueue<Student> queueOfStudentsFromRank;
	
	/**
	 * @constructor 
	 * initializing all data members
	 * */
	@SuppressWarnings("unchecked")
	public Controller(){
		StudentDao studentDaoObject=StudentDao.getInstance();
		listOfStudentObjects=studentDaoObject.getListOfAllStudents();
		listOfUnallottedStudentObjects=getAnotherStudentListWithDifferentReference(studentDaoObject.getListOfAllStudents());
		Collections.sort(listOfStudentObjects);
		Collections.sort(listOfUnallottedStudentObjects);
		CollegeDao collegeDaoObject=CollegeDao.getInstance();
		mapOfCollegeObjects =collegeDaoObject.getColleges();
		scanInput=new Scanner(System.in);
		queueOfStudentsFromRank=new MyQueue<Student>();
	}

	/**
	 * @method getAnotherStudentListWithDifferentReference()
	 * method return different reference list for student type
	 * */
	public List<Student> getAnotherStudentListWithDifferentReference(List<Student> list){
		Iterator<Student> itr=list.iterator();
		List<Student> tempList=new ArrayList<Student>();
		while(itr.hasNext()){
			tempList.add(itr.next());
		}
		return tempList;
	}

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
	 * @method initializeQueueOfStudentAccordingToRank()
	 * method for initializing queue of students from sorted list of student Objects
	 * */
	public void initializeQueueOfStudentAccordingToRank(){
		Collections.sort(listOfUnallottedStudentObjects);
		Iterator<Student> itr=listOfUnallottedStudentObjects.iterator();
		while(itr.hasNext()){
			queueOfStudentsFromRank.enqueue(itr.next());
		}
	}
	
	/**
	 * @method printCollegesList()
	 * method for printing CollegeList by iterating College List 
	 * */
	public void printCollegesList(){
		Iterator<College> itr=mapOfCollegeObjects.values().iterator();
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("College ID \t College Name \t College Rank \t Available seats \t TotalSeats ");
		System.out.println("-----------------------------------------------------------------------------------------");
		while(itr.hasNext()){
			System.out.println(itr.next().toString());
		}
		System.out.println("-----------------------------------------------------------------------------------------");

	}
	
	/**
	 * @method startCounseling
	 * method for initiating counseling 
	 * */
	public void startCounseling(){
		/*
		 * taking input for no of counseling to be done
		 * */
		System.out.println("Enter no of counselings to be done");
		int noOfcounseling=takeIntegerInput();
		
		/*
		 * doing Counseling 
		 * */
		for(int i=0;i<noOfcounseling;i++){
			System.out.println("#############################################################################################");
			System.out.println("counseling no "+(i+1));
			System.out.println("#############################################################################################");
			//printing college list 
			printCollegesList();
			/*
			 * choice filling done for each student
			 * */
			Iterator<Student> itr=listOfStudentObjects.iterator();
			while(itr.hasNext()){
				Student studentObject=itr.next();
				System.out.println("Mr. "+studentObject.getName()+", Enter your college choices :- ");
				studentObject.setFilledCoices(takeUserChoices());
			}
			/*
			 * initializing queue according to rank
			 * */
			initializeQueueOfStudentAccordingToRank();
			/*
			 * dequeue the queue of students and calling method for allocation of college
			 * */
			int queueSize=queueOfStudentsFromRank.size();
			for(int j=0;j<queueSize;j++){
				Student studentObject=queueOfStudentsFromRank.dequeue();
				allocateAvailableCollegeSeat(studentObject);
			}
			/*
			 * printing unallotted students list
			 * */
			printUnallotedStudentList();
	System.out.println("###########################################################################");
	
		}
		printAllAllotedStudentList();
	}

	/**
	 * @method allocateAvailableCollegeSeat()
	 * method allocating college to given student if seat available
	 * */	
	public void allocateAvailableCollegeSeat(Student studentObject){
		/*
		 * getting student choice options list and 
		 * iterating list of colleges from their ids ,checking whether seat available or not
		 * if seat available then assigning seat in that college
		 */
		List<String> choosenCollegeList=studentObject.getFilledCoices();
		Iterator<String> itr=choosenCollegeList.iterator();
		boolean isSeatAllocated=false;
		while(itr.hasNext()&&!isSeatAllocated){
			String collegeId=itr.next();
			int availableSeat=mapOfCollegeObjects.get(collegeId).getAvailableSeats();
			if(availableSeat>0){
				/*
				 * if seat available then doing entry of college Object in studentObject
				 * and removing entry of that student from listOfStudentObjects
				 * and assigning isSeatAllocated flag as true
				 * */
				studentObject.setAllotedCollege(mapOfCollegeObjects.get(collegeId));
				mapOfCollegeObjects.get(collegeId).setAvailableSeats(availableSeat-1);
				listOfUnallottedStudentObjects.remove(studentObject);
				isSeatAllocated=true;
			}
		}
		
	}
	
	/**
	 * @method takeUserChoices()
	 * method for taking Student choice filling for colleges in decreasing priority order
	 * */
	public List<String> takeUserChoices(){
		List<String> userCollegeChoicesInput=new ArrayList<String>();
		System.out.println("Enter Your College Choices in Decending priority order seperating with '/' :  ");
		String userChoiceInputString=scanInput.nextLine();
		userCollegeChoicesInput=Arrays.asList(userChoiceInputString.split("\\/"));
		/*
		 * checking whether user entered more than the available options
		 * */
		if(userCollegeChoicesInput.size()>mapOfCollegeObjects.size()){
			System.out.println("Invalid Colleges choices filled...Please Enter valid choices");
			return takeUserChoices();
		}
		/*
		 * iterating list of choices entered by user and validating them from available college options
		 * */
		Iterator<String> itr=userCollegeChoicesInput.iterator();
		while(itr.hasNext()){
			if(!mapOfCollegeObjects.containsKey(itr.next())){
				System.out.println("Invaid College Id Entered!!!.. Please Enter valid choices");
				return takeUserChoices();
			}
		}
		
		/*
		 * checking for duplicate entries
		 * */
		Set<String> userChoicesSet=new HashSet<String>(userCollegeChoicesInput);
		if(userChoicesSet.size()<userCollegeChoicesInput.size())
		{	
			System.out.println("Duplicate College ID's Entered!!.... Please Enter valid choices");
			return takeUserChoices();
		}
		return userCollegeChoicesInput;
	}

	/**
	 * @method printUnallotedStudentList()
	 * method for printing list of unallotted student list 
	 * */
	public void printUnallotedStudentList(){
		Iterator<Student> itr=listOfUnallottedStudentObjects.iterator();
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("Student ID \t Student Name \t Student Rank \t Student filled Choices \t Alloted College");
		System.out.println("---------------------------------------------------------------------------------------------------");
		/*
		 * checking whether there is student with no college alloted
		 * */
		if(!itr.hasNext()){
			System.out.println("No Student left for allotment");
		}
		while(itr.hasNext()){
			System.out.println(itr.next().toString());
		}
		System.out.println("---------------------------------------------------------------------------------------------------");

	}

	/**
	 * @method printAllAllotedStudentList()
	 * method print list of all allotted student list 
	 * */
	public void printAllAllotedStudentList(){
		StudentDao studentDaoObject=StudentDao.getInstance();
		List<Student> listOfStudentObjects = studentDaoObject.getListOfAllStudents();
		Iterator<Student> itr=listOfStudentObjects.iterator();
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t List OF All Students with Allotted College  ");
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("Student ID \t Student Name \t Student Rank \t Student filled Choices \t Alloted College");
		System.out.println("---------------------------------------------------------------------------------------------------");		
		while(itr.hasNext()){
			Student studentObject=itr.next();
			if(studentObject.getAllotedCollege()!=null)
				System.out.println(studentObject.toString());
		}
		System.out.println("---------------------------------------------------------------------------------------------------");
	}
	
	
}
