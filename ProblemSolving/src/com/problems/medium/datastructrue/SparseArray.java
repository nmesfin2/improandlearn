package com.problems.medium.datastructrue;

import java.util.HashMap;
import java.util.Map;

public class SparseArray {
	
	public static void main(String[] args) {
		String [] strings = {"aba","baba", "aba","xzxb"};
		String [] queries = {"aba","xzxb", "ab"};
		
		int [] result = matchingStrings(strings, queries);
		
		for(int i = 0; i < result.length; i++){
			System.out.println(result[i]);
		}
	}
	// Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
      int [] result = new int[queries.length];  
      Map<String, Integer> countingStringMap = countingStringMap(strings);  
      
      for(int i = 0; i < queries.length; i++){
          if(countingStringMap.get(queries[i]) == null ){
              result[i] = 0;

          }else{
              result[i] = countingStringMap.get(queries[i]);  
          }
      }
      
      return result;  

    }
    
    static Map<String, Integer> countingStringMap(String [] strings){
        Map<String, Integer> result = new HashMap<>();
        
        for(int i = 0; i < strings.length; i++){
            if(result.get(strings[i]) == null){
                result.put(strings[i], 1);
            }else{
                result.put(strings[i], result.get(strings[i]) + 1);    
            }   
        }
        return result;
    } 

}
