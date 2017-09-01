package com.metacube.assignment2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * @class GuestHouse
 * class for holding GuestHouse Entries 
 * */
public class GuestHouse {
	private String guestHouseName;
	private Map<Integer,Customer> allocatedRoomsDetails;
	private int currentlyAllocatedNoOFRooms;
	private final int maxRoomsCapacityInGuestHouse;
	private int currentCustomerNo;
	
	/**
	 * @constructor 
	 * parameterized constructor for initializing GuestHouse Object
	 */
	public GuestHouse(String guestHouseName,int roomCapacity) {
		allocatedRoomsDetails=new HashMap<Integer, Customer>();
		maxRoomsCapacityInGuestHouse=roomCapacity;
		currentCustomerNo=0;
		currentlyAllocatedNoOFRooms=0;
		this.guestHouseName=guestHouseName;
	}
	
	/**
	 * @method allocateRoom()
	 * method to allocate room to customers 
	 * */
	public String allocateRoom(Customer customerObject){
		int age=customerObject.getcustomerAge();
		/*
		 * according to age calling hashCode function and getting room no ,
		 * if room no is available the allocate room to customer,
		 * and updating all parameters
		 * else, returning Appropriate ERROR message
		 * */
			if(checkAvailabilityAndAllocateTheRoom(getRoomNo(age),customerObject)){
				return "Room No "+customerObject.getAllocatedRoomTocustomer()+""
						+ " is allocated to Mr. "+customerObject.getcustomerName()+"\n"
						+ "Customer Details are: \n"
						+ customerObject.toString();
			}
			else{
				return " No Room Available for now";
			}		
	} 
	
	/**
	 * @method getRoomNo()
	 * method returning room no after applying hashcode to age
	 * */
	private int getRoomNo(int age){
		return hashCode(age);
	}
	/**
	 * @method checkAvailabilityAndAllocateTheRoom()
	 * according to roomNo calculated using hash Function and custmerObject, 
	 * checking for room Availability and accordingly allocate room
	 * */
	private boolean checkAvailabilityAndAllocateTheRoom(int roomNo,Customer customerObject){
		/*
		 * if room capacity is less than roomNo requested return and room is available to allocate ,
		 * then allocate room and return true
		 * else return false
		 * */
		if(roomNo<=maxRoomsCapacityInGuestHouse){
			if(!isRoomAvailable(roomNo)){
				currentCustomerNo++;
				//setting customerId
				customerObject.setcustomerId(guestHouseName+"/"+currentCustomerNo);
				customerObject.setAllocatedRoomTocustomer(roomNo);
				allocatedRoomsDetails.put(roomNo,customerObject);
				//currentCustomerNo++;
				currentlyAllocatedNoOFRooms++;
				return true;
			}
			else{
				/*
				 * checking for availability of Next Room
				 * */
				return checkAvailabilityAndAllocateTheRoom(roomNo+1, customerObject);
			}
		}else if(currentlyAllocatedNoOFRooms==maxRoomsCapacityInGuestHouse){
			return false;
		}
		else{
			return checkAvailabilityAndAllocateTheRoom(1, customerObject);
		}
	}
	
	/**
	 *	@method hashCode() 
	 * 	calculate hash code using hash function
	 * */
	private int hashCode(int age){
		return (age%maxRoomsCapacityInGuestHouse)+1;
	}
	
	/**
	 * @method isRoomAvailable()
	 * return status according to room availability (true or false) 
	 * */
	public boolean isRoomAvailable(int roomNo)
	{
		return allocatedRoomsDetails.containsKey(roomNo);
	}

	/**
	 * @method getAllBookedRoomsDetails()
	 * method for returning all booked rooms details
	 * */
	public String getAllBookedRoomsDetails(){
		String allAllocatedRoomDetails="";
		List<Customer> allCurrentlyAvailablecustomerList=new ArrayList<Customer>(allocatedRoomsDetails.values());
		Iterator<Customer> iteratorObject=allCurrentlyAvailablecustomerList.iterator();
		while(iteratorObject.hasNext()){
			allAllocatedRoomDetails+=iteratorObject.next().toString()+"\n";
		}
		if(allAllocatedRoomDetails.length()==0){
			return "No Room is booked untill now.";
		}
		else{
			return allAllocatedRoomDetails;
		}	
	}
	/**
	 * @method getcustomerDetails()
	 * according to roomNO get customer details 
	 * */
	public String getcustomerDetails(int roomNo){
		if(roomNo<=maxRoomsCapacityInGuestHouse&&roomNo>0){
			if(allocatedRoomsDetails.containsKey(roomNo)){
				return allocatedRoomsDetails.get(roomNo).toString();
			}
			return "No customer Exist In Room";
		}
		else
			return ErrorShowingConstants.ROOM_NOT_FOUND;
	} 
	/**
	 * @method checkOutFromGuestHouse()
	 * method for customer checkout from guest house
	 * updating all dependent variables 
	 * */
	public String checkOutFromGuestHouse(int roomNo){
		if(isRoomAvailable(roomNo)){
			Customer customerObject=allocatedRoomsDetails.get(roomNo);
			allocatedRoomsDetails.remove(roomNo);
			currentlyAllocatedNoOFRooms--;
			return "Thanks for visiting our Guest House , Mr. "+customerObject.getcustomerName();
		}else{
			return "Sorry this Room No is not booked";
		}
	}
	
}
