package FB;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 *
 * backtracking with pruning
 *
 * time: O(2^N) - worst case: "((((((("
 * space: O(N) - maximum recursion depth  of N
 */
public class LC301_RemoveInvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> res = new HashSet<>();

        // num of left and right parenthesis to be removed
        int left = 0;
        int right = 0;

        for (char ch: s.toCharArray()) {
            switch (ch) {
                case '(':
                    left++;
                    break;
                case ')':
                    if (left > 0) {
                        left--;
                    } else {
                        right++;
                    }
            }
        }
        dfs(s, 0, new StringBuilder(), res, left, right, 0, 0);
        return new LinkedList<>(res);
    }

    /**
     *
     * @param s
     * @param index - current index
     * @param cur - current string
     * @param list - list of valid strings
     * @param left - num of left parenthesis to be removed
     * @param right - num of right parenthesis to be removed
     * @param lcnt - num of left parenthesis included
     * @param rcnt - num of right parenthesis included
     */
    public void dfs(String s, int index, StringBuilder cur, Set<String> list, int left, int right, int lcnt, int rcnt) {
        if (index == s.length()) {
            if (left == 0 && right == 0) {
                list.add(cur.toString());
            }
            return;
        }

        char ch = s.charAt(index);

        if (ch == '(' && left > 0) {
            dfs(s, index + 1, cur, list, left - 1, right, lcnt, rcnt);
        }
        if (ch == ')' && right > 0) {
            dfs(s, index + 1, cur, list, left, right - 1, lcnt, rcnt);
        }

        cur.append(ch);
        if (ch != '(' && ch != ')') {
            dfs(s, index + 1, cur, list, left, right, lcnt, rcnt);
        } else if (ch == '(') {
            dfs(s, index + 1, cur, list, left, right, lcnt + 1, rcnt);
        } else if (lcnt > rcnt){
            dfs(s, index + 1, cur, list, left, right, lcnt, rcnt + 1);
        }
        cur.deleteCharAt(cur.length() - 1);
    }

    public static void main(String[] args) {
        String s = "()())()";
        System.out.println(new LC301_RemoveInvalidParentheses().removeInvalidParentheses(s));
    }

}
