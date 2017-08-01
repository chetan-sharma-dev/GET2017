package oopssession5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;


public class Connections {
	/*
	 * connection HashMap having entries of allConnections  
	 * Entity id and list of entityIds connected to this entity Id stored
	 * */
	private HashMap<Integer,ArrayList<Integer>> allConnections;
	
	public Connections()
	{
		allConnections=new HashMap<>();
	}

	/*
	 * returning all connections
	 * */
	public HashMap<Integer,ArrayList<Integer>> getConnections() {
		return allConnections;
	}

	public void setConnections(HashMap<Integer,ArrayList<Integer>> allConnections) {
		this.allConnections = allConnections;
	}

	/*
	 * read connections from file and store all connections in HashMap
	 * */
	public void initailizeAllConnections(String path) 
	{
		/*
		 * reading from file
		 * */
	try{
		FileInputStream fileInput = new FileInputStream(path);
		BufferedReader bufferInput = new BufferedReader(new InputStreamReader(
				fileInput));
		/*
		 * reading connection string in connectionDetils
		 * */
		String connectionsDetails;
		while ((connectionsDetails=bufferInput.readLine()) != null) {
			/*
			 * splitting connection string array
			 * */
			String[] connectionStringArray=connectionsDetails.split("\\,");
			/*
			 * if connectionStringArray length is > 2 
			 * means there is some connection already exist in file
			 * then converting this array into list
			 * else
			 * new list created 
			 * */
			ArrayList<Integer> connectionsList;
			if(connectionStringArray.length>=2)
				{
					connectionsList = new ArrayList<>(Arrays
							.asList(connectionStringArray[1].split("\\:"))
							.stream().map(Integer::valueOf)
							.collect(Collectors.toList()));
				}
			else
			{
				connectionsList=new ArrayList<Integer>();
			}
			/*
			 * doing entry in allConnection HashMap
			 * */
			allConnections.put(Integer.parseInt(connectionStringArray[0]),connectionsList);
		
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not founf" + e);
		} catch (IOException e) {
			System.out.println("error in reading file" + e);
		}
	}
	
	/*
	 * @method addConnectionsInGraph(int firstPersonId,int secondPersonId)
	 * doing connections between two Entities
	 * */
	public void addConnectionsInGraph(int firstPersonId,int secondPersonId)
	{
			/*
			 * handling IOException
			 * getting list of connected people with given Entity and then doing Entry of second one
			 * and at last updating the file as well
			 * */
			ArrayList<Integer> listOfConnection=allConnections.get(firstPersonId);
			if(!listOfConnection.contains(secondPersonId))
			{
				listOfConnection.add(secondPersonId);
				allConnections.put(firstPersonId,listOfConnection);
				listOfConnection=allConnections.get(secondPersonId);
				listOfConnection.add(firstPersonId);
				updateConnectionsInFile();
				System.out.println("You are successfully connected with "+secondPersonId);
			}
			else
			{
				System.out.println("You are already connected with "+secondPersonId);
			}
	
	}

	/*
	 * updating connection file  
	 * simply doing entry in file
	 * */
	public void updateConnectionsInFile(){
		try{
		String path="src/oopssession5/connection.csv";
		int noOfLines=FileOperations.countNoOfLinesInFile(path);
		 FileWriter fstream = new FileWriter(path);
	        BufferedWriter out = new BufferedWriter(fstream);
	        int setSize=allConnections.keySet().size();
			/*
			 * getting all keySet items and then storing their list in file 
			 * */
			Integer[] splitedArray=allConnections.keySet().toArray(new Integer[setSize]);
			
			for(int i=0;i<noOfLines;i++)
			{	String connectionString="";
				List<Integer> connectionListOfUser=allConnections.get(splitedArray[i]);
				Iterator<Integer> listIterator=connectionListOfUser.iterator();
				/*
				 * generating connection string and doing entry in file
				 * */
				connectionString=""+splitedArray[i]+",";
				while(listIterator.hasNext())
				{
					connectionString=connectionString+listIterator.next()+":";
				}
				out.write(connectionString);
				 out.newLine();
				
			}
			
			out.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
			
		}
		
		
	
	public List<Integer> getConnections(int entityId)
	{
		return allConnections.get(entityId);
	}

}
