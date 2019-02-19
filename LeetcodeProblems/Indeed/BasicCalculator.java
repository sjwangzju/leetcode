package Indeed;

import java.util.Stack;

public class BasicCalculator {

    /**
     * time: O(N), space: O(1)
     * @param input
     * @return
     */
    public int calculate(String input) {
        input = input.replaceAll("\\s", "");
        int sign = 1;
        int tmp = 0;
        int res = 0;
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                tmp = ch - '0';
                while (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                    tmp = 10 * tmp + input.charAt(i + 1) - '0';
                    i++;
                }
            } else {
                switch (ch) {
                    case '+' :
                        res += sign * tmp;
                        sign = 1;
                        break;
                    case '-':
                        res += sign * tmp;
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
        if (tmp != 0) {
            res += sign * tmp;
        }

        return res;
    }

    public static void main(String[] args) {
        String input = "2 -  (4 +3)";
        System.out.println(new BasicCalculator().calculate(input));
    }
}
