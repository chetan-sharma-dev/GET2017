package com.metacube.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import myutils.FileOperations;

import com.metacube.entity.College;

/**
 * @class
 * class for holding all college objects withIds 
 * */
public class CollegeDao {
	private Map<String,College> colleges;  
	private static CollegeDao collegeDaoObject;
	/**
	 * @constructor 
	 * initializing all data members
	 * */	
	private CollegeDao(){
		colleges=new HashMap<String, College>();
		initializeCollegeHashMap();
	}
	
	public Map<String, College> getColleges() {
		return colleges;
	}

	public void setColleges(Map<String, College> colleges) {
		this.colleges = colleges;
	}

	/**
	 * method return instance of College Dao (Singleton class)
	 * */
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
	
	/**
	 * @method studentDetails()
	 * method initializing CollegeHashMap 
	 * reading from file and initializing Map entries
	 * */
	public void initializeCollegeHashMap(){
		FileOperations fileOperationObject=new FileOperations();
		List<String> listOfCollegeObjects=fileOperationObject.readFile("CollegesDetails.txt");
		Iterator<String> itr=listOfCollegeObjects.iterator();
		while(itr.hasNext()){
			String[] collegeDetails=itr.next().split("\\,");
			College collegeObject=new College(collegeDetails[0], collegeDetails[1],Integer.parseInt(collegeDetails[2]), Integer.parseInt(collegeDetails[3]));
			colleges.put(collegeDetails[0], collegeObject);
		}
		
	}
	
	
	
}
