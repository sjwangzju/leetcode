package Math;

/**
 * Created by sjwang on 30/04/2018.
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 * Example 2:
 * Input: 3
 * Output: False
 */

public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        if(c == 0) return true;
        for(int i = 1; i <= Math.sqrt(c); i++){
            int m = (int) Math.sqrt(c - i * i);
            if(Math.sqrt(c - i * i) - m == 0.0) return true;
        }
        return false;
    }

    public static void main(String args[]) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(61));
    }
}
