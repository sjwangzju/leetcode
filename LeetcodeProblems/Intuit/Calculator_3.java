package Intuit;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator_3 {

    // only contains digits , '+' , '-'
    // time: O(N)
    // space: O(1)
    /*************************************************************************************/
    public int calculatorI(String input) {
        int sign = 1;
        int res = 0;
        int tmp = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                tmp = ch - '0';
                while (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                    tmp = 10 * tmp + input.charAt(i + 1) - '0';
                    i++;
                }
            } else if (ch == '+') {
                res += sign * tmp;
                sign = 1;
                tmp = 0;
            } else {
                res += sign * tmp;
                sign = -1;
                tmp = 0;
            }
        }
        res += sign * tmp;
        return res;
    }


    // Follow up 1: contains digits , '+' , '-', '(', ')'
    // time: O(N)
    // space: O(1)
    /*************************************************************************************/
    public int calculatorII(String input) {
        int sign = 1;
        int res = 0;
        int tmp = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                tmp = ch - '0';
                while (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                    tmp = 10 * tmp + input.charAt(i + 1) - '0';
                    i++;
                }
            } else if (ch == '+') {
                res += sign * tmp;
                sign = 1;
                tmp = 0;
            } else if (ch == '-') {
                res += sign * tmp;
                sign = -1;
                tmp = 0;
            } else if (ch == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
                tmp = 0;
            } else {
                res += sign * tmp;
                res *= stack.pop();
                res += stack.pop();
                tmp = 0;
            }
        }
        res += sign * tmp;
        return res;
    }


    // Follow up 2: contains digits, variables , '+' , '-', '(', ')'
    // time: O(N)
    // space: O(1)
    /*************************************************************************************/
    public String calculatorIII(String input, Map<String, Integer> map) {
        int res = 0;
        int sign = 1;
        int tmp = 0;
        StringBuilder str = new StringBuilder();

        Stack<Integer> stack = new Stack<>();
        Stack<Map<String, Integer>> stack2 = new Stack<>();
        Map<String, Integer> var = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (Character.isDigit(ch)) {
                tmp = ch - '0';
                while (i + 1 < input.length() && Character.isDigit(input.charAt(i + 1))) {
                    tmp = 10 * tmp + input.charAt(i + 1) - '0';
                    i++;
                }

            } else if (Character.isLetter(ch)) {
                StringBuilder s = new StringBuilder();
                s.append(ch);
                while (i + 1 < input.length() && Character.isLetter(input.charAt(i + 1))) {
                    s.append(input.charAt(i + 1));
                    i++;
                }
                if (map.containsKey(s.toString())) {
                    tmp = map.get(s.toString());
                } else {
                    var.put(s.toString(), var.getOrDefault(s.toString(), 0) + sign);
                }

            } else {
                switch (ch) {
                    case '+':
                        res += sign * tmp;
                        sign = 1;
                        break;
                    case '-':
                        res += sign * tmp;
                        sign = -1;
                        break;
                    case '(':
                        stack2.push(var);
                        stack.push(res);
                        stack.push(sign);
                        sign = 1;
                        res = 0;
                        var = new HashMap<>();
                        break;
                    case ')':
                        res += sign * tmp;
                        int lastSign = stack.pop();
                        res *= lastSign;
                        res += stack.pop();
                        Map<String, Integer> lastVar = stack2.pop();
                        for (String s: var.keySet()) {
                            lastVar.put(s, lastVar.getOrDefault(s, 0) + lastSign * var.get(s));
                        }
                        var = lastVar;
                        break;
                }
                tmp = 0;
            }
        }
        res += sign * tmp;


        if (res != 0)
        str.append(res);
        for (String s: var.keySet()) {
            int freq = var.get(s);
            if (freq != 0) {
                if (freq > 0) str.append("+");
                if (freq < 0) str.append("-");
                if (Math.abs(freq) != 1) str.append(Math.abs(freq));
                str.append(s);
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
//        String input1 = "10+2-3+50";
//        System.out.println(new Calculator_3().calculatorI(input1));


//        String input2 = "1-(2+3)";
//        System.out.println(new Calculator_3().calculatorII(input2));


        Map<String, Integer> map = new HashMap<>();
        map.put("mn",1);
        map.put("b",2);
        map.put("c",3);
        String input3 = "2+b-c-(5-mn-p)+4+e";
        System.out.println(new Calculator_3().calculatorIII(input3, map));

    }
}
