package com.learning.datastructure;
import java.util.*;

public class Graph {
	
	

	
	private Map<GraphNode, ArrayList<GraphNode>> graphList;
	
	Graph(){
		graphList = new HashMap<>();

	}
	
	public Map<GraphNode, ArrayList<GraphNode>> getGraphList() {
		return graphList;
	}

	public void setGraphList(Map<GraphNode, ArrayList<GraphNode>> graphList) {
		this.graphList = graphList;
	}
	
	
	public void addGraphNode(String city) {
		GraphNode newGraphNode = new GraphNode(city);
		ArrayList<GraphNode> n = new ArrayList<GraphNode>();
		//n.add(newGraphNode);
		graphList.putIfAbsent(newGraphNode, n);
	}
	
	public void addEdge(String firstGraphNode, String secondGraphNode, int edge) {
		GraphNode fVertex = new GraphNode(firstGraphNode);
		GraphNode sVertex = new GraphNode(secondGraphNode, edge);

//		ArrayList<GraphNode> n = graphList.get(fVertex);
		
		graphList.get(fVertex).add(sVertex);
		//System.out.println("n n: " + n);
		//n.add(sVertex);
		//graphList.get(sVertex).add(fVertex);
		
		
	}
	

	
	

	
}
