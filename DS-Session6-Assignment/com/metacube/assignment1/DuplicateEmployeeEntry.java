package com.metacube.assignment1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class DuplicateEmployeeEntry {
	List<Employee> listOfEmployees;
	
	public DuplicateEmployeeEntry() {
		listOfEmployees=new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee employeeObject){
		if(!checkForDuplicateEntry(employeeObject))
			{
				listOfEmployees.add(employeeObject);
			}else{
				System.out.println("Duplicate Entries Done");
			}
	}
	public boolean checkForDuplicateEntry(Employee employeeObject){
		Iterator<Employee> itr=listOfEmployees.iterator();
		while(itr.hasNext()){
			if(itr.next().compareTo(employeeObject)==0){
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		DuplicateEmployeeEntry duplicateFacadeObject=new DuplicateEmployeeEntry();
		Employee employeeObject=new Employee("E1", "Chetan", "Sikar");
		duplicateFacadeObject.addEmployee(employeeObject);
		employeeObject=new Employee("E3", "Ankur", "Jaipur");
		duplicateFacadeObject.addEmployee(employeeObject);
		employeeObject=new Employee("E1", "Amit", "Ajmer");
		duplicateFacadeObject.addEmployee(employeeObject);
	}
	
}
