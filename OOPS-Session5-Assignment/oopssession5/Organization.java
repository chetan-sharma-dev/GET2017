package oopssession5;

public class Organization extends Entity {
	
	private String organizationWork;

	public Organization(int entityId,String entityType,String entityName,String organizationWork)
	{
		super(entityId, entityType, entityName);
		this.organizationWork=organizationWork;
		
	}
	
	public String getOrganisationWork() {
		return organizationWork;
	}

	public void setOrganisationWork(String organisationWork) {
		this.organizationWork = organisationWork;
	} 

}
