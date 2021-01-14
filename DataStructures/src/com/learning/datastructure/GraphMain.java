package com.learning.datastructure;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import com.learning.datastructure.GraphNode;

public class GraphMain {

	public static void main(String [] args) {
		Graph g = new Graph();
		
		g.addGraphNode("Rome");
		g.addGraphNode("London");
		g.addGraphNode("Paris");
		g.addGraphNode("Addis");
		g.addGraphNode("German");
		g.addGraphNode("Brazil");
		g.addGraphNode("Seattle");
		
		g.addEdge("Rome", "London");
		g.addEdge("Rome", "Paris");
		g.addEdge("Rome", "German");
		
		g.addEdge("Paris", "German");
		g.addEdge("Paris", "Brazil");
		
		g.addEdge("London", "Addis");
		g.addEdge("London", "German");
		
		g.addEdge("Addis", "Seattle");
		g.addEdge("German", "Seattle");	
		g.addEdge("Brazil", "Seattle");
		
	
		for (GraphNode n : g.getGraphList().keySet()) {
			System.out.println(n.getCity());
			System.out.println("-----------------------------------------------------");
			for(GraphNode adjN: g.getGraphList().get(n)) {
				System.out.println(" " + adjN.city);
			}
			
			System.out.println();
		}
		
		GraphNode srcNode = new GraphNode("London");
		GraphNode destNode = new GraphNode("Seattle");
		
		System.out.println(shortestPath(g, srcNode, destNode ));
		
		
	}
	
	
	public static int shortestPath(Graph g, GraphNode src, GraphNode dest) {
		Set<GraphNode> isVisited = new LinkedHashSet<GraphNode>();
		LinkedList<GraphNode> queue = new LinkedList<>();

		int shortest = 1;	
		queue.add(src);
		isVisited.add(src);
		while(!queue.isEmpty()) {
			GraphNode q = queue.remove();
			for(GraphNode w: g.getGraphList().get(q)  ) {
				if(!isVisited.contains(w)) {
					shortest++;
					queue.add(w);
					isVisited.add(w);
					//w.setVisited(true);
					
					if(g.getGraphList().get(w).contains(dest)) {
						isVisited.add(dest);
						System.out.println("inside if");
						for (GraphNode graphNode : isVisited) {
							System.out.println(graphNode.getCity());
						}
						
						shortest = isVisited.size();
						return shortest;
					}else {
						isVisited.remove(w);
						//shortest--;
					}
				}
				
				
			}
		}
		
		
		for (GraphNode graphNode : isVisited) {
			System.out.println(graphNode.getCity());
		}
		return shortest;

		
	}

}
