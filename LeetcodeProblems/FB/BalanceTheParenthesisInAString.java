package FB;

import java.util.Stack;

public class BalanceTheParenthesisInAString {

    /**
     * stack - time: O(N), space: O(N)
     * @param s
     * @return
     */
    public String removeInvalidParenthesis(String s) {
        StringBuilder res = new StringBuilder();
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ')') {
                if (right < left) {
                    stack.push(cur);
                    right++;
                }
            } else {
                if (cur == '(') {
                    left++;
                }
                stack.push(cur);
            }
        }

        int cnt = 0;
        int r = 0;
        while(!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '(') {
                if (cnt < r) {
                    res.insert(0, top);
                    cnt++;
                }
            } else {
                if (top == ')') {
                    r++;
                }
                res.insert(0, top);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "(a)())()";
        String res = new BalanceTheParenthesisInAString().removeInvalidParenthesis(s);
        System.out.println(res);
    }
}
