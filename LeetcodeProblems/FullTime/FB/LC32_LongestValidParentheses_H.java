package FullTime.FB;

import java.util.Stack;

/**
 * Stack
 *
 * time: O(N)
 * space: O(N)
 */
public class LC32_LongestValidParentheses_H {

    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')' && stack.peek() != -1 && s.charAt(stack.peek()) == '(') {
                stack.pop();
                max = Math.max(max, i - stack.peek());
            } else {
                stack.push(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(new LC32_LongestValidParentheses_H().longestValidParentheses(s));
    }
}
