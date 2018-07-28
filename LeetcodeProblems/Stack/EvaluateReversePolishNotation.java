package Stack;

import java.util.Stack;

/**
 * Created by sjwang on 07/28/2018.
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result
 * and there won't be any divide by zero operation.
 *
 * Example 1:
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 * Example 2:
 * Input: ["4", "13", "5", "/", "+"]
 * Output: 6
 * Explanation: (4 + (13 / 5)) = 6
 *
 * Example 3:
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22
 *
 * Explanation:
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < tokens.length; i++) {
            String str = tokens[i];
            switch (str) {
                case "+":
                    s.push(s.pop() + s.pop());
                    break;

                case "-":
                    s.push(- s.pop() + s.pop());
                    break;

                case "*":
                    s.push(s.pop() * s.pop());
                    break;

                case "/":
                    int b = s.pop();
                    s.push(s.pop() / b);
                    break;

                default:
                    s.push(Integer.valueOf(tokens[i]));
            }
        }
        return s.pop();
    }
    public static void main(String args[]){
        String[] str = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(str));
    }
}
