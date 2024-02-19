package com.ruediger.java.dsa.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

	public static void main(String[] args) {

		/*
		 * Design a stack that supports push, pop, top, and retrieving the minimum
		 * element in constant time.
		 * 
		 * Implement the MinStack class:
		 * 
		 * MinStack() initializes the stack object. void push(int val) pushes the
		 * element val onto the stack. void pop() removes the element on the top of the
		 * stack. int top() gets the top element of the stack. int getMin() retrieves
		 * the minimum element in the stack. You must implement a solution with O(1)
		 * time complexity for each function.
		 * 
		 * 
		 * 
		 * Example 1:
		 * 
		 * Input ["MinStack","push","push","push","getMin","pop","top","getMin"]
		 * [[],[-2],[0],[-3],[],[],[],[]]
		 * 
		 * Output [null,null,null,null,-3,null,0,-2]
		 * 
		 * Explanation MinStack minStack = new MinStack(); minStack.push(-2);
		 * minStack.push(0); minStack.push(-3); minStack.getMin(); // return -3
		 * minStack.pop(); minStack.top(); // return 0 minStack.getMin(); // return -2
		 * 
		 * 
		 * Constraints:
		 * 
		 * -231 <= val <= 231 - 1 Methods pop, top and getMin operations will always be
		 * called on non-empty stacks. At most 3 * 104 calls will be made to push, pop,
		 * top, and getMin.
		 */
		GenerateParentheses genParenth = new GenerateParentheses();
		List<String> result = genParenth.generateParenthesis(1); 
		for (String combo : result) {
			System.out.println(combo);
		}
		
		result = genParenth.generateParenthesis(10); 
		for (String combo : result) {
			System.out.println(combo);
		}
		
		
		

	}

	private List<String> result;

	public List<String> generateParenthesis(int n) {

		// only add open parentheses if numOpen < n
		// only add closed parentheses if numClosed < numOpen
		// base case: numOpen == numClosed == n
		result = new ArrayList<String>();
		genParenthesesRecursively(n, 0, 0, new Stack<Character>());
		return result;

	}

	public void genParenthesesRecursively(int n, int numOpen, int numClosed, Stack<Character> stack) {
        if (numOpen == numClosed && numClosed == n) {
        	String temp = "";
        	for (char curChar : stack) {
        		temp = temp + curChar;
        	}
        	result.add(temp);
            return;
        }
        
        if (numOpen < n) {
        	stack.add('(');
        	genParenthesesRecursively(n, numOpen + 1, numClosed, stack);
        	stack.pop();
        }
        
        if (numClosed < numOpen) {
        	stack.add(')');
        	genParenthesesRecursively(n, numOpen, numClosed + 1, stack);
        	stack.pop();
        }
    }

}
