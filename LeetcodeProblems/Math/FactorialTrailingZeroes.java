package Math;

/**
 * Created by sjwang on 04/30/2018.
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 */

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if(n < 5) return 0;
        return n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String args[]) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(15));
    }
}
