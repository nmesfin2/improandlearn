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
		
		g.addEdge("Rome", "London", 2);
		g.addEdge("Rome", "Paris", 4);
		g.addEdge("Rome", "German", 3);
		
		g.addEdge("Paris", "German", 2);
		g.addEdge("Paris", "Brazil", 1);
		
		g.addEdge("London", "Addis", 1);
		g.addEdge("London", "German", 2);
		
		g.addEdge("Addis", "Seattle", 2);
		g.addEdge("German", "Seattle", 1);	
		g.addEdge("Brazil", "Seattle", 3);
		
	
//		for (GraphNode n : g.getGraphList().keySet()) {
//			System.out.println(n.getCity());
//			System.out.println("-----------------------------------------------------");
//			for(GraphNode adjN: g.getGraphList().get(n)) {
//				System.out.println(" " + adjN.city);
//			}
//			
//			System.out.println();
//		}
//		
		GraphNode srcNode = new GraphNode("Paris");
		GraphNode destNode = new GraphNode("Seattle");
		
		//System.out.println("number of edges :" + shortestPath(g, srcNode, destNode ));
		shortestPathDjikstra(g, srcNode, destNode );
		
		
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
	
	
	public static int shortestPathDjikstra(Graph g, GraphNode src, GraphNode dest) {
		int Vertices = g.getGraphList().size();
		
		Map<String, Integer> distance = new HashMap<>();
		Map<GraphNode, Boolean> visited = new HashMap<>();
		Map<GraphNode, GraphNode> pred = new HashMap<>();
		
		for(GraphNode gn: g.getGraphList().keySet() ) {
			if(gn.getCity().equals(src.getCity())) {
				distance.put(gn.getCity(), 0);
			}else {
				distance.put(gn.getCity(), Integer.MAX_VALUE);
			}
			visited.put(gn, false);	
		}
		
		for(int i = 0; i < Vertices - 1; i++) {
			GraphNode v = minimumDistanceNode(distance, visited, g);
			if(v.getCity().equals(dest.getCity())) {
				break;
			}
			visited.put(v, true);
			
			for(GraphNode w : g.getGraphList().get(v)) {
				if(distance.get(w.getCity()) > distance.get(v.getCity()) + w.getEdge()) {
					distance.put(w.getCity(), distance.get(v.getCity()) + w.getEdge());
					pred.put(w, v);
				}
			}

			
		}
		
		System.out.println("distance--------------------");
		for (String city : distance.keySet()) {
			
				System.out.println(" graphNode : " + city + " " + distance.get(city));
			
		}
		System.out.println();
		System.out.println("visited--------------------");
		for (GraphNode graphNode : visited.keySet()) {
			System.out.println(" graphNode : " + graphNode.getCity() + " " + visited.get(graphNode));
		}
		System.out.println();
		System.out.println("Pred--------------------");
		for (GraphNode graphNode : pred.keySet()) {
			System.out.println(" graphNode : " + graphNode.getCity() + " " + pred.get(graphNode).getCity());
		}
		return 0;
	}
	
	public static GraphNode minimumDistanceNode(Map<String, Integer> distance, Map<GraphNode, Boolean> visited,  Graph g) {
		GraphNode gn = new GraphNode();
		
		int min = Integer.MAX_VALUE;
		// initialize min value;
		for(GraphNode key: g.getGraphList().keySet()) {
			if(visited.get(key) == false && distance.get(key.getCity()) <= min) {
				min = distance.get(key.getCity());
				gn = key;
			}
		}
		
		return gn;
		
	}

}
