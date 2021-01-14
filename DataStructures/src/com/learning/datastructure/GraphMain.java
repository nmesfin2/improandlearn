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
		
		GraphNode srcNode = new GraphNode("Rome");
		GraphNode destNode = new GraphNode("Seattle");
		
		System.out.println("number of edges :" + shortestPath(g, srcNode, destNode ));
		
		
	}
	
	
	public static int shortestPath(Graph g, GraphNode src, GraphNode dest) {
		Set<GraphNode> isVisited = new LinkedHashSet<GraphNode>();
		LinkedList<GraphNode> queue = new LinkedList<>();

		Map<GraphNode, Integer> dist = new HashMap<GraphNode, Integer>();
		Map<GraphNode, GraphNode> pred = new HashMap<GraphNode, GraphNode>();
		
		int shortest = 0;	
		queue.add(src);
		isVisited.add(src);
		dist.put(src, 0);
		
		while(!queue.isEmpty()) {
			
			GraphNode q = queue.remove();
			
			for(GraphNode w: g.getGraphList().get(q)  ) {
				
				if(!isVisited.contains(w)) {
					isVisited.add(w);
					dist.put(w, dist.get(q) + 1);
					pred.put(w, q);
					shortest++;
					queue.add(w);
					
					if(w.equals(dest)) {
						break;
					}
				}
				
				
			}
		}
		
		
		for (GraphNode graphNode : dist.keySet()) {
			System.out.println(" graphNode : " + graphNode.getCity() + " " + dist.get(graphNode));
		}
		
		for (GraphNode graphNode : pred.keySet()) {
				System.out.println(" graphNode : " + graphNode.getCity() + " " + pred.get(graphNode).getCity());
		}
		
		if(pred.get(dest) != null) {
			System.out.print("The path from Source to Destination in reverse order: ");
			System.out.print("[ " + dest.getCity() + " ");
			printPath(pred, dest);
			
			
			System.out.print("]");
			System.out.println();
		}
		
		
		shortest = dist.get(dest);
		return shortest;

		
	}
	
	
	public static void printPath(Map<GraphNode, GraphNode> path,  GraphNode curr) {
		if(path.get(curr) == null) {
			return;
		}else {
			

			System.out.print(path.get(curr).getCity() + " ");
			curr = path.get(curr);
			printPath(path, curr);

		}

		
	}

}
