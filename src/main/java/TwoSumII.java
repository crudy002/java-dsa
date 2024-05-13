package main.java;

import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class TwoSumII {

	public static void main(String[] args) {

		/*
		 * Given a 1-indexed array of integers numbers that is already sorted in
		 * non-decreasing order, find two numbers such that they add up to a specific
		 * target number. Let these two numbers be numbers[index1] and numbers[index2]
		 * where 1 <= index1 < index2 < numbers.length.
		 * 
		 * Return the indices of the two numbers, index1 and index2, added by one as an
		 * integer array [index1, index2] of length 2.
		 * 
		 * The tests are generated such that there is exactly one solution. You may not
		 * use the same element twice.
		 * 
		 * Your solution must use only constant extra space.
		 * 
		 * 
		 * 
		 * Example 1:
		 * 
		 * Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation: The sum
		 * of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2]. Example
		 * 2:
		 * 
		 * Input: numbers = [2,3,4], target = 6 Output: [1,3] Explanation: The sum of 2
		 * and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3]. Example 3:
		 * 
		 * Input: numbers = [-1,0], target = -1 Output: [1,2] Explanation: The sum of -1
		 * and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
		 * 
		 * 
		 */

		var input = new int[] { 2, 7, 11, 15 };
		var target = 9;

		System.out.println("Input: " + Arrays.toString(input));
		System.out.println("Target: " + target);

		// var result = twoSum(input, target);
		var result = twoSumTwoPointer(input, target);

		System.out.println(Arrays.toString(result));
		System.out.println();

		input = new int[] { 2, 3, 4 };
		target = 6;

		System.out.println("Input: " + Arrays.toString(input));
		System.out.println("Target: " + target);

		// result = twoSum(input, target);
		result = twoSumTwoPointer(input, target);

		System.out.println(Arrays.toString(result));
		System.out.println();

		input = new int[] {0,0,3,4};
		target = 0;

		// result = twoSum(input, target);
		result = twoSumTwoPointer(input, target);

		System.out.println("Input: " + Arrays.toString(input));
		System.out.println("Target: " + target);

		System.out.println(Arrays.toString(result));
		System.out.println("Should be : [1, 2]");
		System.out.println();
	}


	public static int[] twoSum(int[] numbers, int target) {
		// Iterate through the array of numbers
		// i will visit every number in the array
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i; j < numbers.length; j++) {
				if (numbers[i] + numbers[j] == target) {
					return new int[] { i + 1, j + 1 };
				}
			}
		}
		return null;
	}
	
	public static int[] twoSumTwoPointer(int[] numbers, int target) {
		// Iterate through the array of numbers
		// i will visit every number in the array
		
		var forwardIndex = 0;
		var reverseIndex = numbers.length-1;
		var calculatedSum = 0;
		while (forwardIndex < reverseIndex) {
			System.out.println(numbers[forwardIndex]);
			System.out.println(numbers[reverseIndex]);
			calculatedSum = numbers[forwardIndex] + numbers[reverseIndex];
			if (calculatedSum == target) {
				return new int[] { forwardIndex + 1, reverseIndex + 1 };
			}
			else if (calculatedSum < target) {
				forwardIndex++;
			}
			else if (calculatedSum > target) {
				reverseIndex--;
			}
		}
		return null;
	}

	public static int[] twoSumHash(int[] numbers, int target) {

		var numberMap = new HashMap<Integer, Integer>();
		// Iterate through the array of numbers
		// i will visit every number in the array
		for (int i = 0; i < numbers.length; i++) {
			numberMap.put(numbers[i], i);
		}

		var diff = 0;
		var result = new int[2];
		for (int i = 0; i < numbers.length; i++) {
			diff = target - numbers[i];
			if (numberMap.containsKey(diff)) {
				result[0] = numberMap.get(diff) + 1;
				result[1] = i + 1;
				Arrays.sort(result);
				return result;
			}
		}
		return result;
	}

}
