package SocialNetwork;
import java.util.*;

public class SocialNetwork {
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		Record record=new Record();
		FileHandling obj = new FileHandling();
		String file = obj.read("Users.txt");
		Graph node = new Graph(file);
		file = obj.read("Connections.txt");
		Connection con = new Connection(file);
		do{
			System.out.println("1. Login");
			System.out.println("2. SignUp");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			int input = scan.nextInt();
			String name = "" , userID = "";
			boolean flag = true;
			switch(input){
			case 1:
				System.out.println("enter your userID ");
				userID = scan.next();
				while(!node.checkNode(userID)){
					System.out.println("enter a valid userID ");
					userID = scan.next();
					}
					System.out.println("Welcome !! "+ node.printName(userID));
					do{
					System.out.println("1. Edit profile");
					System.out.println("2. Delete profile");
					System.out.println("3. Add Record");
					System.out.println("4. Delete Record");
					System.out.println("5. Add connection");
					System.out.println("6. Delete connection");
					System.out.println("7. Back");
					input = scan.nextInt();
					switch(input){
					case 1:
						System.out.println("Edit your name");
						name = scan.next();
						node.editNode(userID,name);
						break;
					case 2:
						node.deleteNode(userID);
						break;
					case 3:
						System.out.println("Add id of your record");
						String recordId = scan.next();
						System.out.println("Add title of your record");
						name= scan.next();
						System.out.println("Add content of record");
						String content = scan.next();
						record.createRecord(recordId,userID,content,name);
						break;
					case 4:
						record.printRecords();
						System.out.println("Enter id of record you want to delete");
						recordId = scan.next();
						record.deleteRecord(recordId);
						break;
					case 5:
						System.out.println("Enter id of the connection you want to add as a friend");
						String friendId= scan.next();
						con.addConnection(friendId,userID);
						
						break;
					case 6:
						break;
					case 7:
						flag = false;
						break;
					}}while(flag);
				break;
			case 2:
				System.out.println("1. Signup as User");
				System.out.println("2. SignUp as Organization");
				input = scan.nextInt();
				switch(input){
				case 1:
					System.out.println("enter your name ");
					name = scan.next();
					System.out.println("enter a userID ");
					userID = scan.next();
					node.createNode(new User(),name,userID);
					break;
				case 2:
					System.out.println("enter name of organization ");
					name = scan.next();
					System.out.println("enter a userID ");
					userID = scan.next();
					node.createNode(new Organization(),name,userID);
					break;
				}
				break;
			case 3:
				System.exit(0);
			}
		}while(true);
	}
}
