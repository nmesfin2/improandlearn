package com.amazonprepartion.problemsolving;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiveStartSeller {
	public static void main(String[] args) {

		List<Integer> b = new ArrayList<Integer>();
		b.add(2);
		b.add(2);
		
		List<Integer> c = new ArrayList<Integer>();
		c.add(3);
		c.add(6);
		
		List<Integer> a = new ArrayList<Integer>();
		a.add(4);
		a.add(4);
		
		List<Integer> e = new ArrayList<Integer>();
		e.add(1);
		e.add(2);
		
		
		List<List<Integer>> productRatings = new ArrayList<>();
		productRatings.add(e);
		productRatings.add(a);

		productRatings.add(c);
		productRatings.add(b);

		
		
		System.out.println(fiveStarReview(productRatings, 77));
		
		for(List<Integer>productRating: productRatings) {
			System.out.println(productRating.get(0) + " " + productRating.get(1));
			System.out.println();
		}
	}
	
	public static double currentPercentage(List<List<Integer>> productRatings) {
		double currentP = 0;
		
		double sum = 0;
		for(List<Integer> pRating: productRatings) {
			sum += ((double)pRating.get(0)/(double)pRating.get(1));
		}
		
		currentP = (sum/productRatings.size()) * 100;
		return currentP;
	}
	
	

	public static int fiveStarReview(List<List<Integer>> productRatings, int ratingsThreshold) {
		//List<List<Integer>> productRatings = productRatings;
		
		// initial percentage
		double currPercentage = currentPercentage(productRatings);
		
		// keep track of the number of needed five star for each product
		Map<Integer, Integer> counterMap = new HashMap<>();

		// while the current percentage is less than the threshold.
		// keep adding 1 five star review to the product that bumps up the current percentage
		// with highest margin
		while(currPercentage < ratingsThreshold) {
			
			// add 1 five star to the first index;
			int lastHighestIndex = 0;
			int highestBumpIndex = 0;
			int iElement = productRatings.get(0).get(0) + 1;
			int jElement = productRatings.get(0).get(1) + 1;
			productRatings.get(0).set(0, iElement);
			productRatings.get(0).set(1, jElement);
			
			double cp = currentPercentage(productRatings);	// calculate the current percentage
			
			if(currPercentage < cp) {
				currPercentage = cp;		// make the current percentage the highest.
			}
			
			for(int i = 1; i < productRatings.size(); i++) {
				if(cp >= ratingsThreshold) {
					break;
				}
				

				productRatings.get(lastHighestIndex).set(0, productRatings.get(lastHighestIndex).get(0) - 1);
				productRatings.get(lastHighestIndex).set(1, productRatings.get(lastHighestIndex).get(1) - 1);
				
				 iElement = productRatings.get(i).get(0) + 1;
				 jElement = productRatings.get(i).get(1) + 1;
				 productRatings.get(i).set(0, iElement);
				 productRatings.get(i).set(1, jElement);
				
				cp = currentPercentage(productRatings);
				
				if(currPercentage < cp) {
					currPercentage = cp;
					highestBumpIndex = i;
					lastHighestIndex = i;
					
				}else {
					lastHighestIndex = i;
				}
				
			}
			
			if(counterMap.get(highestBumpIndex) == null ) {
				productRatings.get(highestBumpIndex).set(0, productRatings.get(highestBumpIndex).get(0) + 1);
				productRatings.get(highestBumpIndex).set(1, productRatings.get(highestBumpIndex).get(1) + 1);
				productRatings.get(lastHighestIndex).set(0, productRatings.get(lastHighestIndex).get(0) - 1);
				productRatings.get(lastHighestIndex).set(1, productRatings.get(lastHighestIndex).get(1) - 1);
				counterMap.put(highestBumpIndex,1);
				
			}else {
				productRatings.get(highestBumpIndex).set(0, productRatings.get(highestBumpIndex).get(0) + 1);
				productRatings.get(highestBumpIndex).set( 1, productRatings.get(highestBumpIndex).get(1) + 1);
				productRatings.get(lastHighestIndex).set(0, productRatings.get(lastHighestIndex).get(0) - 1);
				productRatings.get(lastHighestIndex).set(1, productRatings.get(lastHighestIndex).get(1) - 1);
				counterMap.put(highestBumpIndex, counterMap.get(highestBumpIndex) + 1);
			}
			
		}
		
		int result = counter(counterMap);
		return result;
	}
	
	public static int counter(Map<Integer, Integer> counterMap) {
		int sum = 0;
		for(Integer key: counterMap.keySet()) {
			sum += counterMap.get(key);
		}
		
		return sum;
	}

}
