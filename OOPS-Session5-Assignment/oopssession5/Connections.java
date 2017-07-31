package oopssession5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
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
	
	private HashMap<Integer,ArrayList<Integer>> allConnections;
	
	public Connections()
	{
		allConnections=new HashMap<>();
	}

	public HashMap<Integer,ArrayList<Integer>> getConnections() {
		return allConnections;
	}

	public void setConnections(HashMap<Integer,ArrayList<Integer>> allConnections) {
		this.allConnections = allConnections;
	}

	public void initailizeAllConnections(String path) throws IOException
	{
		FileInputStream fileInput = new FileInputStream(path);
		BufferedReader bufferInput = new BufferedReader(new InputStreamReader(
				fileInput));
		String connectionsDetails;
		while ((connectionsDetails=bufferInput.readLine()) != null) {
			String[] connectionStringArray=connectionsDetails.split("\\,");
			ArrayList<Integer> connectionsList;
		//	System.out.println("length"+connectionStringArray.length);
			if(connectionStringArray.length>=2)
				{
				
					connectionsList=new ArrayList<>(Arrays.asList(connectionStringArray[1].split("\\:")).stream()
		            .map(Integer::valueOf).collect(Collectors.toList()));
				}
			else
			{
				connectionsList=new ArrayList<Integer>();
				
			}
			allConnections.put(Integer.parseInt(connectionStringArray[0]),connectionsList);
		
		}
	}
	
	public void addConnectionsInGraph(int firstPersonId,int secondPersonId) throws IOException
	{
			
			ArrayList<Integer> listOfConnection=allConnections.get(firstPersonId);
			
			listOfConnection.add(secondPersonId);
			allConnections.put(firstPersonId,listOfConnection);
			listOfConnection=allConnections.get(secondPersonId);
			listOfConnection.add(firstPersonId);
			updateConnectionsInFile();
	}

	
	public void updateConnectionsInFile() throws IOException
	{
		String path="src/oopssession5/connection.csv";
		int noOfLines=FileOperations.countNoOfLinesInFile(path);
		 FileWriter fstream = new FileWriter(path);
	        BufferedWriter out = new BufferedWriter(fstream);
	        int setSize=allConnections.keySet().size();
			Integer[] splitedArray=allConnections.keySet().toArray(new Integer[setSize]);
			
			for(int i=0;i<noOfLines;i++)
			{	String connectionString="";
				List<Integer> connectionListOfUser=allConnections.get(splitedArray[i]);
				Iterator<Integer> listIterator=connectionListOfUser.iterator();
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
		
		
	
	public List<Integer> getConnections(int entityId)
	{
		return allConnections.get(entityId);
	}

}
