package BinarySearch;

/**
 * Created by sjwang on 07/23/2018.
 *
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * Return the quotient after dividing dividend by divisor.
 * The integer division should truncate toward zero.
 *
 * Example 1:
 * Input: dividend = 10, divisor = 3
 * Output: 3
 *
 * Example 2:
 * Input: dividend = 7, divisor = -3
 * Output: -2
 *
 * Note:
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        int ne = 1, re;
        if(dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) ne = -1;
        long ldividend = Math.abs((long) dividend), ldivisor = Math.abs((long) divisor);
        if(ldividend < ldivisor) return 0;
        long lres = ldivide(ldividend, ldivisor);
        if(lres > Integer.MAX_VALUE){
            re = (ne == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else re = (int) (ne * lres);
        return re;
    }
    public long ldivide(long ldividend, long ldivisor) {
        if(ldividend < ldivisor) return 0;
        long sum = ldivisor, mul = 1;
        while((sum + sum) <= ldividend){
            sum += sum;
            mul += mul;
        }
        return mul + ldivide(ldividend - sum, ldivisor);
    }
    public static void main(String args[]){
        System.out.println(new DivideTwoIntegers().divide(-2147483648, -1));
    }
}
