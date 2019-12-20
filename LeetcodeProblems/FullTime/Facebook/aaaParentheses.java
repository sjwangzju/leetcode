package FullTime.Facebook;

import java.util.*;

public class aaaParentheses {

    /**
     * Valid Parentheses
     *
     * Input: "()[]{}"
     * Output: true
     *
     * Input: "([)]"
     * Output: false
     *
     *  -> Return if the input is valid parentheses
     *  -> contains (),{},[]
     *
     *  Thoughts:
     *  1. stack
     *
     *  time: O(N), space: O(N)
     */
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


    /**
     * Longest Valid Parentheses
     *
     * Input: ")()())"
     * Output: 4
     * Explanation: The longest valid parentheses substring is "()()"
     *
     *  -> Return the length of longest valid parentheses
     *
     *  Thoughts:
     *  1. two passes
     *      a. left->right: count all valid "left pairs"   e.g. "())" -> 2
     *      b. right->left: count all valid "right pairs"  e.g. "(()" -> 2
     *
     *  time: O(N), space: O(1)
     */
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


    /**
     * Remove invalid parentheses (simplified)
     *
     * -> Only need to return one valid result (String)
     *
     * Input: "(a)())()"
     * Output: ["(a)()()"]
     *
     * Thoughts:
     * 1. two passes
     *      a. left->right: get all indexes of ')' to be deleted
     *      b. right->left: get all indexes of '(' to be deleted
     *
     * time: O(N), space: O(N)
     */
    public String removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) return "";
        int left = 0;
        // record the indexes of chars to be deleted
        boolean[] remove = new boolean[s.length()];

        // left to right
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) left--;
                else remove[i] = true;
            }
        }

        // right to left
        int right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (remove[i]) continue;
            char c = s.charAt(i);
            if (c == ')') {
                right++;
            } else if (c == '(') {
                if (right > 0) right--;
                else remove[i] = true;
            }
        }

        // get the result
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (remove[i]) continue;
            res.append(s.charAt(i));
        }
        return res.toString();
    }


    /**
     * Remove invalid parentheses
     *
     * -> Return all the possible results (List<String>)
     *
     * Input: "(a)())()"
     * Output: ["(a)()()", "(a())()"]
     *
     *
     * Thoughts:
     * 1. basic backtracking:
     *    use backtracking to try all possibilities (either keep / remove the current bracket)
     *    -> removeInvalidParenthesesI
     *
     * time: O(2^N) - worst case: "((((((("
     * space: O(N)  - recursion stack
     *
     *
     * 2. improve (backtracking with pruning):
     *    all valid expressions should have the same length -> find the number of invalid left/right parentheses
     *    -> removeInvalidParenthesesII
     */

    Set<String> res1 = new HashSet<>();
    int max = 0;

    public List<String> removeInvalidParenthesesI(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        backtrackingI(s, new StringBuilder(), 0, 0, 0);
        return new ArrayList<>(res1);
    }

    public void backtrackingI(String s, StringBuilder cur, int i, int lcnt, int rcnt) {
        if (rcnt > lcnt) return;
        if (i == s.length()) {
            if (lcnt == rcnt) {
                if (cur.length() < max) return;
                if (cur.length() > max) {
                    max = cur.length();
                    res1 = new HashSet<>();
                }
                res1.add(cur.toString());
            }
            return;
        }

        char c = s.charAt(i);
        // remove c
        if (c == '(') {
            backtrackingI(s, cur, i + 1, lcnt, rcnt);
        } else if (c == ')') {
            backtrackingI(s, cur, i + 1, lcnt, rcnt);
        }
        // append c
        cur.append(c);
        if (c == '(') {
            backtrackingI(s, cur, i + 1, lcnt + 1, rcnt);
        } else if (c == ')') {
            backtrackingI(s, cur, i + 1, lcnt, rcnt + 1);
        } else {
            backtrackingI(s, cur, i + 1, lcnt, rcnt);
        }
        cur.deleteCharAt(cur.length() - 1);
    }


    /**
     * Remove invalid parentheses
     *
     * -> Return all the possible results (List<String>)
     *
     * Thoughts:
     * 1. improve (backtracking with pruning):
     *    all valid expressions should have the same length -> find the number of invalid left/right parentheses
     *    -> removeInvalidParenthesesII
     *
     * time: better than previous, but still O(2^N) for worst case
     * space: O(N)
     */

    Set<String> res2 = new HashSet<>();

    public List<String> removeInvalidParenthesesII(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        int left = 0, right = 0;
        // count the num of '(' and ')' to be removed
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }
        backtrackingII(s, new StringBuilder(), 0, 0, 0, left, right);

        return new ArrayList<>(res2);
    }

    public void backtrackingII(String s, StringBuilder cur, int i, int lcnt, int rcnt, int left, int right) {
        if (rcnt > lcnt) return;
        if (i == s.length()) {
            if (left == 0 && right == 0) {
                res2.add(cur.toString());
            }
            return;
        }
        char c = s.charAt(i);
        // remove c
        if (c == '(' && left > 0) {
            backtrackingII(s, cur, i + 1, lcnt, rcnt, left - 1, right);
        } else if (c == ')' && right > 0) {
            backtrackingII(s, cur, i + 1, lcnt, rcnt, left, right - 1);
        }
        // append c
        cur.append(c);
        if (c == '(') {
            backtrackingII(s, cur, i + 1, lcnt + 1, rcnt, left, right);
        } else if (c == ')') {
            backtrackingII(s, cur, i + 1, lcnt, rcnt + 1, left, right);
        } else {
            backtrackingII(s, cur, i + 1, lcnt, rcnt, left, right);
        }
        cur.deleteCharAt(cur.length() - 1);
    }
}
