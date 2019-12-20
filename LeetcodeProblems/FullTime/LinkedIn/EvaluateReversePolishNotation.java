package FullTime.LinkedIn;

import java.util.Stack;

public class EvaluateReversePolishNotation {

    // Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    // Valid operators are +, -, *, /. Each operand may be an integer or another expression.
    //
    // Input: ["2", "1", "+", "3", "*"]
    // Output: 9
    // Explanation: ((2 + 1) * 3) = 9
    //
    // time: O(N), space: O(N)
    //
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token: tokens) {
            if (token.equals("+") || token.equals("-")
                    || token.equals("*") || token.equals("/")) {
                int n1 = stack.pop(), n2 = stack.pop();

                if (token.equals("+")) {
                    stack.push(n1 + n2);
                } else if (token.equals("-")) {
                    stack.push(n2 - n1);
                } else if (token.equals("*")) {
                    stack.push(n1 * n2);
                } else {
                    stack.push(n2 / n1);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
