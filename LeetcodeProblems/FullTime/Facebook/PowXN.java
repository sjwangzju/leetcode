package FullTime.Facebook;

public class PowXN {

    // Implement pow(x, n), which calculates x raised to the power n (xn).
    //
    // Input: 2.00000, 10
    // Output: 1024.00000
    //
    // Input: 2.00000, -2
    // Output: 0.25000
    // Explanation: 2-2 = 1/22 = 1/4 = 0.25
    //
    // Solution1: recursive
    // time: O(logN), space: O(logN)
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) return 1/x * myPow(1/x, -n-1);
        if (n % 2 == 0) {
            return myPow(x*x, n / 2);
        }
        return x * myPow(x*x, n / 2);
    }

    // Solution2: iterative
    // time: O(logN), space: O(1)
    public double myPowII(double x, int n) {
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        double res = 1.0, cur = x;
        for (int i = n; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res *= cur;
            }
            cur *= cur;
        }
        return res;
    }
}
