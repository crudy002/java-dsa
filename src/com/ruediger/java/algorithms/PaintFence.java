package com.ruediger.java.algorithms;
import java.util.Arrays;
import java.util.Collections;

public class PaintFence {
    public int numWays(int n, int k) {
        // TODO: Implement the numWays method
    	
    	// Base case: if there are no posts return 0
        if (n == 0) {
            return 0;
        } 
        // If there is only 1 post then return the number of colors
        // Assuming that k would be 1 in this case
        else if (n == 1) {
            return k;
        }
        
        
        int[] array = new int[] {3, 4, 2, 10, 9};
        
        System.out.println("Original int array: " + Arrays.toString(array));
        Arrays.sort(array);
        System.out.println("Sorted int array: " + Arrays.toString(array));
        
        String[] arrayStr = new String[] {"banana", "Apple", "dartmototh", "Cherry"};
        
        System.out.println("Original String array: " + Arrays.toString(arrayStr));
        Arrays.sort(arrayStr, String.CASE_INSENSITIVE_ORDER);
        System.out.println("Sorted String array: " + Arrays.toString(arrayStr));
        Arrays.sort(arrayStr);
        System.out.println("Sorted String array: " + Arrays.toString(arrayStr));
        
        
        Arrays.sort(arrayStr, Collections.reverseOrder());
        System.out.println("Sorted String array: " + Arrays.toString(arrayStr));
        
        int sameColor = k; // Number of ways to paint first post with the same color
        int diffColor = k * (k - 1); // Number of ways to paint first post with different color
        
        for (int i = 2; i < n; i++) {
            int temp = diffColor;
            diffColor = (sameColor + diffColor) * (k - 1);
            sameColor = temp;
        }
        
        return sameColor + diffColor;
    }

    public static void main(String[] args) {
    	PaintFence solution = new PaintFence();

        int n1 = 3, k1 = 2;
        System.out.println("Number of ways for n = " + n1 + " and k = " + k1 + ": " + solution.numWays(n1, k1));

        int n2 = 4, k2 = 3;
        System.out.println("Number of ways for n = " + n2 + " and k = " + k2 + ": " + solution.numWays(n2, k2));

        // Add more test cases here
    }
}
