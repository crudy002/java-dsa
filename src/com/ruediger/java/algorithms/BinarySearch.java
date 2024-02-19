package com.ruediger.java.algorithms;
import java.util.List;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class BinarySearch {

	// Binary search method (not implemented yet)
	public static int search(int[] nums, int target) {
		// Your binary search implementation goes here

		// Left and right pointers
		int left = 0;
		int right = nums.length;

		// Calculate the mid point
		int mid;

		while (left < right) {

			mid = left + (right - left) / 2;

			if (target == nums[mid]) {
				return mid;
			}

			else if (target < nums[mid]) {
				right = mid - 1;
			}

			else if (target > nums[mid]) {
				left = mid + 1;
			}
		}

		return left;
	}

	
    public int[] intersection(int[] nums1, int[] nums2) {
         
    	HashSet<Integer> set1 = new HashSet();
    	HashSet<Integer> set2 = new HashSet();
    	
    	for (int i = 0; i < nums1.length; i++) {
			set1.add(nums1[i]);
		}
    	
    	for (int i = 0; i < nums2.length; i++) {
			set2.add(nums2[i]);
		}
    	
    	set1.retainAll(set2); // Intersection
    	
    	int[] result = new int[set1.size()];
        int index = 0;
        for (int value : set1) {
        	result[index] = value;
        	index++;
        }
    	
    	return result;
    	
    }
	
	
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		int target1 = 5;
		int result1 = search(nums, target1);
		if (result1 != -1) {
			System.out.println("Element " + target1 + " found at index " + result1);
		} else {
			System.out.println("Element " + target1 + " not found in the array.");
		}

		int target2 = 1;
		int result2 = search(nums, target2);
		if (result2 != -1) {
			System.out.println("Element " + target2 + " found at index " + result2);
		} else {
			System.out.println("Element " + target2 + " not found in the array.");
		}

		int target3 = 9;
		int result3 = search(nums, target3);
		if (result3 != -1) {
			System.out.println("Element " + target3 + " found at index " + result3);
		} else {
			System.out.println("Element " + target3 + " not found in the array.");
		}

		int target4 = 0;
		int result4 = search(nums, target4);
		if (result4 != -1) {
			System.out.println("Element " + target4 + " found at index " + result4);
		} else {
			System.out.println("Element " + target4 + " not found in the array.");
		}

		int target5 = 10;
		int result5 = search(nums, target5);
		if (result5 != -1) {
			System.out.println("Element " + target5 + " found at index " + result5);
		} else {
			System.out.println("Element " + target5 + " not found in the array.");
		}
	}
}
