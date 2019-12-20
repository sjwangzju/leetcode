package FullTime.Facebook;

public class FirstBadVersion {

    public boolean isBadVersion(int n) {
        return n >= 5;
    }

    // Implement a function to find the first bad version.
    //
    // Given n = 5, and version = 4 is the first bad version.
    // call isBadVersion(3) -> false
    // call isBadVersion(5) -> true
    // call isBadVersion(4) -> true
    // Then 4 is the first bad version.
    //
    // binary search
    // time: O(logN), space: O(1)
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (!isBadVersion(mid)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
