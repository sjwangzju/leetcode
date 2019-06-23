package FullTime.FB;

import java.util.Stack;

/**
 * time: O(N), N is len of s
 * space: O(N)
 */
public class LC224_BasicCalculator_H {

    public int calculate(String s) {
        s = s.replaceAll("\\s", "");
        int res = 0, sign = 1, tmp = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                tmp = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    tmp = tmp * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            } else {
                switch (ch) {
                    case '+':
                        res += tmp * sign;
                        sign = 1;
                        break;
                    case '-':
                        res += tmp * sign;
                        sign = -1;
                        break;
                    case '(':
                        stack.push(res);
                        stack.push(sign);
                        res = 0;
                        sign = 1;
                        break;
                    case ')':
                        res += sign * tmp;
                        res *= stack.pop();
                        res += stack.pop();
                        break;
                }
                tmp = 0;
            }
        }
        res += sign * tmp;
        return res;
    }

    public static void main(String[] args) {
        String input = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new LC224_BasicCalculator_H().calculate(input));
    }
}
