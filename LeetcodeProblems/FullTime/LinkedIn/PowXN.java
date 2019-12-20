package FullTime.LinkedIn;

public class PowXN {

    // Solution1: recursive
    //
    // time: O(logN), space: O(logN)
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) return 1/x * myPow(1/x, -n-1);
        if (n % 2 == 0) {
            return myPow(x*x, n/2);
        }
        return x * myPow(x*x, n/2);
    }

    // Solution2: iterative
    //
    // time: O(logN), space: O(1)
    public double myPowII(double x, int n) {
        if (n == 0) return 1.0;
        if (n < 0) return 1/x * myPowII(1/x, -n-1);

        double res = 1.0, cur = x;
        while (n > 0) {
            if (n % 2 == 1) res *= cur;
            cur *= cur;
            n /= 2;
        }
        return res;
    }
}
