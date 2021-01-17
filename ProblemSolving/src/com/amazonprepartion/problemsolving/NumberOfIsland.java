/**
 * 
 */
package com.amazonprepartion.problemsolving;

/**
 * @author natna
 *
 */
public class NumberOfIsland {
	public static void main(String[] args) {
		int [][] m = {{1, 0, 0, 1},
					  {0, 0, 1, 0},
					  {0, 1, 0, 0},
					  {0, 1, 0, 1}};
		
		dfs(m);
	}
	
	public static void dfs(int [][] m) {
		boolean [][] visited = new boolean[m.length][m.length];
		int counter =0;
		// mark all unvisited
		for(int i = 0; i < visited.length; i++) {
			for(int j = 0; j < visited.length; j++) {
				visited[i][j] = false;
			}
		}
		
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m.length; j++) {
				if(visited[i][j] == false && m[i][j] == 1) {
					dfsHelper(m, visited, i, j);
					++counter;
				}
			}
		}
		
		System.out.println("counter : " + counter);
	}
	
	public static void dfsHelper(int [][] m, boolean [][] visited, int i, int j) {
		visited[i][j] = true;
		System.out.println("[" + i + ", " + j + "]");
		
		int [] rowArray = {-1, 0, 1, -1, -1, 0, 1, 1};
		int [] colArray = {-1, -1, -1, 0, 1, 1, 1, 0};
		for(int k = 0; k < 8; k++) {
			if(isSafe(m,i + rowArray[k], j + colArray[k], visited)) {
				dfsHelper(m, visited, i + rowArray[k], j + colArray[k]);
				System.out.println();
			}
			
		}
	}
	
	public static boolean isSafe(int [][]m, int i, int j, boolean [][] visited) {
		if(i >= 0 && i < m.length && j >= 0 && j <  m.length && m[i][j] == 1 && visited[i][j] == false) {
			return true;
		}
		return false;
	}
}
