package com.metacube.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import myutils.FileOperations;

import com.metacube.entity.College;


public class CollegeDao {
	private Map<String,College> colleges;  
	private List<College> listOfColleges; 
	private static CollegeDao collegeDaoObject;
	
	private CollegeDao(){
		listOfColleges=new ArrayList<College>();
		colleges=new HashMap<String, College>();
		initializeListOfStudents();
		initializeCollegeHashMap();
	}
	
	public Map<String, College> getColleges() {
		return colleges;
	}

	public void setColleges(Map<String, College> colleges) {
		this.colleges = colleges;
	}

	public static CollegeDao getInstance(){
		if(collegeDaoObject==null){
			synchronized (CollegeDao.class) {
				if(collegeDaoObject==null)
				{
					collegeDaoObject=new CollegeDao();
				}
				
			}
		}
		return collegeDaoObject;
	}
	
	public List<College> getListOfColleges() {
		return listOfColleges;
	}

	public void setListOfColleges(List<College> listOfColleges) {
		this.listOfColleges = listOfColleges;
	}

	public void initializeListOfStudents(){
		FileOperations fileOperationObject=new FileOperations();
		List<String> listOfCollegeObjects=fileOperationObject.readFile("CollegesDetails.txt");
		Iterator<String> itr=listOfCollegeObjects.iterator();
		while(itr.hasNext()){
			String[] studentDetails=itr.next().split("\\,");
			College collegeObject=new College(studentDetails[0], studentDetails[1],Integer.parseInt(studentDetails[2]), Integer.parseInt(studentDetails[3]));
			listOfColleges.add(collegeObject);
		}
		
	}
	
	public void initializeCollegeHashMap(){
		FileOperations fileOperationObject=new FileOperations();
		List<String> listOfCollegeObjects=fileOperationObject.readFile("CollegesDetails.txt");
		Iterator<String> itr=listOfCollegeObjects.iterator();
		while(itr.hasNext()){
			String[] studentDetails=itr.next().split("\\,");
			College collegeObject=new College(studentDetails[0], studentDetails[1],Integer.parseInt(studentDetails[2]), Integer.parseInt(studentDetails[3]));
			colleges.put(studentDetails[0], collegeObject);
		//	listOfColleges.add(collegeObject);
		}
		
	}
	
	public static void main(String[] args) {
		CollegeDao collegeDaoObject=CollegeDao.getInstance();
		List<College> listOfColleges=collegeDaoObject.getListOfColleges();
		Iterator<College> itr=listOfColleges.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next().toString());
		}
		
		System.out.println("Empty");
		//Set set=collegeDaoObject.colleges.values();
		listOfColleges=new ArrayList<College>(collegeDaoObject.colleges.values());
		Iterator<College> iter=listOfColleges.iterator();
		while(iter.hasNext()){
			College c=iter.next();
			System.out.println(c.toString());
			System.out.println();
		}
	}
	
}
