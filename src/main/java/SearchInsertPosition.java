package main.java;
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
    	
    	// break it into two subarrays and do this over and over until you find target
    	// initialize pointers
    	// the pointers start on extremes of the array and work inwards to find the target,
    	// cutting down the search area in half each time
    	
    	int left = 0;
    	int right = nums.length - 1;
    	int mid;
    	
    	
    	// Once left has passed right and hasn't returned that means that the target isn;t there
    	while (left <= right) {
    		mid = left + (right-left) / 2;
    		
    		// Number in the middle is the target, return mid pos
    		if (nums[mid] == target) {
    			return mid;
    		}
    		
    		// Its to the right, and not mid so increment left by 1
    		else if (nums[mid] < target) {
    			left = mid + 1;
    		}
    		// Its to the left, and not mid so decrement right by 1
    		else if (nums[mid] > target) {
    			right = mid - 1;
    		}
    	}
    	
    	return -1;
    	

    }

    public static void main(String[] args) {
        SearchInsertPosition solution = new SearchInsertPosition();

        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = solution.searchInsert(nums, target);
        System.out.println("Result: " + result);
    }
}

