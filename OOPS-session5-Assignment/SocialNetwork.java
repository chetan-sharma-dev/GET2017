package oopssession5;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class SocialNetwork {
	static Scanner scanInput=new Scanner(System.in);
	public static Entity[] entityObject ;
	public static Node[] nodeObject;
	public static Graph graphObject;
	public static Connections connectionObject;
	
	/**
	 * @method scanIntegervalueWithValidation()
	 * method takes integer Values and check for validation
	 * */
	public static int scanIntegervalueWithValidation()
	{
		try
		{
			String user_input=scanInput.nextLine();
			int value=Integer.parseInt(user_input);
			if(value>0)
				return value ;
			else 
				throw new Exception();
		}
		catch(Exception e)
		{
			System.out.print("Enter valid Integer value ,");
			return -1;
		}
	}
	/**
	 * @method createNewUser() 
	 * method for creating new user 
	 * showing menu and scanning user input 
	 * calling method recursively while entered input is invalid
	 * */
	public static void createNewUser() 
	{
		String entityDetails="";
		System.out.println("Select Entity Type:");
		System.out.println("1.User \n2.Organization \n3.go back");
		int choice=scanIntegervalueWithValidation();
		String entityType="";
		switch(choice)
		{
			case 1: entityType="User";break;
			case 2: entityType="Organization";break;
			case 3: return;
			default:
				System.out.println("Invalid Input"); 
				createNewUser();	
				return;
		}
		System.out.println("Enter ID:");
		int entityId=scanIntegervalueWithValidation();
		/*
		 * validating userId
		 * */
		if(!Entity.isValidEntity(entityId)&&entityId>0)
		{
			System.out.println("Enter Name:");
			String entityName=scanInput.nextLine();
			if("User".compareTo(entityType)==0)
			{
				System.out.println("Enter Age:");
				int entityAge=scanIntegervalueWithValidation();
				System.out.println("Enter Hobby:");
				String entityHobby=scanInput.nextLine();
				entityDetails=entityId+","+entityType+","+entityName+","+entityHobby+","+entityAge;
			}
			else if("Organization".compareTo(entityType)==0)
			{
				System.out.println("Enter Organization work:");
				String organizationName=scanInput.nextLine();
				entityDetails=entityId+","+entityType+","+entityName+","+organizationName;
			}
		}
		else if(entityId>0)
		{
			System.out.println("Entity Already exist");
			createNewUser();
		}
		else
		{
			System.out.println("Invalid format Id entered");
			createNewUser();
		}
		/*
		 * if some entry to be done then append in file
		 * */
		if(entityDetails.length()>0)
		{
			FileOperations.appendInFile("src/oopssession5/userdetails.csv",entityDetails );
			FileOperations.appendInFile("src/oopssession5/connection.csv",entityId+",");
		}
		
		initialize();
	}
	
	/*@method displayEntityConnections(int entityId)
	 * method for displaying Entities Connections
	 * */
	public static void displayEntityConnections(int entityId)
	{
		/*
		 * iterating connection list
		 * */
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("All your connections:");
		List<Integer> allConnections=connectionObject.getConnections(entityId);
		if(allConnections!=null)
		{
			Iterator<Integer> iterateConnetions=allConnections.iterator();
			while(iterateConnetions.hasNext()) {
	         System.out.println(iterateConnetions.next());
	      }
		}
		else
		{
			System.out.println("No List available ");
		}
	}
	
	/* @method displayEntityProfile(int entityId)
	 * methods for displaying entity profile
	 * */
	public static void displayEntityProfile(int entityId)
	{
		System.out.println("--------------------------------------------------------------------------------");
		Entity entityObject=Entity.getEntityReference(entityId);
		System.out.println("Your Id : "+entityId);
		System.out.println("Name : "+entityObject.getEntityName());
		System.out.println("Type : "+entityObject.getEntityType());
		if(entityObject instanceof User)
		{	
			System.out.println("Age : "+((User)entityObject).getAge());
			System.out.println("Hobby : "+((User)entityObject).getHobby());
		}
		else
		{
			System.out.println("Work : "+((Organization)entityObject).getOrganisationWork());
		}
		displayEntityConnections(entityId);
		
	}
	
	/**
	 * @method connectPersons(int firstEntityId)
	 * method for connecting two persons in connections
	 * */
	public static void connectPersons(int firstEntityId)
	{
		System.out.println("Enter Id of entity for connection:");
		int secondEntityId=scanIntegervalueWithValidation();
		/*
		 * checking whether the given entry is valid or not
		 * if valid then connect else show error message
		 * id for connection should be different from given ids
		 * */
		if(Entity.isValidEntity(secondEntityId)&&firstEntityId!=secondEntityId)
		{
			connectionObject.addConnectionsInGraph(firstEntityId, secondEntityId);
			initialize();
			return;
		}
		else if(firstEntityId==secondEntityId)
		{
			System.out.println("you can't be friend of yours");
		}
		else
		{
			System.out.println("Invalid Id");
		
		}
		
	}
	
	/**
	 * @method displayAllSuggestions(int entityId)
	 * method for displaying all suggestions
	 * */
	public static void displayAllSuggestions(int entityId)
	{
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Entity Id \t entity Type \t entity Name");
		System.out.println("--------------------------------------------------------------------------------");
		for(int i=0;i<entityObject.length;i++)
		{
			/*
			 * Entity itself will not be displayed
			 * checking connections , already connected are not displayed
			 * */
			if(entityObject[i].getEntityId()!=entityId&&!connectionObject.getConnections().get(entityId).contains(entityObject[i].getEntityId()))
			{
				System.out.println(entityObject[i].getEntityId()+"\t\t"+entityObject[i].getEntityType()+"\t\t"+entityObject[i].getEntityName());
			}
		}
		
	}
	
	/**
	 * @method displayAllConnections()
	 * method for displaying all connections
	 * */
	
	public static void displayAllConnections()
	{
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\t\t\tAll connections");
		System.out.println("--------------------------------------------------------------------------------");
		/*
		 * getting all connection HashMap and printing connections
		 * */
		HashMap<Integer,ArrayList<Integer>> connectionListOfEntities=connectionObject.getConnections();
		 int setSize=connectionListOfEntities.keySet().size();
		Integer[] splitedArray=connectionListOfEntities.keySet().toArray(new Integer[setSize]);
		
		for(int i=0;i<setSize;i++)
		{	
			/*
			 * getting connections list for particular Entity and iterating list
			 * */
			List<Integer> listOfConnections=connectionListOfEntities.get(splitedArray[i]);
			Iterator<Integer> listIterator=listOfConnections.iterator();
			System.out.print(splitedArray[i]+"-->");
			while(listIterator.hasNext())
			{
				System.out.print(listIterator.next()+",");
			}
			System.out.println();
			
		}
	}
	
	/**
	 * @method displayAllNetworkUsers()
	 * displaying all network entities
	 * */
	public static void displayAllNetworkUsers()
	{
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("Entity Id \t\t entity Type \t\t entity Name");
		System.out.println("--------------------------------------------------------------------------------");
		for(int i=0;i<entityObject.length;i++)
		{
			System.out.println(entityObject[i].getEntityId()+"\t\t"+entityObject[i].getEntityType()+"\t\t"+entityObject[i].getEntityName());
			
		}
		
		
	}
	/**
	 * 	@method searchByName()
	 * 	 searching by name in network an showing his details
	 * */
	public static void searchByName()
	{
		System.out.println("Enter the name to search");
		String searchName=scanInput.nextLine();
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("\t\t\tSearch result ");
		System.out.println("--------------------------------------------------------------------------------");
		
		Iterator<Node> nodeIterator=graphObject.getListOfAllNodes().iterator();
		while(nodeIterator.hasNext())
		{
			Entity entityReference=nodeIterator.next().getEntityReference();
			if(entityReference.getEntityName().compareTo(searchName)==0)
				{
					System.out.println(entityReference.getEntityId()+","+entityReference.getEntityType()+","+entityReference.getEntityName());
				}
		}
		
	}
	
	/**
	 * @method initialize()
	 * initializing all Entity and Node and connection objects
	 * */
	public static void initialize()
	{
		try{
			String path="src/oopssession5/userdetails.csv";
			int noOfEntities = FileOperations.countNoOfLinesInFile(path);
			
			entityObject =new Entity[noOfEntities];
			entityObject=Entity.readFileAndInitailizeEntities(noOfEntities,path);
			nodeObject=new Node[noOfEntities];
			graphObject=new Graph();
			connectionObject=new Connections();
			connectionObject.initailizeAllConnections("src/oopssession5/connection.csv");
			nodeObject=Node.initailizeAllNodes(entityObject,graphObject,connectionObject);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
	}
	
	/**
	 * @method signin()
	 * method for signing in
	 * showing Entity Options if valid id entered
	 * */
	public static void signin()
	{
		System.out.println("Enter Your Id");
		int entityId=scanIntegervalueWithValidation();
		if(Entity.isValidEntity(entityId))
		{
			showEntityOptions(entityId);
		}
		else
		{
			System.out.println("not a valid user");
		}
	}
	
	/**
	 * @method showEntityOptions(int entityId)
	 * method showing all options to logged in Entity
	 * */
	public static void showEntityOptions(int entityId)
	{
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("1.see profile \n2.see your connections \n3.see all connection suggestions \n4.connect to another other Users \n5.Go Back");
		System.out.println("--------------------------------------------------------------------------------");
		int choosedOption=scanIntegervalueWithValidation();
		
		System.out.println("");
		switch (choosedOption) {
		case 1:
			displayEntityProfile(entityId);
			break;
		case 2:
			displayEntityConnections(entityId);
			break;
		case 3:
			displayAllSuggestions(entityId);
			break;
		case 4:
			connectPersons(entityId);
			break;
		case 5:
			return;
		default:
			System.out.println("Invalid choice entered");
			showEntityOptions(entityId);
			return;
		}
		showEntityOptions(entityId);
	}
	

	public static void main(String...s) throws IOException
	{
		initialize();
		while(true)
		{
			System.out.println("--------------------------------------------------------------------------------");
			System.out.println("Enter Your Choice");
			System.out.println("1.Signin \n2.signup \n3.display all network Users \n4.Display all connections \n5.Search by Name \n6.Exit");
			System.out.println("--------------------------------------------------------------------------------");
			int choice=scanIntegervalueWithValidation();
			
			switch(choice)
			{
				case 1:
						signin();	
						break;
				case 2:
						createNewUser();
						break;
				case 3:
						displayAllNetworkUsers();
						break;
				case 4:
						displayAllConnections();
						break;
				case 5:
						searchByName();
						break;
				case 6:
						System.exit(0);
				default: 
						System.out.println("Invalid choice entered");
				
			
			}
			
			
		}
		
		
	}

}
