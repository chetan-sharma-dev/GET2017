package main.java.com.metacube.assignment2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoomDao {
	
	static HashMap<Integer,Guest> rooms= new HashMap<Integer,Guest>();
	static final int totalRoomNumber = 41;
	
	/**
	 * function to return the total number of rooms
	 * @return the total number of the room 
	 */
	public static int getTotalRooms(){
		return totalRoomNumber;
	}

	/**
	 * @return room map which stores the room number 
	 * and guest data in the map
	 */
	public static HashMap<Integer, Guest> getRooms() {
		return rooms;
	}

	
}
