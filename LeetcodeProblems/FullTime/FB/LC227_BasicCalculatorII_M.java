package FullTime.FB;

import java.util.Stack;

/**
 * Stack: save numbers or intermediate results between '+' and '-'
 *
 * use prev operator
 *
 * time: O(N)
 * space: O(N)
 */
public class LC227_BasicCalculatorII_M {

    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        int res = 0, num = 0;
        char prevOp = '+';
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            }
            // corner case: i == s.length() - 1
            if (!Character.isDigit(ch) || i == s.length() - 1) {
                switch (prevOp) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                prevOp = ch;
                num = 0;
            }
        }
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(new LC227_BasicCalculatorII_M().calculate(s));
    }
}
