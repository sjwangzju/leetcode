package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 10/07/2018.
 *
 * Given a string of numbers and operators, return all possible results from computing all the
 * different possible ways to group numbers and operators. The valid operators are +, - and *.
 *
 * Example 1:
 * Input: "2-1-1"
 * Output: [0, 2]
 * Explanation:
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 *
 * Example 2:
 * Input: "2*3-4*5"
 * Output: [-34, -14, -10, -10, 10]
 * Explanation:
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 */
public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        if (input == null || input.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                String sub1 = input.substring(0, i);
                String sub2 = input.substring(i + 1);
                List<Integer> l1 = diffWaysToCompute(sub1);
                List<Integer> l2 = diffWaysToCompute(sub2);
                for (Integer j : l1) {
                    for (Integer k : l2) {
                        int tmp = 0;
                        switch (ch){
                            case '+' : tmp = j + k; break;
                            case '-' : tmp = j - k; break;
                            case '*' : tmp = j * k; break;
                        }
                        res.add(tmp);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    public static void main(String args[]){
        String input = "2*3-4*5";
        List<Integer> l = new DifferentWaysToAddParentheses().diffWaysToCompute(input);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }
}
