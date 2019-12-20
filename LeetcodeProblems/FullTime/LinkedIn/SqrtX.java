package FullTime.LinkedIn;

public class SqrtX {

    // Implement int sqrt(int x).
    // Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
    //
    // Thoughts:
    // 1. Binary Search
    // 2. (long)mid * mid
    //
    // time: O(logN), space: O(1)
    public int mySqrt(int x) {
        if (x < 2) return x;

        int lo = 2, hi = x/2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if ((long)mid * mid > x) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
