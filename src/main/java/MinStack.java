package main.java;

import java.util.Stack;

public class MinStack {

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

		var minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		minStack.getMin(); // return -3
		minStack.pop();
		minStack.top(); // return 0
		minStack.getMin();
	}

	private Stack<MinStackNode> stackObject;

	private class MinStackNode {
		private int value;
		private int curMin;

		public MinStackNode(int val, int min) {
			value = val;
			curMin = min;
		}

		public int getValue() {
			return value;
		}

		public int getCurMin() {
			return curMin;
		}
	}

	public MinStack() {
		stackObject = new Stack<>();
	}

	public void push(int val) {
		int min = calculateNewMin(val);
		stackObject.push(new MinStackNode(val, min));
	}

	public void pop() {
		stackObject.pop();
	}

	public int top() {
		if (!stackObject.isEmpty()) {
			return stackObject.peek().getValue();
		}
		return 0;
	}

	public int getMin() {
		if (!stackObject.isEmpty()) {
			return stackObject.peek().getCurMin();
		}
		return 0;
	}

	public int calculateNewMin(int proposedMin) {
		if (!stackObject.isEmpty()) {
			int curMin = stackObject.peek().getCurMin();
			if (proposedMin < curMin) {
				return proposedMin;
			} else {
				return curMin;
			}
		}
		return proposedMin;
	}
}
