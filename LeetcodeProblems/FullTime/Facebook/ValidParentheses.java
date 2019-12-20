package FullTime.Facebook;

import java.util.Stack;

public class ValidParentheses {

    // Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
    // determine if the input string is valid.
    //
    // Input: "()[]{}"
    // Output: true
    //
    // Input: "([)]"
    // Output: false
    //
    // 1. stack
    // time: O(N), space: O(N)
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();
            }
            else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') return false;
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
