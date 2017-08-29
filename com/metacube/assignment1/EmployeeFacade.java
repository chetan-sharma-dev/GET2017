package com.metacube.assignment1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class EmployeeFacade {
	List<Employee> listOfEmployees;
	
	public EmployeeFacade() {
		listOfEmployees=new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee employeeObject){
		listOfEmployees.add(employeeObject);
	}

	public static void main(String[] args) {
		EmployeeFacade employeeFacadeObject=new EmployeeFacade();
		Employee employeeObject=new Employee("E1", "Chetan", "Sikar");
		employeeFacadeObject.addEmployee(employeeObject);
		employeeObject=new Employee("E3", "Ankur", "Jaipur");
		employeeFacadeObject.addEmployee(employeeObject);
		employeeObject=new Employee("E2", "Amit", "Ajmer");
		employeeFacadeObject.addEmployee(employeeObject);
		System.out.println(employeeFacadeObject.listOfEmployees.toString());
		
		Collections.sort(employeeFacadeObject.listOfEmployees,new IdComparator());
		System.out.println(employeeFacadeObject.listOfEmployees.toString());
		Collections.sort(employeeFacadeObject.listOfEmployees,new NameComparator());
		System.out.println(employeeFacadeObject.listOfEmployees.toString());
		Collections.sort(employeeFacadeObject.listOfEmployees,new AddressComparator());
		System.out.println(employeeFacadeObject.listOfEmployees.toString());
		
	}

}
