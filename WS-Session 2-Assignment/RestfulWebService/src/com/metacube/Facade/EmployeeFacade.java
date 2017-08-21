package com.metacube.Facade;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.metacube.DAO.BaseDao;
import com.metacube.DAO.DAOFactory;
import com.metacube.entity.Employee;
import com.metacube.enums.DBType;
import com.metacube.enums.Status;
import com.metacube.io.WriteToFile;



/**
 * @Class EmployeeFacade.
 */
public class EmployeeFacade{

	/** The employee map. binds the object of employee class to Employee id*/
	private Map<String,Employee> employeeMap ;

	/** The employee. object of Employee class */
	private Employee employeeObject;

	/** The employee details. contains the list of all products */
	private List<Employee> employeeDetails;


	/** The pf.  reference of EmployeeFacade*/
	private static EmployeeFacade pf;



	/**
	 * Instantiates a new employee facade.
	 */
	private EmployeeFacade() {
		employeeMap = new HashMap<>();	
		employeeDetails=getAllEmployee();
	}

	/**
	 * Gets the single instance of EmployeeFacade.
	 *
	 * @return single instance of EmployeeFacade
	 */
	public static EmployeeFacade getInstance(){
		/**Double locking mechanism to make a singleton object**/
		if(pf==null){
			synchronized(EmployeeFacade.class){
				if(pf==null){
					pf = new EmployeeFacade();
				}
			}
		}
		return pf;
	}

	/**
	 * Gets the all employee.
	 *
	 */
	public List<Employee> getAllEmployee() throws IllegalArgumentException{
		/**Make a DAO object**/
		BaseDao baseDaoObject = DAOFactory.getInstance(DBType.FileDao);
		/**call the get products method specified in DAO**/
		employeeDetails = baseDaoObject.getAllEmployee();
		/*Status result;
		
		if(employeeDetails.size()==0){
			result = Status.Error_Occured;
		}*/
		/**Iterator to iterate the employee list**/
		if(employeeDetails.size()!=0)
		{
			Iterator<Employee> itr = employeeDetails.iterator();
			while(itr.hasNext()){
				employeeObject = itr.next();
				employeeMap.put(employeeObject.getId(),employeeObject);
			}
			
		}

		return employeeDetails;
	}

	/*
	 *This method is used to print the Employees information
	 *
	 *@return String array containing all the products
	 */
	public List<String> getEmployeeString(){
		/**Iterator to iterate the employee list**/
		//String sar[] = new String[employeeDetails.size()+1];
		List<String> listOfEmployees=new ArrayList<String>();
		//int index = 1;
		Iterator<Employee> itr = employeeDetails.iterator();
		listOfEmployees.add("Employee Id \t Employee Name \t Employee Age");
		//sar[0] = "Employee Id\tEmployee Name\tEmployee Age";
		while(itr.hasNext()){
			employeeObject = itr.next();
			listOfEmployees.add(employeeObject.toString());
			//sar[index] = employee.toString();
			//index++;
		}
		return listOfEmployees;
	}
	/**
	 * Searchproduct.
	 *
	 *This method search employee by using it's Id
	 * @param id the id
	 * @return Found if successful else NOT_Found
	 */
	public Employee searchEmployee(String id) {
		BaseDao dao =  DAOFactory.getInstance(DBType.FileDao);
		employeeObject = (Employee)dao.searchEmployee(id);
		return employeeObject;

	}

	/**
	 * This function writes  into the file
	 * @param emp the employee id
	 */
	public void writeFile(Employee emp){
		WriteToFile.writeFile(emp);
	}

	/**
	 * This function writes  into the file
	 * @param employeeMap the map containing the employee object
	 */
	public void writeFile(Map<String,Employee> employeeMap){
		WriteToFile.writeFile(employeeMap);
	}
	/*
	 * This Method Add the employee in Employee File
	 * @param emp object of employee class
	 * @return Status return the status of operation
	 */
	public Status addEmployee(Employee emp){
		Status answer;
		if(employeeMap.containsKey(emp.getId())){
			answer = Status.Duplicate;
		}
		else{
			employeeMap.put(emp.getId(),emp);
			employeeDetails.add(emp);
			writeFile(emp);
			answer = Status.Success;
		}
		return answer;
	}
	/**
	 * This Method Delete the employee from Employee File
	 * @param id of employee 
	 * @return Status return the status of operation
	 */
	public Status deleteEmployee(String id){
		Status answer;
		id = id.trim();
		if(employeeMap.containsKey(id)){
			employeeDetails.remove(employeeMap.get(id));
			employeeMap.remove(id);
			System.out.println(employeeMap.toString());
			writeFile(employeeMap);
			answer = Status.Success;
		}else{
			answer = Status.NOT_Found;
		}
		return answer;
	}

}
