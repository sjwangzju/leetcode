package FullTime.Facebook;

public class DivideTwoIntegers {

    // Given two integers dividend and divisor,
    // divide two integers without using multiplication, division and mod operator.
    // Both dividend and divisor will be 32-bit signed integers.
    //
    // Input: dividend = 7, divisor = -3
    // Output: -2
    //
    // Thoughts:
    // 1. do division recursively
    // 2. edge case:
    //    a. -2^31 / -1 = 2 ^ 31
    //
    // time: O(logN), space: O(logN)
    public int divideI(int dividend, int divisor) {
        // edge case (division result overflows)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int sign = (dividend < 0) ^ (divisor < 0)? -1: 1;
        long res = dfs(Math.abs((long)dividend), Math.abs((long)divisor));

        return sign == 1? (int)res: (int)-res;
    }

    public long dfs(long dividend, long divisor) {
        if (dividend < divisor) return 0;

        long cnt = 1, tmp = divisor;
        // use long because (tmp + tmp) may overflow
        while (dividend >= tmp + tmp) {
            cnt += cnt;
            tmp += tmp;
        }
        return cnt + dfs(dividend - tmp, divisor);
    }

    public static void main(String[] args) {
        int res = new DivideTwoIntegers().divideI(2147483647, 1);
        System.out.println(res);
    }
}
