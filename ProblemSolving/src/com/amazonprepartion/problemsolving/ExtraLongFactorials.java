package com.amazonprepartion.problemsolving;

import java.math.BigInteger;

public class ExtraLongFactorials {
	public static void main(String [] args) {
		extraLongFactorials(25);
	}

	 // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {

        BigInteger bI = new BigInteger("1");
        
        for(int i = 2; i <= n; i++){
            bI = bI.multiply(BigInteger.valueOf(i));
        }
        
        System.out.println(bI);
    }
}
