package oopssession5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


 public class Entity {

	private int entityId;
	private String entityName;
	private String entityType;
	
	private static HashMap<Integer, Entity> allEntityReferences=new HashMap<Integer, Entity>();
	
	public Entity(int entityId,String entityType,String entityName)
	{
		this.entityId=entityId;
		this.entityType=entityType;
		this.entityName=entityName;
	}
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
	
	 private static Entity getEntityObject(String[] entityDetails)
		{
		 	int entityId=Integer.parseInt(entityDetails[0]);
			String entityType=entityDetails[1];
			
			String entityName=entityDetails[2];
			
			if("User".compareTo(entityType)==0)
			{
				return new User(entityId, entityType, entityName, entityDetails[3], Integer.parseInt(entityDetails[4]));
				
			}
			else if("Organization".compareTo(entityType)==0)
			{
				return new Organization(entityId, entityType, entityName, entityDetails[3]);
				
			}
			
			else
				return null;
		
			
		}
		
	public static Entity[] readFileAndInitailizeEntities(int noOfEntities,String path) throws IOException
	{
		try{
		
		Entity[] entityObject=new Entity[noOfEntities];
		
		FileInputStream fileInput = new FileInputStream(path);
		BufferedReader bufferInput = new BufferedReader(new InputStreamReader(
				fileInput));
		String entityDetails;
		int entityIndex=0;
		while ((entityDetails=bufferInput.readLine()) != null) {
			String[] splitedEntityDetails=entityDetails.split("\\,");
			Entity entityReference=getEntityObject(splitedEntityDetails);
			if(entityReference!=null)
			{
				entityObject[entityIndex++]=entityReference;
				allEntityReferences.put(entityReference.getEntityId(), entityReference);
			}else{
				bufferInput.close();
				fileInput.close();
				throw new NullPointerException("invalid entries in file");
			}

		}
		bufferInput.close();
		fileInput.close();
		/*
		 * returning initialized object
		 * */
		return entityObject;
		}catch(IOException e)
		{
			//System.out.println(e);
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
