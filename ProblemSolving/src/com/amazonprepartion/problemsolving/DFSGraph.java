package com.amazonprepartion.problemsolving;

public class DFSGraph {
	public static void main(String[] args) {
		int [][] m = {{0, 0, 0, 0},
					  {0, 1, 1, 0},
					  {0, 1, 1, 0},
					  {0, 0, 0, 0}};
		
		dfs(m);
	}
	
	public static void dfs(int [][] m) {
		boolean [][] visited = new boolean[m.length][m.length];
		
		// mark all unvisited
		for(int i = 0; i < visited.length; i++) {
			for(int j = 0; j < visited.length; j++) {
				visited[i][j] = false;
			}
		}
		//System.out.println(visited.length);
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m.length; j++) {
				if(visited[i][j] == false && m[i][j] == 1) {
					dfsHelper(m, visited, i, j);
					System.out.println();
				}
			}
		}
	}
	
	public static void dfsHelper(int [][] m, boolean [][] visited, int i, int j) {
		visited[i][j] = true;
		System.out.println("[" + i + ", " + j + "]");
		
		for(int k = 0; k < m[i].length; k++) {
			if(visited[i][k] == false && m[i][k] == 1) {
				dfsHelper(m, visited, i, k);
			}
		}
	}
}
