import java.util.Stack;

public class ValidParentheses {
	
	
	/*
	 * Open brackets must be closed by the same type of brackets.
	 * Open brackets must be closed in the correct order.
	 * Every close bracket has a corresponding open bracket of the same type.
	 */
    public boolean isValid(String s) {
    	
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray())
        {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }
            else
            	return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses solution = new ValidParentheses();

        String s1 = "()";
        System.out.println("Is \"" + s1 + "\" valid? " + solution.isValid(s1));

        String s2 = "()[]{}";
        System.out.println("Is \"" + s2 + "\" valid? " + solution.isValid(s2));

        String s3 = "(]";
        System.out.println("Is \"" + s3 + "\" valid? " + solution.isValid(s3));
    }
}

