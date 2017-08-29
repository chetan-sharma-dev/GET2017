package com.metacube.node;

public class Node {
	
	private Object data;
	private Node nextNode;
	
	public Node(Object elementData)
	{
		this.data=elementData;
		nextNode=null;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	public Node getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}
	
}
