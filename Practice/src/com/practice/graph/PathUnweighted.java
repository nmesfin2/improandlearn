package com.practice.graph;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PathUnweighted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		constructGraph();
		
	}
	
	
	public static void constructGraph() {
		int numberOfVertices = 8;
		
		
		// adjListacency list for graph to store the edges
		ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(numberOfVertices);
		
		
		for(int i = 0; i < numberOfVertices; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 3);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 3, 7);
        addEdge(adjList, 4, 5);
        addEdge(adjList, 4, 6);
        addEdge(adjList, 4, 7);
        addEdge(adjList, 5, 6);
        addEdge(adjList, 6, 7);
        int source = 2, dest = 5;
        printShortestDistance(adjList, source, dest, numberOfVertices);
		
		
	}
	
	private static void printShortestDistance(ArrayList<ArrayList<Integer>> adjList, int s, int dest, int v) {
		int pred[] = new int[v];	//stores predecessor of i
		int dist[] = new int[v];	//stores distance of i from s
		
		  if (BFS(adjList, s, dest, v, pred, dist) == false) {
	            System.out.println("Given source and destination" + 
	                                         "are not connected");
	            return;
	        }
		  
		// LinkedList to store path
	        LinkedList<Integer> path = new LinkedList<Integer>();
	        int crawl = dest;
	        path.add(crawl);
	        while (pred[crawl] != -1) {
	            path.add(pred[crawl]);
	            crawl = pred[crawl];
	        }
	        
	        // Print distance
	        System.out.println("Shortest path length is: " + dist[dest]);
	 
	        // Print path
	        System.out.println("Path is ::");
	        for (int i = path.size() - 1; i >= 0; i--) {
	            System.out.print(path.get(i) + " ");
	        }
		
	}
	
	//function to form edge between two verticses
	// source and destination
	private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int i, int j) {
		adjList.get(i).add(j);
		adjList.get(j).add(i);
	}
	
	public static boolean BFS(ArrayList<ArrayList<Integer>> adjList, int src, int dest, int v, int pred[], int dist[]) {
		
		// stores the information wheter ith vertex is reached at least once in BFS
		boolean [] visited = new boolean[adjList.size()];
		
		for(int i = 0; i < visited.length; i++) {
			visited[i] = false;
			dist[i] = Integer.MAX_VALUE;
			pred[i] = -1;
		}
		
		// a queue to maintain queue of verices whose adjacency list is to be scanned.
		LinkedList<Integer> queue = new LinkedList<>();
		
		// put the source vertex on a queue of verices to visit.
		visited[src] = true;
		dist[src] = 0;
		queue.add(src);
		
		while(queue != null) {
			int temp = queue.remove();
			
			for(int i = 0; i < adjList.get(temp).size(); i++) {
				if(visited[adjList.get(temp).get(i)] == false) {
					dist[adjList.get(temp).get(i)] = dist[temp] + 1;
					pred[adjList.get(temp).get(i)] = temp;
					queue.add(adjList.get(temp).get(i));
					visited[adjList.get(temp).get(i)] = true;
					
					if(adjList.get(temp).get(i) == dest) {
						return true;
					}
				}
			}
		}
		
		return false;
	}

}
