package FullTime.Facebook;

public class LongestValidParentheses {

    // Given a string containing just the characters '(' and ')',
    // find the length of the longest valid (well-formed) parentheses substring.
    //
    // Input: ")()())"
    // Output: 4
    // Explanation: The longest valid parentheses substring is "()()"
    //
    // 1. two passes
    //
    // time: O(N), space: O(1)
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0, left = 0, right = 0;

        // left to right
        // "())" -> 2
        // "(()" -> 0
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') left++;
            else right++;

            if (right > left) {
                left = 0;
                right = 0;
            } else if (right == left) {
                res = Math.max(res, left * 2);
            }
        }

        // right to left
        // "())" -> 0
        // "(()" -> 2
        left = 0; right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') right++;
            else left++;

            if (left > right) {
                left = 0;
                right = 0;
            } else if (right == left) {
                res = Math.max(res, left * 2);
            }
        }
        return res;
    }
}
