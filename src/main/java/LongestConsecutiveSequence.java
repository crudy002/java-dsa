package main.java;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		/*
		 * Given an unsorted array of integers nums,
		 * return the length of the longest consecutive elements sequence.
		 * 
		 * You must write an algorithm that runs in O(n) time.
		 * 
		 * Example 1:
		 * 
		 * Input: nums = [100,4,200,1,3,2]
		 * Output: 4
		 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
		 * 
		 * Example 2:
		 * 
		 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
		 * Output: 9
		 */

		
		int[] num1 = new int[]{100,4,200,1,3,2};
		
		
		
		//int result = longestConsecutiveBruteForce(num1);
		int result = longestConsecutive(num1);
		System.out.println(result);
		
		int[] num2 = new int[10];
		num2[0] = 0;
		num2[1] = 3;
		num2[2] = 7;
		num2[3] = 2;
		num2[4] = 5;
		num2[5] = 8;
		num2[6] = 4;
		num2[7] = 6;
		num2[8] = 0;
		num2[9] = 1;
		
		//result = longestConsecutiveBruteForce(num2);
		result = longestConsecutive(num2);
		System.out.println(result);
	}

	public static int longestConsecutive(int[] nums) {
		// Print array of ints caled nums
		System.out.println(Arrays.toString(nums));
		
		
		// Convert it to a set
		// Use the hashed set to check for left and right numbers in linear time
		var numsSet = new HashSet<Integer>();
		for (Integer integer : nums) {
			numsSet.add(integer);
		}
		
		// There is A left neighbor but NO right neighbor == start of sequence
		var sequenceStarter = new HashSet<Integer>();
		
		for (int i : numsSet) {
			
			//System.out.println("CurNum: " + i);
			
			// Start count if no left neighbor
			if (!numsSet.contains(i-1)) {
				sequenceStarter.add(i);
			}
		}
		
		int longestCount = 0;
		int curCount = 0;
		int temp;
		
		// Alternate to two loops is you could add the while iteration into the first loop with the same time complexity
		
		for (int i : sequenceStarter) {
			temp = i;
			while(numsSet.contains(temp)) {
				curCount++;
				temp++;
			}
			if(curCount > longestCount) {
				longestCount = curCount;
			}
			curCount = 0;
		}
		return longestCount;
	}
	
	
	// It's an unsorted array so, sort the array and then traverse and keep track of the longest sequence
	public static int longestConsecutiveBruteForce(int[] nums) {
		// Print array of ints caled nums
		//System.out.println(Arrays.toString(nums));
		
		if (nums.length == 0) {
			return 0;
		}
		
		// Arrays.sort takes nlogn time complexity
		// nums gets sorted in place
		Arrays.sort(nums);
		
		// Other sort option is bubble sort

//		for (int i = 0; i < nums.length - 1; i++) {
//			for (int j = 0; j < nums.length - i - 1; j++) {
//				if (nums[j] > nums[j + 1]) {
//					int temp = nums[j];
//					nums[j] = nums[j + 1];
//					nums[j + 1] = temp;
//				}
//			}
//		}
			
		
		int longestCount = 0;
		int curCount = 1;
		int prevValue = nums[0];
		for (int i : nums) {
			// Debug
			//System.out.println("Number: " + i);
			//System.out.println("Count: " + curCount);
			if (i == prevValue + 1)
				curCount += 1;
			else if (i == prevValue)
				continue;
			else {
				if(curCount > longestCount) {
					longestCount = curCount;
				}
				curCount = 1;
			}
				
			prevValue = i;
		}
		
		if(curCount > longestCount) {
			longestCount = curCount;
		}
	
		return longestCount;
	}
	
	

}
