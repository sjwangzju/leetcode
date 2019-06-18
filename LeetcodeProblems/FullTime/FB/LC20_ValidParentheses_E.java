package FullTime.FB;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Stack
 *
 * time: O(N)
 * space: O(N)
 */
public class LC20_ValidParentheses_E {

    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        List<Character> open = Arrays.asList('{','(','[');
        List<Character> close = Arrays.asList('}',')',']');

        for (char ch: s.toCharArray()) {
            if (close.contains(ch) && !stack.isEmpty()
                    && open.indexOf(stack.peek()) == close.indexOf(ch)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{()}[]";
        System.out.println(new LC20_ValidParentheses_E().isValid(s));
    }
}
