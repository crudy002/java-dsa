package main.java;

public class TraversingArrays {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        String str = "Hello";

        System.out.println("Using For Loop:");
        traverseArrayUsingForLoop(nums);
        traverseStringUsingForLoop(str);

        System.out.println("\nUsing Enhanced For Loop:");
        traverseArrayUsingEnhancedForLoop(nums);
        traverseStringUsingEnhancedForLoop(str);

        System.out.println("\nUsing While Loop:");
        traverseArrayUsingWhileLoop(nums);
        traverseStringUsingWhileLoop(str);

        System.out.println("\nUsing Two Pointers:");
        traverseArrayUsingTwoPointers(nums);

        System.out.println("\nUsing Recursion:");
        traverseStringUsingRecursion(str, 0);
    }

    public static void traverseArrayUsingForLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void traverseStringUsingForLoop(String str) {
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }
    }

    public static void traverseArrayUsingEnhancedForLoop(int[] nums) {
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void traverseStringUsingEnhancedForLoop(String str) {
        for (char c : str.toCharArray()) {
            System.out.println(c);
        }
    }

    public static void traverseArrayUsingWhileLoop(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            System.out.println(nums[i]);
            i++;
        }
    }

    public static void traverseStringUsingWhileLoop(String str) {
        int i = 0;
        while (i < str.length()) {
            System.out.println(str.charAt(i));
            i++;
        }
    }

    public static void traverseArrayUsingTwoPointers(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            System.out.println(nums[left]);
            System.out.println(nums[right]);
            left++;
            right--;
        }
    }

    public static void traverseStringUsingRecursion(String str, int index) {
        if (index == str.length()) {
            return;
        }
        System.out.println(str.charAt(index));
        traverseStringUsingRecursion(str, index + 1);
    }
}

