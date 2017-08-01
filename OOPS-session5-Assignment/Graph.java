package oopssession5;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	/*
	 * list of all nodes
	 * */
	private List<Node> listOfAllNodes;
	
	public Graph()
	{
		listOfAllNodes=new ArrayList<Node>();
	}

	public List<Node> getListOfAllNodes() {
		return listOfAllNodes;
	}

	public void setListOfAllNodes(List<Node> listOfAllNodes) {
		this.listOfAllNodes = listOfAllNodes;
	}

	/*
	 * add node class object in list  
	 * */
	public void addNodeInGraph(Node nodeObject)
	{
		List<Node> listOfAllNodes=getListOfAllNodes();
		listOfAllNodes.add(nodeObject);
		setListOfAllNodes(listOfAllNodes);
	}
}
