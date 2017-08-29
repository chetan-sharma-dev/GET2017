package com.metacube.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import myutils.FileOperations;
import com.metacube.entity.Student;

public class StudentDao {
	private List<Student> listOfAllStudents; 
	private static StudentDao studentDaoObject;
	
	private StudentDao(){
		listOfAllStudents=new ArrayList<Student>();
		initializeListOfStudents();
	}
	
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

	public List<Student> getListOfAllStudents() {
		return listOfAllStudents;
	}

	public void add(Student element) {
		this.listOfAllStudents.add(element);
	}
	
	public void remove(Student element) {
		this.listOfAllStudents.remove(element);
	}
	public static void main(String[] args) {
		StudentDao studentDaoObject=StudentDao.getInstance();
		List<Student> listOfStudents=studentDaoObject.getListOfAllStudents();
		Iterator<Student> itr=listOfStudents.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next().toString());
		}
	}
}
