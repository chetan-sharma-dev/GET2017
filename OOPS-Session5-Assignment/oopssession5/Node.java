package oopssession5;

public class Node {
	private int entityId;
	private Entity entityReference;
	
	
	public Node(int entityId,Entity entityReference)
	{
		this.setEntityId(entityId);
		this.setEntityReference(entityReference);
	}

	
	public static Node[] initailizeAllNodes(Entity[] entityObject,Graph graphObject,Connections connectionObject)
	{
		int noOfNodeObjects=entityObject.length;
		Node[] nodeObjects=new Node[noOfNodeObjects];
		
		for(int index=0;index<noOfNodeObjects;index++)
		{
			nodeObjects[index]=new Node(entityObject[index].getEntityId(),entityObject[index]);
			graphObject.addNodeInGraph(nodeObjects[index]);
		}
		return nodeObjects;
	}
	
	
	public int getEntityId() {
		return entityId;
	}
	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}
	public Entity getEntityReference() {
		return entityReference;
	}
	public void setEntityReference(Entity entityReference) {
		this.entityReference = entityReference;
	}
	
	
}
