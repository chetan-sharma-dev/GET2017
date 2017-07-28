package SocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Connection {

	HashMap<String, List<String>> connectionMap = new HashMap<String, List<String>>();

	public Connection(String file) {
		String stringOutput[] = file.split("\n");
		String str[] = {};
		List<String> listOfFriends = new ArrayList<String>();
		for (int index = 0; index < stringOutput.length; index++) {
			str = stringOutput[index].split(",");
			for (int jindex = 1; jindex < str[index].length(); jindex++) {
				listOfFriends.add(str[jindex]);
			}
			connectionMap.put(str[0], listOfFriends);
		}
	}

	public void addConnection(String friendId, String userID) {
		// TODO Auto-generated method stub

		if (connectionMap.containsKey((userID))) {
			if (connectionMap.get(userID).contains(friendId)) {
				System.out.println("this is already your friend");
			} else {
				connectionMap.get(userID).add(friendId);
			}

		} else {
			List<String> list = new ArrayList<String>();
			list.add(friendId);
			connectionMap.put(userID,list);
		}
	}

}
