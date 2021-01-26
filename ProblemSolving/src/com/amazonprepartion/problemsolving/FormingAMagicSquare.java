package com.amazonprepartion.problemsolving;

public class FormingAMagicSquare {
	 // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] s) {
        int [][] ms = magicSquareThreeByThree();
        horizontalMirror(ms);
        return 0;
    }
    
    //horizontal mirror
    static int [][] horizontalMirror(int [][] s){
        int [][] result = new int [3][3];
        
        int counter = 0;
        for(int i = 2; i >= 0; i--){
            for(int j = 0; j < 3; j++){
                result[i][counter] = s[i][counter];
                counter++;
            }
            counter =0;
        }
        
        for(int k = 0; k < 3; k++){
            for(int m = 0; m < 3; m++ ){
                System.out.println(result[k][m]);
            }
        }
        return result;
    }
    // mirror image
    static int [][] verticalMirrorImage(int [][]s){
        int [][] result = new int [3][3];
        
        int counter = 0;
        for(int i = 0; i < 3; i++){
            for(int j = 2; j >= 0; j--){
                result[i][j] = s[i][counter];
                counter++;
            }
            counter = 0;
        }
        
        for(int k = 0; k < 3; k++){
            for(int m = 0; m < 3; m++ ){
                System.out.println(result[k][m]);
            }
        }
        return result;
    }
    // magic square for 3 X 3
    static int [][] magicSquareThreeByThree(){
        int [][] result = new int [3][3];
        boolean [][] visited = new boolean [3][3];
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++ ){
                visited[i][j] = false;
            }
        }
        
        result[0][1] = 1;
        visited[0][1] = true;
        int i = 0;
        int j = 1;
        
        for(int z = 2; z <= 9; z++){
           int tempI = i;
           int tempJ = j;
           i = (i - 1) < 0 ? 2: (i - 1);
           j = (j + 1) > 2 ? 0 : (j + 1);
           
        
           System.out.println("I AND j: " + i +  " " + j );
           if(visited[i][j] == true){
               
               j = tempJ;
               i = (tempI + 1)  > 2 ? 0 : (tempI + 1);
               result[i][j] = z;
               visited[i][j] = true;
           }else{
               result[i][j] = z;
               visited[i][j] = true;
           }
            
            System.out.println("I AND j: " + i +  " " + j );
            System.out.println(result[i][j]);
        }
        
        
        
        return result;
    }
}
