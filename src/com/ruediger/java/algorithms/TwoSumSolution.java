package com.ruediger.java.algorithms;
import java.util.HashMap;
import java.util.Map;

public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {

        // Iterate through the entire array
        // Create a map while iterating of the encountered values and their index
        // Check encountered values against the target differntial to see if they add up
        
    	// Create map
    	HashMap<Integer, Integer> passedNums = new HashMap<>();
    	
    	int difference;
    	
        for (int i = 0; i < nums.length; i++) {
        	
        	difference = target - nums[i];
        	
        	if (passedNums.get(difference) != null) {
        		return new int[] {passedNums.get(difference), i};
        	}
        	passedNums.put(nums[i], i);
        }
        
        // if there is not solution return [-1, 1]
        return new int[] {-1, 1};

    	
    	
    }

    public static void main(String[] args) {
        // Example input
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Create an instance of the TwoSumSolution class
        TwoSumSolution solution = new TwoSumSolution();

        // Call the twoSum method and print the result
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices of the two numbers: " + result[0] + ", " + result[1]);
    }
}