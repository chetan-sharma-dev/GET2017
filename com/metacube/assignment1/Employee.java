package com.metacube.assignment1;

public class Employee implements Comparable{
	private String employeeId;
	private String employeeName;
	private String address;
	
	public Employee(String employeeId,String employeeName,String address) {
		this.employeeId=employeeId;
		this.employeeName=employeeName;
		this.address=address;
	}
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString(){
		return "\nEmployee Id : "+employeeId+"\n"
				+ "Employee Name : "+employeeName+"\n"
						+ "Employee Address : "+address+"\n";
	}
	@Override
	public int compareTo(Object o) {
		Employee employeeObject=(Employee)o;
			return this.getEmployeeId().compareTo(employeeObject.getEmployeeId());
	}
	
}
