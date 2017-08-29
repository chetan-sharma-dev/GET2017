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

public class Controller {
	private List<Student> listOfStudentObjects;
	private List<Student> listOfUnallottedStudentObjects;
	private Map<String,College> mapOfCollegeObjects;
	private Scanner scanInput;
	private MyQueue<Student> queueOfStudentsFromRank;
	
	public Controller(){
		StudentDao studentDaoObject=StudentDao.getInstance();
		listOfStudentObjects = studentDaoObject.getListOfAllStudents();
		listOfUnallottedStudentObjects = studentDaoObject.getListOfAllStudents();
		Collections.sort(listOfStudentObjects);
		CollegeDao collegeDaoObject=CollegeDao.getInstance();
		mapOfCollegeObjects =collegeDaoObject.getColleges();
		scanInput=new Scanner(System.in);
		queueOfStudentsFromRank=new MyQueue<Student>();
	}

	private int takeInput(){
		try{
			Scanner scanInput=new Scanner(System.in);
			return scanInput.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Invalid integer input"+e);
			return takeInput();
		}
	}
	
	public void initializeQueueOfStudentAccordingToRank(){
		Collections.sort(listOfUnallottedStudentObjects);
		Iterator<Student> itr=listOfUnallottedStudentObjects.iterator();
		while(itr.hasNext()){
			queueOfStudentsFromRank.enqueue(itr.next());
		}
	}
	
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
	
	public void startCounselling(){
		
		System.out.println("Enter no of counsellings to be done");
		int noOfCounselling=takeInput();
		
		for(int i=0;i<noOfCounselling;i++){
			System.out.println("###########################################################################");
			System.out.println("Counselling no "+(i+1));
			System.out.println("###########################################################################");
			printCollegesList();
			Iterator<Student> itr=listOfUnallottedStudentObjects.iterator();
			while(itr.hasNext()){
				Student studentObject=itr.next();
				System.out.println("Mr. "+studentObject.getName()+", Enter your college choices :- ");
				studentObject.setFilledCoices(takeUserChoices());
			}
			
			initializeQueueOfStudentAccordingToRank();
			int queueSize=queueOfStudentsFromRank.size();
			for(int j=0;j<queueSize;j++){
				Student studentObject=queueOfStudentsFromRank.dequeue();
				allocateAvailableCollegeSeat(studentObject);
			}
			printAllotmentList();
	System.out.println("###########################################################################");
			
		}
		System.out.println(noOfCounselling);
		
		
	}
	
	public void allocateAvailableCollegeSeat(Student studentObject){
		List<String> choosenCollegeList=studentObject.getFilledCoices();
		Iterator<String> itr=choosenCollegeList.iterator();
		boolean isSeatAllocated=false;
		while(itr.hasNext()&&!isSeatAllocated){
			String collegeId=itr.next();
			int availableSeat=mapOfCollegeObjects.get(collegeId).getAvailableSeats();
			if(availableSeat>0){
				studentObject.setAllotedCollege(mapOfCollegeObjects.get(collegeId));
				mapOfCollegeObjects.get(collegeId).setAvailableSeats(availableSeat-1);
				listOfUnallottedStudentObjects.remove(studentObject);
				isSeatAllocated=true;
			}
		}
		
	}
	
	public void printAllotmentList(){
		Iterator<Student> itr=listOfStudentObjects.iterator();
		System.out.println("---------------------------------------------------------------------------------------------------");
		System.out.println("Student ID \t Student Name \t Student Rank \t Student filled Choices \t Alloted College");
		System.out.println("---------------------------------------------------------------------------------------------------");
		while(itr.hasNext()){
			System.out.println(itr.next().toString());
		}
		System.out.println("---------------------------------------------------------------------------------------------------");

	}
	public List<String> takeUserChoices(){
		List<String> userCollegeChoicesInput=new ArrayList<String>();
		System.out.println("Enter Your College Choices in accending priority order seperating with '/' :  ");
		String userChoiceInputString=scanInput.nextLine();
		userCollegeChoicesInput=Arrays.asList(userChoiceInputString.split("\\/"));
		
		if(userCollegeChoicesInput.size()>mapOfCollegeObjects.size()){
			System.out.println("Invalid Colleges choices filled...Please Enter valid choices");
			return takeUserChoices();
		}
		
		Iterator<String> itr=userCollegeChoicesInput.iterator();
		while(itr.hasNext()){
			if(!mapOfCollegeObjects.containsKey(itr.next())){
				System.out.println("Invaid College Id Entered!!!.. Please Enter valid choices");
				return takeUserChoices();
			}
		}
		
		Set<String> userChoicesSet=new HashSet<String>(userCollegeChoicesInput);
		if(userChoicesSet.size()<userCollegeChoicesInput.size())
		{	
			System.out.println("Duplicate College ID's Entered!!.... Please Enter valid choices");
			return takeUserChoices();
		}
		return userCollegeChoicesInput;
	}
	
	public static void main(String[] args) {
		Controller controllerObject=new Controller();
		controllerObject.startCounselling();
		//controllerObject.printCollegesList();
	}
}
