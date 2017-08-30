package com.metacube.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myutils.FileOperations;
import com.metacube.entity.Student;
/**
 * @class 
 * class holding all student lists
 * */
public class StudentDao {
	private List<Student> listOfAllStudents; 
	private static StudentDao studentDaoObject;
	/**
	 * @constructor
	 * initializing all data members
	 * */
	private StudentDao(){
		listOfAllStudents=new ArrayList<Student>();
		initializeListOfStudents();
	}
	/**
	 * @method  getInstance()
	 * method returning studentDao Object
	 * */
	public static StudentDao getInstance(){
		if(studentDaoObject==null){
			synchronized (CollegeDao.class) {
				if(studentDaoObject==null)
				{
					studentDaoObject=new StudentDao();
				}
				
			}
		}
		return studentDaoObject;
	}
	
	/**
	 * @method initializeListOfStudents()
	 * method for reading from file and initializing list of students
	 * */
	public void initializeListOfStudents(){
		FileOperations fileOperationObject=new FileOperations();
		List<String> listOfStudentObjects=fileOperationObject.readFile("StudentDetails.txt");
		Iterator<String> itr=listOfStudentObjects.iterator();
		while(itr.hasNext()){
			String[] studentDetails=itr.next().split("\\,");
			Student studentObject=new Student(studentDetails[0], studentDetails[1],Integer.parseInt(studentDetails[2]));
			listOfAllStudents.add(studentObject);
			
		}
	}

	/**
	 * getter and setter methods 
	 * */
	public List<Student> getListOfAllStudents() {
		return listOfAllStudents;
	}

	public void add(Student element) {
		this.listOfAllStudents.add(element);
	}
	
	public void remove(Student element) {
		this.listOfAllStudents.remove(element);
	}
	
}
