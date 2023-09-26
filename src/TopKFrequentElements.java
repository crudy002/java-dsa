import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
	
	public static void main(String[] args) {
		
		/*
		 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
		 
		Example 1:

		Input: nums = [1,1,1,2,2,3], k = 2
		Output: [1,2]
		Example 2:

		Input: nums = [1], k = 1
		Output: [1]
		
		*/
		int[] nums = new int[] {1,1,1,2,2,3};
		int k = 2;
		topKFrequent(nums, k);
		// Begin solution here
		
		
		// Idea 1: Create a hashmap of the with the number of times something appears
		
		// Iterate over the array
		
		
	}
    public static int[] topKFrequent(int[] nums, int k) {
    	
    	
    	
    	// Step 1: Create a HashMap to store the frequency of each element.
    	HashMap<Integer, Integer> countMap = new HashMap<>();
    	
    	
    	for (int i = 0; i < nums.length; i++) {
    		countMap.put(nums[i], countMap.getOrDefault(nums[i], 0)+1);
		}
    	
    	// Step 2: Create a PriorityQueue (MinHeap) to store the elements based on their frequencies.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
        		
        	// Use a lambda expression to define a comparator
        	// Two input variables (num1, and num2)
        	// Get the difference between the two numbers value in count map
            (num1, num2) -> countMap.get(num1) - countMap.get(num2)
        
        );
        
        // Step 3: Iterate through the frequency map and add elements to the minHeap.
        for (int num : countMap.keySet()) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the least frequent element if the heap size exceeds k.
            }
        }
    	
    	System.out.println(countMap.toString());
        // Print the minHeap contents
        System.out.println("Contents of minHeap: " + minHeap);
    	
        // Step 4: Create the result array and add elements from the minHeap.
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = minHeap.poll();
        }

        return result;
    }

}
