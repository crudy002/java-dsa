package com.ruediger.java.arraysAndHashing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class ProductOfArrayExceptSelf {
	
	public static void main(String[] args) {
		
		/*
			Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

			The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

			You must write an algorithm that runs in O(n) time and without using the division operation.

 

			Example 1:

			Input: nums = [1,2,3,4]
			Output: [24,12,8,6]
			Example 2:

			Input: nums = [-1,1,0,-3,3]
			Output: [0,0,9,0,0]
		 */
		
		
		int[] nums = new int[] {1,2,3,4};
		printArray(nums);
		productExceptSelf(nums);
		
		int[] nums2 = new int[] {-1,1,0,-3,3};
		printArray(nums2);
		productExceptSelf(nums2);
		// Begin solution here
		

		
		
	}
	
	public static void printArray(int[] toPrint) {
		for (int i = 0; i < toPrint.length; i++) {
			System.out.print(toPrint[i] + " ");
		}
		System.out.println();
	}
	//TODO 1) Implement constant space implementation by iterating twice and storing the prefix 2) Multiplying as you go to calculate the postfix
	public static int[] productExceptSelf(int[] nums) {
    	
    	int[] prefix = new int[nums.length];
    	
    	prefix[0] = nums[0];
    	for (int i = 1; i < prefix.length; i++) {
    		prefix[i] = prefix[i-1] * nums[i];
		}
    	
    	System.out.print("Prefix: ");
    	printArray(prefix);
    	
    	
    	int[] postfix = new int[nums.length];
    	
    	postfix[nums.length-1] = nums[nums.length-1];
    	for (int i = nums.length-2; i >= 0; i--) {
    		postfix[i] = postfix[i+1] * nums[i];
		}
    	
    	System.out.print("Postfix: ");
    	printArray(postfix);
    	
    	int[] result = new int[nums.length];
		
    	result[0] = postfix[1];
    	for (int i = 1; i < result.length-1; i++) {
    		result[i] = prefix[i-1] * postfix[i+1];
		}
    	result[nums.length-1] = prefix[nums.length-2];
    	
    	System.out.print("Result: ");
    	printArray(result);
    	
		return result;
	}

}
