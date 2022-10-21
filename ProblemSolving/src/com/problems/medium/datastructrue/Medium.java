package com.problems.medium.datastructrue;

public class Medium {
	public static void main (String [] args) {
		int [][] grid = {{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
		System.out.println(numEnclaves(grid));
	}
	
	public static int numEnclaves(int[][] grid) {
        int counter = 0;
 
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
               
                if(moveLeft(grid, i, j) && moveRight(grid, i, j) && moveDown(grid, i, j) && moveUp(grid, i, j)){
                    counter++;
                }
            }
        }
        return counter;
        
    }
    
    private static boolean moveLeft(int [][] grid, int x, int y){
        if(x < 0){
            return false;
        }
        
        if(grid[x][y] == 0){
            return false;
        } 
        
        if(grid[x][y] == 1){
            return true;
        }
        
        x = x -1;
        return moveLeft(grid, x, y);
    }
    
    private static boolean moveRight(int [][] grid, int x, int y){
        if(x >= grid.length){
            return false;
        }
        
        if(grid[x][y] == 0){
            return false;
        }
        
        if(grid[x][y] == 1){
            return true;
        }
        x = x + 1;
        return moveRight(grid, x, y);
    
    }
     private static boolean moveDown(int [][] grid, int x, int y){
        if(y >= grid[x].length){
            return false;
        }
        
        if(grid[x][y] == 0){
            return false;
        }
         
         if(grid[x][y] == 1){
            return true;
        }
         
        y = y + 1;
        return moveDown(grid, x, y);
    
     }
     private static boolean moveUp(int [][] grid, int x, int y){
        if(y < 0){
            return false;
        }
        
        if(grid[x][y] == 0){
            return false;
        }
         
         if(grid[x][y] == 1){
            return true;
        }
        y = y - 1;
       return moveUp(grid, x, y);
    
     }
	
}
