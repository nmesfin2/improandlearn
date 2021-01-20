package com.problems.easy;

public class PlusMinus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {-4, 3, -9, 0, 4, 1};
		
		plusMinus(arr);
	}
	
	// Complete the plusMinus function below.
    public static void plusMinus(int[] arr) {
        int positive = 0;
        int negative =0;
        int zero = 0;
        
        for(int i =0; i < arr.length; i++){
            if(arr[i] == 0){
                zero++;
            }
            
            if(arr[i] > 0){
                positive++;
            }
            
            if(arr[i] < 0){
                negative++;
            }
        }
        
        System.out.println(String.format("%.6f",(double)positive/arr.length));
        System.out.println(String.format("%.6f",(double)negative/arr.length));
        System.out.println(String.format("%.6f",(double)zero/arr.length));
    }


}
