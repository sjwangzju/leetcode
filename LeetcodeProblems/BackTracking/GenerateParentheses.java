package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 09/18/2018.
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> L = new ArrayList<>();
        if (n == 0) return L;
        backTracking(L, "", 0, 0, n);
        return L;
    }

    public void backTracking(List<String> res, String cur, int open, int close, int n) {
        if (cur.length() == 2 * n) {
           res.add(cur);
           return;
        }
        if (open < n) {
            backTracking(res, cur + '(', open + 1, close, n);
        }
        if (open > close) {
            backTracking(res, cur + ')', open, close + 1, n);
        }
    }

    public static void main(String args[]) {
        List<String> result = new GenerateParentheses().generateParenthesis(3);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
