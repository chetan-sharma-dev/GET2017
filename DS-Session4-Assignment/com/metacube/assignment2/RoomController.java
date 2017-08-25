package main.java.com.metacube.assignment2;
import java.util.HashMap;

public class RoomController {

	/**
	 * @return the total number of rooms
	 */
	public static int getRoomNum() {
		
		return RoomDao.getTotalRooms();
	}

	/**
	 * @return the hashmap of room and guests
	 */
	public static HashMap<Integer, Guest> getmap() {

		return RoomDao.getRooms();
	}

	
	
}
