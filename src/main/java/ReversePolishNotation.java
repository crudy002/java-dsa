package main.java;
import java.util.Stack;

public class ReversePolishNotation {
	
	
    public static void main(String[] args) {

    	var input = new String[] {"2","1","+","3","*"};
    	//var input = new String[] {"4","13","+"};
    	System.out.println(evalRPN(input));
    	
    }
	

    public static int evalRPN(String[] tokens) {
    	
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                stack.add(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b - a);
            } else if (token.equals("*")) {
                stack.add(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                stack.add(b / a);
            } else {
                stack.add(Integer.parseInt(token));
            }
            
            System.out.println("Elements in Operator Stack (Bottom to Top):");
            for (Integer element : stack) {
                System.out.println(element);
            }
        }
        return stack.pop();
    }

}

