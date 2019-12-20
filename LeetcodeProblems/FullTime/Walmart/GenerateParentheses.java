package FullTime.Walmart;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(n, 0, 0, "");
        return res;
    }

    public void generate(int n, int left, int right, String s) {
        if (left == n && right == n) {
            res.add(s);
            return;
        }

        if (left < n) {
            generate(n, left + 1, right, s + "(");
        }
        if (left > right) {
            generate(n, left, right + 1, s + ")");
        }
    }
}
