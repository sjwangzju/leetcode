package FullTime.Facebook;

import java.util.ArrayList;
import java.util.List;

public class aaaAddOperators {

    /**
     * Add Operators (simplified): only '+','-'
     *
     * Input: num = "123", target = 6
     * Output: ["1+2+3"]
     *
     * Thoughts:
     * 1. backtracking - try all possibilities: put (+,-) between every two operands
     * 2. edge cases:
     *    a. overflow: use a long type to store current result of the expression
     *    b. expression with leading '0': e.g. "01234" -> can't have "012" as an operand
     *
     * time: O(3^N) - 3 recursive paths
     * space: O(N) - recursion stack
     */

    List<String> res1 = new ArrayList<>();
    public List<String> addOperatorsI(String num, int target) {
        if (num == null || num.length() == 0) return res1;
        backtrackingI(new StringBuilder(), num, target, 0, 0);
        return res1;
    }

    public void backtrackingI(StringBuilder s, String num, int target, int i, long cur) {
        if (i == num.length()) {
            if (cur == target) {
                res1.add(s.toString());
            }
            return;
        }
        for (int j = i; j < num.length(); j++) {
            // skip expression with leading '0'
            if (j > i && num.charAt(i) == '0') break;
            long tmp = Long.parseLong(num.substring(i, j + 1));
            int len = s.length();

            if (i == 0) {
                backtrackingI(s.append(tmp), num, target, j + 1, tmp);
                s.setLength(len);
            } else {
                backtrackingI(s.append('+').append(tmp), num, target, j + 1, cur + tmp);
                s.setLength(len);
                backtrackingI(s.append('-').append(tmp), num, target, j + 1, cur - tmp);
                s.setLength(len);
            }
        }
    }



    /**
     * Add Operators: '+','-','*'
     *
     * Input: num = "123", target = 6
     * Output: ["1+2+3", "1*2*3"]
     *
     * Thoughts:
     * 1. backtracking - try all possibilities: put (+,-,*) between every two operands
     * 2. store the previous operand, reverse the effect of it on the expression value when meet '*'
     * 3. edge cases:
     *    a. overflow: use a long type to store current result of the expression
     *    b. expression with leading '0': e.g. "01234" -> can't have "012" as an operand
     *
     * time: O(4^N) - 4 recursive paths
     * space: O(N) - recursion stack
     *
     */

    List<String> res2 = new ArrayList<>();
    public List<String> addOperatorsII(String num, int target) {
        if (num == null || num.length() == 0) return res2;
        backtrackingII(new StringBuilder(), num, target, 0, 0, 0);
        return res2;
    }

    public void backtrackingII(StringBuilder s, String num, int target, int i, long cur, long prev) {
        if (i == num.length()) {
            if (target == cur) {
                res2.add(s.toString());
            }
            return;
        }
        for (int j = i; j < num.length(); j++) {
            // skip expression with leading '0'
            if (j > i && num.charAt(i) == '0') break;
            long tmp = Long.parseLong(num.substring(i, j + 1));
            int len = s.length();
            if (i == 0) {
                backtrackingII(s.append(tmp), num, target, j + 1, tmp, tmp);
                s.setLength(len);
            } else {
                backtrackingII(s.append("+").append(tmp), num, target, j + 1, cur + tmp, tmp);
                s.setLength(len);
                backtrackingII(s.append("-").append(tmp), num, target, j + 1, cur - tmp, -tmp);
                s.setLength(len);
                backtrackingII(s.append("*").append(tmp), num, target, j + 1, cur - prev + prev * tmp, prev * tmp);
                s.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
        // test1 (expression with leading '0')
        List<String> res1 = new aaaAddOperators().addOperatorsI("00123456", 5);
        for (String s: res1) {
            System.out.println(s);
        }

//        // test2 (overflow)
//        List<String> res2 = new ExpressionAddOperators().addOperatorsII("2147483648", 0);
//        for (String s: res2) {
//            System.out.println(s);
//        }
    }
}
