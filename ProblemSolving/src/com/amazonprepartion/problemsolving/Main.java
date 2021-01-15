package com.amazonprepartion.problemsolving;



public class Main {
	public static void main(String [] args) {
		System.out.println("Hello from here");
		int []movie_duration= {90, 85, 75, 60, 120, 150, 125};
		int [] result = moviesOnFlight(movie_duration, 250);
		
		quickSort(movie_duration);
		
		for(int i = 0; i < movie_duration.length; i++) {
			System.out.println(movie_duration[i]);
		}
		
		System.out.println("result: " + result[0]);
		System.out.println("result: " + result[1]);
	}
	
	public static int [] moviesOnFlight(int [] movie_duration, int duration) {
		int result[] = new int[2];
		int longest = 0;
		int target = duration - 30;
		
		quickSort(movie_duration);
		
		int closestSum = 0;
		
		int i = 0;
		int j = movie_duration.length - 1;
		
		int counter = 2;
		while( i < j) {
			int sum = movie_duration[i] + movie_duration[j];
			if( sum > target) {
				j--;
			}else {
				if(sum == closestSum) {
					int currentLongestMovie = result[1];
					if(movie_duration[j] > currentLongestMovie) {
						result[0] = movie_duration[i];
						result[1] = movie_duration[j];
					}
				}else if(sum > closestSum) {
					closestSum = sum;
					result[0] = movie_duration[i];
					result[1] = movie_duration[j];
				}
				
				i++;
			}
		}
		
		return result;
		
//		int result[] = new int[2];
//		int longest = 0;
//		for (int i = 0; i < movie_duration.length; i++) {
//			for (int j = i + 1; j < movie_duration.length; j++) {
//				if(movie_duration[i] + movie_duration[j] <= duration-30) {
//					if(result[0] + result[1] < movie_duration[i] + movie_duration[j]) {
//						result[0] = movie_duration[i];
//						result[1] = movie_duration[j];
//					}
//				}
//			}
//		}
//		return result;
	}
	
	
	public static void quickSort(int [] movie_duration) {
		int start = 0;
		int last = movie_duration.length - 1;		
		quickSortHelper(movie_duration, start, last);			
	}
	
	private static void quickSortHelper(int [] movie_duration, int start,int  last) {
	
		if( start < last) {
			// chose the pivot
			int pivot = partition(movie_duration, start, last);
			
			quickSortHelper(movie_duration, start, pivot - 1);
			quickSortHelper(movie_duration, pivot + 1, last);
		}
	}
	
	
	// selection method helps to select the pivot
	private static int partition(int [] movie_duration, int start,int  last) {
		int pivot = movie_duration[start];
		int firstUnknown = start + 1;
		int lastUnknown = last;
		
		//int pivotIndex = start;
		
		while(firstUnknown <= lastUnknown) {
			if(movie_duration[firstUnknown] >= pivot) {
				swap(movie_duration, firstUnknown, lastUnknown);
				lastUnknown--;
				
			}else {
				firstUnknown++;
			}
		}
		
		swap(movie_duration, start, lastUnknown);

		return lastUnknown;
	}
	
	
	// swapping places
	private static void swap(int[] movie_duration, int i, int j) {
		int temp = movie_duration[i];
		movie_duration[i] = movie_duration[j];
		movie_duration[j] = temp;
	}

}
