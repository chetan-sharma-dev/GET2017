package oopssession5;

import java.util.ArrayList;
import java.util.HashMap;

public class Record {

	private HashMap<Integer, ArrayList<String>> recordOfUsers;
	
	public Record() {
		recordOfUsers=new HashMap<>();
	}

	public HashMap<Integer, ArrayList<String>> getRecordOfUsers() {
		return recordOfUsers;
	}

	public void setRecordOfUsers(HashMap<Integer, ArrayList<String>> recordOfUsers) {
		this.recordOfUsers = recordOfUsers;
	}
	
}
