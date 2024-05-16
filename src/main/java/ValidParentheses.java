package main.java;

import java.util.Stack; 

public class ValidParentheses {
	/*
	 * Open brackets must be closed by the same type of brackets.
	 * Open brackets must be closed in the correct order.
	 * Every close bracket has a corresponding open bracket of the same type.
	 */
    public boolean isValid(String s) {
 
    	// Create a stack data structure which acts as last in first out order (LIFO)
        Stack<Character> stack = new Stack<>();
        
        // Iterate over each character in the string
        for (Character c : s.toCharArray()) {
        	
        	// If the encountered character is an opening parentheses, bracket or brace
        	// then push it to the stack since a closed companion is expected to be added
        	// to the stack in the following iterations of the loop
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            
            // the three else if's will catch closing parentheses, brackets or braces
            // and check the following conditions:
            	// 1) Does the stack have something in it
            	// 2) Is that thing the corresponding open version of the cur character
            // if these conditions are met, pop the value so that the next pair can be exposed
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } 
            else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } 
            else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
            
            // If non of these conditions are met then its an invalid char or invalid order 
            else
            	return false;
        }
        return stack.isEmpty();
    }
}

