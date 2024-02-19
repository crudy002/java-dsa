package com.ruediger.java.algorithms;
public class MaxParenthesesScore {
    public static int maxScore(String input) {
        int maxScore = 0;
        int left = 0; // Left pointer starting at the beginning of the string.
        int right = input.length() - 1; // Right pointer starting at the end of the string.
        
        while (left < right) {
            char leftChar = input.charAt(left);
            char rightChar = input.charAt(right);
            
            // Found a pair of parentheses.
            if (leftChar == '(' && rightChar == ')') {
                maxScore += right - left; 
                System.out.println("Pair found: left=" + left + ", right=" + right + ", Score=" + (right- left));
                left++;
                right--;
            } else if (leftChar == ')') {
                // Move the left pointer to the right.
                left++;
            } else if (rightChar == '(') {
                // Move the right pointer to the left.
                right--;
            } else {
                // Neither character is a parenthesis, move both pointers.
                left++;
                right--;
            }
            
            System.out.println("Left pointer: " + left + ", Right pointer: " + right);
        }
        
        return maxScore;
    }
    
    public static void main(String[] args) {
        String input = "(()())";
        int maxScore = maxScore(input);
        System.out.println(input);
        System.out.println("Max Score: " + maxScore); // Output: Max Score: 6

        input = "()";
        maxScore = maxScore(input);
        System.out.println(input);
        System.out.println("Max Score: " + maxScore); // Output: Max Score: 1

        input = "(()(()))";
        maxScore = maxScore(input);
        System.out.println(input);
        System.out.println("Max Score: " + maxScore); // Output: Max Score: 14

        input = "(()))";
        maxScore = maxScore(input);
        System.out.println(input);
        System.out.println("Max Score: " + maxScore); // Output: Max Score: 6
    }
}
