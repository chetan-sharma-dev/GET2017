package com.metacube.assignment2;
/**
 * @class Customer 
 * this class has all customer details 
 * */
public class Customer {
	private String customerId;
	private String customerName;
	private int customerAge;
	private Address customerAddress;
	private int allocatedRoomTocustomer;
	
	/**
	 * all Getter and Setter methods for private members
	 * */
	public String getcustomerId() {
		return customerId;
	}

	public void setcustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Customer() {
		this.customerName=null;
		this.customerAge=0;
		this.customerAddress=null;
		this.allocatedRoomTocustomer=0;
		this.customerId=null;
	}
	
	public Customer(String name,int age,Address customerAddress) {
		this.customerId=null;
		this.customerName=name;
		this.customerAge=age;
		this.customerAddress=customerAddress;
		this.allocatedRoomTocustomer=0;
	}
	
	public String getcustomerName() {
		return customerName;
	}

	public void setcustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getcustomerAge() {
		return customerAge;
	}

	public void setcustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public Address getcustomerAddress() {
		return customerAddress;
	}

	public void setcustomerAddress(Address customerAddress) {
		this.customerAddress = customerAddress;
	}

	public int getAllocatedRoomTocustomer() {
		return allocatedRoomTocustomer;
	}

	public void setAllocatedRoomTocustomer(int allocatedRoomTocustomer) {
		this.allocatedRoomTocustomer = allocatedRoomTocustomer;
	}

	/**
	 * @method toString()
	 * method to stringify all Customer details 
	 * */
	public String toString(){
		return "--------------------------------------------------\n"
				+ "customer ID : "+customerId+"\n"
				+ "customer Name : "+customerName+"\n"
						+ "Allocated Room No : "+allocatedRoomTocustomer+"\n"
								+ "customer Age : "+customerAge+"\n"
										+ "customer Address : "+customerAddress.toString()+"\n"
												+ "--------------------------------------------------------";
	}
	
}
