package com.metacube.entity;

public class Student implements Comparable{

	private String name ;
	private int rollNo;
	private String Address;
	
	@Override
	public int compareTo(Object o) {
		Student anotherStudentObject=(Student)o;
		return this.getRollNo()-anotherStudentObject.getRollNo();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	
}
