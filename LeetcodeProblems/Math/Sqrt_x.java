package Math;

/**
 * Created by sjwang on 05/16/2018.
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 * Input: 4
 * Output: 2
 *
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */

public class Sqrt_x {
    public int mySqrt(int x) {
        int i = 0;
        while(x > 0){
            x -= 2 * (i++) + 1;
        }
        if(x == 0) return i;
        return i - 1;
    }

    public static void main(String args[]){
        System.out.println(new Sqrt_x().mySqrt(64));
    }
}
