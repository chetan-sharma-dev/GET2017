package pfsession4;

import java.util.ArrayList;
import java.util.List;

public class TowerOfHanoi {
	/*
	 * creating common list instance
	 * */
	public List<String> movements_list;
	
	public TowerOfHanoi() {
		// TODO Auto-generated constructor stub
		movements_list = new ArrayList<String>();
	}

	/**
	 * @Method	towerOfHanoi(String source, String destination,
			String temp, int numOfDisk)
	 * returning all movements in shifting disks from start to end tower
	 * @param	Source,Destination,Auxiliary disk name in  String and number of Strings 
	 * @return	type = List<String>, list of possible movements
	 * */
	public List<String> towerOfHanoi(String source, String destination,
			String temp, int numOfDisk) {
		try {
			/*
			 * desired condition checked , if fails return IlligalArgumentsExceptions
			 * */
			if (numOfDisk > 0 && source.length()!=0&&destination.length()!=0&&temp.length()!=0) {
				/*
				 * if disk is only one then add simply the movement string to movement list
				 * */
				if (numOfDisk == 1) {
					movements_list.add("Move Disk "+numOfDisk+" from " + source + " to "
							+ destination);

				} else {
					/*
					 * Do empty source except last disk 
					 * */
					towerOfHanoi(source, temp, destination, numOfDisk - 1);
					/*
					 * now move last disk in source to destination  
					 * */
					movements_list.add("Move Disk "+numOfDisk+" from "+ source + " to "
							+ destination);
					/*
					 * now use temp source tower to do arrengement   
					 * */
					towerOfHanoi(temp, destination, source, numOfDisk - 1);

				}
				return movements_list;
			} else {
				throw new Exception("no of disks can't be negative or zero");
			}
		} catch (Exception e) {
			System.out.println(e);
			return movements_list;
		}
	}

	

}
