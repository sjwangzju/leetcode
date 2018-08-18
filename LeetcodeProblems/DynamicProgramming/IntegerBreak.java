package DynamicProgramming;

/**
 * Created by sjwang on 08/18/2018.
 *
 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers.
 * Return the maximum product you can get.
 *
 * Example 1:
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 * Example 2:
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {
    public int integerBreak(int n) {
        if(n <= 3) return n - 1;
        int[] res = new int[n + 1];
        res[1] = 1;
        for(int i = 2; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for(int j = 1; j <= i / 2; j++) {
                max = Math.max(Math.max(max, res[j] * res[i - j]), i);
            }
            res[i] = max;
        }
        return res[n];
    }
    public static void main(String args[]) {
        System.out.println(new IntegerBreak().integerBreak(15));
    }
}
