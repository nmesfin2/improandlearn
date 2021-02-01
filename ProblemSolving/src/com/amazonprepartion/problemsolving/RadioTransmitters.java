package com.amazonprepartion.problemsolving;

public class RadioTransmitters {
	
	public static void main(String[] args) {
		int k = 2;
		int [] n = {7, 2, 4, 6, 5, 9, 12, 11};
		
		System.out.println(hackerlandRadioTransmitters(n, k));
	}
	
	// Complete the hackerlandRadioTransmitters function below.
    public static int hackerlandRadioTransmitters(int[] x, int k) {
    	
    	/* sort first using quick sort
    	 */
        quickSort(x);

        int i = 0;
        int numTransmitter =0;
        
        
        while(i < x.length){
        	
            numTransmitter++;
            int location = x[i] + k;
            
            // move i to right most house
            
            while(i < x.length && x[i] <= location){
                i++;
            }
            
            i--;
            // we put the stransmiter here;
            // at x[i]
            
            
            //now go to the right coverage.
            location = x[i] + k;
            while(i < x.length && x[i] <= location){
                i++;
            }
        }

        return numTransmitter;
    }
    
    public static void quickSort(int [] x) {
        int start = 0;
        int last = x.length - 1;        
        quickSortHelper(x, start, last);            
    }
    
    private static void quickSortHelper(int [] x, int start,int  last) {
    
        if( start < last) {
            // chose the pivot
            int pivot = partition(x, start, last);
            
            quickSortHelper(x, start, pivot - 1);
            quickSortHelper(x, pivot + 1, last);
        }
    }
    
    
    // selection method helps to select the pivot
    private static int partition(int [] x, int start,int  last) {
        int pivot = x[start];
        int firstUnknown = start + 1;
        int lastUnknown = last;
        
        //int pivotIndex = start;
        
        while(firstUnknown <= lastUnknown) {
            if(x[firstUnknown] >= pivot) {
                swap(x, firstUnknown, lastUnknown);
                lastUnknown--;
                
            }else {
                firstUnknown++;
            }
        }
        
        swap(x, start, lastUnknown);

        return lastUnknown;
    }
    
    
    // swapping places
    private static void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }
}
