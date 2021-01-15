package com.learing.sorting;

public class SelectionSort {
	public static void main(String[] args) {
		int [] array = {7, 4, 6, 1, 3, 5, 8, 2};
		SelectionSorting(array);
		
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public static void SelectionSorting(int [] a) {
		selectionSortingHelper(a, a.length - 1);
	}
	
	private static void selectionSortingHelper(int [] a, int last) {
		if(last <= 0) {return;}
		
		int largest = a[0];
		int index = 0;
		
		for(int i = 0; i <= last; i++) {
			if(a[i] > largest) {
				largest = a[i];
				index = i;
			}
		}
		swap(a, index, last);
		selectionSortingHelper(a, last-1);
	}
	
	public static void swap(int a[], int i, int j) {
		int temp = a [i];
		a[i] = a[j];
		a[j] = temp;
	}

}


