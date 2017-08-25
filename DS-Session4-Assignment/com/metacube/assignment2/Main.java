package main.java.com.metacube.assignment2;
import java.util.HashMap;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		HashMap<Integer,Guest> roomallocation =RoomController.getmap();
		
		System.out.println("Total number of guest");
		
		int totalnum= scan.nextInt();
		String name;
		int age;
		
		for(int counter=0;counter<totalnum;counter++){
			int count=0;
			System.out.println("Enter name");
			name=scan.next();
			System.out.println("Enter age");
			age=scan.nextInt();
			Guest curGuest=new  Guest(name, age);
			int hashcode=curGuest.hashCode();
			while( count!= RoomController.getRoomNum() && roomallocation.containsKey(hashcode)){
				hashcode++;
				hashcode=hashcode%RoomController.getRoomNum();
				count++;
				
			}
			if(count!= RoomController.getRoomNum()){
				roomallocation.put(hashcode, curGuest);
			}else{
				System.out.println();
				System.out.println("############### No Rooms Available ##############");
				System.out.println();
			}
		}
		
		System.out.println("###############################");
		System.out.println();
		System.out.println("Room Number   Name Of the Guest   Age");
		System.out.println();
		for (Integer roomNumber: roomallocation.keySet()){

            System.out.print(roomNumber+ "\t\t");
            System.out.print(roomallocation.get(roomNumber).getName() + "\t\t"); 
			System.out.print(roomallocation.get(roomNumber).getAge()); 
         
         
            System.out.println();
			} 
		
	}
}
