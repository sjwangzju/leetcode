package FullTime.Facebook;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {

    // Remove the minimum number of invalid parentheses
    // in order to make the input string valid. Return all possible results.
    //
    // Input: "(a)())()"
    // Output: ["(a)()()", "(a())()"]
    //
    // Thoughts:
    // 1. basic backtracking:
    //    use backtracking to try all possibilities (either keep / remove the current bracket)
    //    -> removeInvalidParenthesesI

    // 2. improve (backtracking with pruning):
    //    all valid expressions should have the same length -> find the number of invalid left/right parentheses
    //    -> removeInvalidParenthesesII


    // Solution 1: basic backtracking
    // time: O(2^N) - worst case: "((((((("
    // space: O(N)  - recursion stack
    /*******************************************************************************/
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


    // Solution 2: improve (backtracking with pruning)
    // time: better than previous, but still O(2^N) for worst case
    // space: O(N)
    /*******************************************************************************/
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


    // Simplify
    // 1. only need to return one valid result
    // 2. two passes
    //
    // Input: "(a)())()"
    // Output: ["(a)()()"]
    //
    // time: O(N), space: O(N)
    /*******************************************************************************/
    public String removeInvalidParenthesesIII(String s) {
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


    /*******************************************************************************/
    public void printI(String s) {
        List<String> res = new RemoveInvalidParentheses().removeInvalidParenthesesI(s);
        for (String str: res) {
            System.out.print(str + ", ");
        }
        System.out.println();
    }

    public void printII(String s) {
        List<String> res = new RemoveInvalidParentheses().removeInvalidParenthesesII(s);
        for (String str: res) {
            System.out.print(str + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        RemoveInvalidParentheses removeInvalidParentheses = new RemoveInvalidParentheses();
//        // test1
//        String s1 = "()))())";
//        removeInvalidParentheses.printII(s1);
//
//        // edge case
//        String s2 = "(((((((";
//        removeInvalidParentheses.printII(s2);


        System.out.println(removeInvalidParentheses.removeInvalidParenthesesIII("ab(a(c)fg)9)"));
        System.out.println(removeInvalidParentheses.removeInvalidParenthesesIII(")a(b)c()("));
        System.out.println(removeInvalidParentheses.removeInvalidParenthesesIII(")("));
        System.out.println(removeInvalidParentheses.removeInvalidParenthesesIII("a(b))"));
        System.out.println(removeInvalidParentheses.removeInvalidParenthesesIII("(a(c()b)"));
        System.out.println(removeInvalidParentheses.removeInvalidParenthesesIII("(a)b(c)d(e)f)(g)"));
    }
}
