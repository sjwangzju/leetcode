package FullTime.FB;

/**
 * Corner case: dividend = -2^31, divisor = -1   =>  convert from int to long
 *
 * time: O(logN)
 * space: O(logN) - stack depth
 */
public class LC29_DivideTwoIntegers_M {

    public int divide(int dividend, int divisor) {
        int s1 = dividend < 0? -1: 1;
        int s2 = divisor < 0? -1: 1;
        int s = s1 * s2;

        long res = getResult(Math.abs((long)dividend), Math.abs((long)divisor));
        if (res > Integer.MAX_VALUE) {
            return s == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
        }
        return s * (int)res;
    }

    public long getResult(long m, long n) {
        if (m < n) return 0;
        long curSum = n, cnt = 1;
        while (m - curSum >= curSum) {
            curSum += curSum;
            cnt += cnt;
        }
        return cnt + getResult(m - curSum, n);
    }

    public static void main(String[] args) {
        int dividend = Integer.MIN_VALUE;
        int divisor = 1;
        System.out.println(new LC29_DivideTwoIntegers_M().divide(dividend, divisor));
    }
}
