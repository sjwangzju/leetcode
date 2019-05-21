package Intuit;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Calculator_3 {

    /*************************************************************************************/

    // only contains digits , '+' , '-'

    // time: O(N)
    // space: O(1)
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
                }
            }
        }
        if (tmp != 0) res += sign * tmp;
        return res;
    }

    /*************************************************************************************/

    // contains digits , '+' , '-', '(', ')'

    // time: O(N)
    // space: O(1)
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
                        stack.push(res);
                        stack.push(sign);
                        sign = 1;
                        res = 0;
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
        if (tmp != 0) res += sign * tmp;
        return res;
    }

    /*************************************************************************************/

    // contains digits, variables , '+' , '-', '(', ')'

    // time: O(N)
    // space: O(1)
    public String calculatorIII(String input, Map<String, Integer> map) {
        int res = 0;
        int sign = 1;
        int tmp = 0;
        String str = "";

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
                String s = ch + "";
                while (i + 1 < input.length() && Character.isLetter(input.charAt(i + 1))) {
                    s += input.charAt(i + 1);
                    i++;
                }
                if (map.containsKey(s)) {
                    tmp = map.get(s);
                } else {
                    var.put(s, var.getOrDefault(ch, 0) + sign);
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
                        for (String c: var.keySet()) {
                            lastVar.put(c, lastVar.getOrDefault(c, 0) + lastSign * var.get(c));
                        }
                        var = lastVar;
                        break;
                }
                tmp = 0;
            }
        }
        if (tmp != 0) res += sign * tmp;


        if (res != 0)
        str += res + "";
        for (String ch: var.keySet()) {
            int freq = var.get(ch);
            if (freq != 0) {
                if (freq > 0) str += "+";
                if (freq < 0) str += "-";
                if (Math.abs(freq) != 1) str += Math.abs(freq);
                str += ch;
            }
        }
        return str;
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
        String input3 = "2+b-c-(5-mn-p)+4";
        System.out.println(new Calculator_3().calculatorIII(input3, map));

    }
}
