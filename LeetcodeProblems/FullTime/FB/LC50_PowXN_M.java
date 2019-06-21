package FullTime.FB;

public class LC50_PowXN_M {

    // time: O(logn)
    // space: O(logn)
    public double myPowI(double x, int n) {
        if (n == 0) return 1;
        if (n < 0) {
            return 1/x * myPowI(1/x, -n-1);
        }
        if (n % 2 == 0) {
            return myPowI(x * x, n/2);
        }
        return x * myPowI(x * x, n/2);
    }

    // time: O(logn)
    // space: O(1)
    public double myPowII(double x, int n) {
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1/x;
        }
        double res = 1;
        double product = x;
        for (long i = N; i > 0; i /= 2) {
            if (i % 2 == 1) {
                res *= product;
            }
            product *= product;
        }
        return res;
    }

    public static void main(String[] args) {
        double n = new LC50_PowXN_M().myPowII(2.0, 5);
        System.out.println(n);
    }
}
