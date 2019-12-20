package FullTime.LinkedIn;

public class ValidPerfectSquare {

    // Given a positive integer num, write a function which returns True if num is a perfect square else False.
    //
    // Binary search
    // time: O(logN), space: O(1)
    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;

        int lo = 2, hi = num / 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if ((long)mid * mid == num) return true;
            else if ((long)mid * mid < num) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return false;
    }
}
