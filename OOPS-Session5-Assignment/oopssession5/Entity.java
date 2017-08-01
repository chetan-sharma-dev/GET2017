package oopssession5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


 public class Entity {

	private int entityId;
	private String entityName;
	private String entityType;
	/*
	 * common data member for all objects of Entity class 
	 * has reference of all entries of Ids and their references
	 * */
	private static HashMap<Integer, Entity> allEntityReferences=new HashMap<Integer, Entity>();
	
	/**
	 * @constructor initializing datamembers
	 * */
	public Entity(int entityId,String entityType,String entityName)
	{
		this.entityId=entityId;
		this.entityType=entityType;
		this.entityName=entityName;
	}
	/*
	 * @method getEntityReference(int entityId)
	 * returning reference of particular id 
	 * */
	public static Entity getEntityReference(int entityId)
	{
		if(isValidEntity(entityId))
		{
			return allEntityReferences.get(entityId);
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * @method getEntityNewObject(String[] entityDetails)
	 * returning new object of Entity
	 * */
	 private static Entity getEntityNewObject(String[] entityDetails)
		{
		 	int entityId=Integer.parseInt(entityDetails[0]);
			String entityType=entityDetails[1];
			
			String entityName=entityDetails[2];
			
			switch (entityType) {
			
			case "User":
				return new User(entityId, entityType, entityName, entityDetails[3],
						Integer.parseInt(entityDetails[4]));
			case "Organization":
				return new Organization(entityId, entityType, entityName,
						entityDetails[3]);
			default:
				return null;
				
			}
			/*if("User".compareTo(entityType)==0)
			{
				
			}
			else if("Organization".compareTo(entityType)==0)
			{
				return new Organization(entityId, entityType, entityName, entityDetails[3]);
				
			}
			
			else
				return null;*/
		
			
		}
		/*
		 * @method readFileAndInitailizeEntities(int noOfEntities,String path)
		 * method reading from file and initializing all objects of entity class
		 * */
	public static Entity[] readFileAndInitailizeEntities(int noOfEntities,String path)
	{
		try{
		
		Entity[] entityObject=new Entity[noOfEntities];
		
		FileInputStream fileInput = new FileInputStream(path);
		BufferedReader bufferInput = new BufferedReader(new InputStreamReader(
				fileInput));
		String entityDetails;
		int entityIndex=0;
		while ((entityDetails=bufferInput.readLine()) != null) {
			/*
			 * splitting from , and then getting appropriate object for initialization
			 * */
			String[] splitedEntityDetails=entityDetails.split("\\,");
			Entity entityReference=getEntityNewObject(splitedEntityDetails);
			if(entityReference!=null)
			{
				entityObject[entityIndex++]=entityReference;
				allEntityReferences.put(entityReference.getEntityId(), entityReference);
			}else{
				bufferInput.close();
				fileInput.close();
				throw new IOException("invalid entries in file");
			}

		}
		bufferInput.close();
		fileInput.close();
		/*
		 * returning initialized object
		 * */
			return entityObject;
		}catch(FileNotFoundException e)
		{
			System.out.println("file not found"+e);
			return new Entity[0];
		}
		catch(IOException e)
		{
			System.out.println("error in reading file,"+e);
			return new Entity[0];
		}
		

		
	}
	
	public int getEntityId() {
		return entityId;
	}
	
	public static boolean isValidEntity(int entityId)
	{
		return	allEntityReferences.containsKey(entityId);
	}
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getEntityType() {
		return entityType;
	}
	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	
	
	
}
