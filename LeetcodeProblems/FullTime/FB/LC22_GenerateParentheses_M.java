package FullTime.FB;

import java.util.LinkedList;
import java.util.List;

/**
 * backtracking
 *
 * time: O(2^N)
 * space: O()
 */
public class LC22_GenerateParentheses_M {

    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backtracking(res, new StringBuilder(), n, n);
        return res;
    }

    // l - num of open parenthesis left, r - num of closed parenthesis left
    public void backtracking(List<String> res, StringBuilder cur, int l, int r) {
        if (r == 0) {
            res.add(cur.toString());
            return;
        }
        if (l > 0) {
            backtracking(res, cur.append("("), l - 1, r);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (r > l) {
            backtracking(res, cur.append(")"), l, r - 1);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> list = new LC22_GenerateParentheses_M().generateParenthesis(1);
        for (String s: list) {
            System.out.println(s);
        }
    }
}
