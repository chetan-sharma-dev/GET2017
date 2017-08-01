package oopssession5;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
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

	public void addNodeInGraph(Node nodeObject)
	{
		List<Node> listOfAllNodes=getListOfAllNodes();
		listOfAllNodes.add(nodeObject);
		setListOfAllNodes(listOfAllNodes);
	}
}
