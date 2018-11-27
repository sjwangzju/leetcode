package Airbnb;

import java.util.Stack;

/**
 * similar to lc224, lc227
 *
 * s = s.replaceAll("\\s", "") -- remove all the spaces and tabs in string s
 */
public class BasicCalculator_7 {

    /**
     * lc224 -- calculator with ( ) + - and positive numbers
     * @param input
     * @return
     */
    public int calculatorI(String input) {
        input = input.replaceAll("\\s", "");

        // stack is used to save the res and sign before each (
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int res = 0;
        int sign = 1;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                number = ch - '0';
                while (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                    number = number * 10 + input.charAt(i + 1) - '0';
                    i++;
                }
            } else {
                switch (ch) {
                    case '+':
                        res += sign * number;
                        sign = 1; break;
                    case '-':
                        res += sign * number;
                        sign = -1; break;
                    case '(':
                        stack.push(res);
                        stack.push(sign);
                        res = 0;
                        sign = 1; break;
                    case ')':
                        res += sign * number;
                        res *= stack.pop();
                        res += stack.pop(); break;
                }
                number = 0;
            }
        }
        
        // don't forget the last number
        if (number != 0) {
            res += sign * number;
        }
        return res;
    }

    /**
     * lc227 -- calculator with + - * / and positive numbers
     * @param input
     * @return
     */
    public int calculatorII(String input) {
        input = input.replaceAll("\\s", "");

        // stack is used to save the value between + and - . Try to integrate the part that contains * or /
        // e.g. 1 + (2 * 3 / 7) - 5
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int res = 0;
        int number = 0;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                number = input.charAt(i) - '0';
                while (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                    number = number * 10 + input.charAt(i + 1) - '0';
                    i++;
                }
            }
            if (!Character.isDigit(input.charAt(i)) || i == input.length() - 1) {
                if (sign == '+') stack.push(number);
                if (sign == '-') stack.push(-number);
                if (sign == '*') stack.push(stack.pop() * number);
                if (sign == '/') stack.push(stack.pop() / number);
                sign = input.charAt(i);
                number = 0;
            }
        }

        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String input1 = " 5 +   6 - (12+ 2 )- 1   ";
        String input2 = "3 - 5 * 2 / 3 +  1";
        int res = new BasicCalculator_7().calculatorI(input1);
        System.out.println(res);
    }
}
