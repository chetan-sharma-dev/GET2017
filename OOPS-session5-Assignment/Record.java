package SocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Record {
	String name, content, userId, recordId;
	List<Record> recordsList;
	HashMap<String, List<Record>> postOfUsers = new HashMap<String, List<Record>>();

	/**
	 * @return the id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setUserId(String id) {
		this.userId = id;
	}

	/**
	 * @return the id
	 */
	public String getrecordId() {
		return recordId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setrecordId(String id) {
		this.recordId = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	public void createRecord(String recordId, String userID, String content,
			String name) {
		Record record = new Record();
		record.setrecordId(recordId);
		record.setUserId(userID);
		record.setContent(content);
		record.setName(name);
		if (postOfUsers.containsKey(this.userId)) {
			postOfUsers.get(userId).add(record);
		} else {
			recordsList = new ArrayList<Record>();
			recordsList.add(record);
			postOfUsers.put(userId, recordsList);
		}
	}

	public void printRecords() {
		Iterator<Record> itr = postOfUsers.get(userId).iterator();
		while (itr.hasNext()) {
			Record temp = itr.next();
			System.out.println("recordID : " + temp.getrecordId()
					+ " title of post : " + temp.getName() + " content : "
					+ temp.getContent());
		}
	}

	public void deleteRecord(String id) {
		Iterator<Record> itr = postOfUsers.get(userId).iterator();
		while (itr.hasNext()) {
			Record temp = itr.next();
			if (temp.recordId.equals(id)) {
				postOfUsers.get(userId).remove(temp);
			}
		}
		System.out.println("Record has been deleted");
		printRecords();
	}
}
