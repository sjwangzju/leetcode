package Math;

/**
 * Created by sjwang on 05/16/2018.
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 *
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */

public class ReverseInteger {
    public int reverse(int x) {
        long sum = 0, mul = 1, temp = x, n = 1;
        while(x / 10 != 0){
            mul *= 10;
            x /= 10;
        }
        while(mul != 0){
            sum += mul * (temp % 10);
            if(sum >= Integer.MIN_VALUE && sum <= Integer.MAX_VALUE) {
                temp /= 10;
                mul /= 10;
            }
            else return 0;
        }
        return (int)(sum * n);
    }

    public static void main(String args[]){
        System.out.println(new ReverseInteger().reverse(1534236469));
    }
}
