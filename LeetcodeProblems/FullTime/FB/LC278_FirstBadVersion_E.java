package FullTime.FB;

/**
 * binary search
 *
 * time: O(logN)
 * space: O(1)
 */
public class LC278_FirstBadVersion_E {

    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (!isBadVersion(mid)) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public boolean isBadVersion(int n) {
        return n >= 4;
    }

    public static void main(String[] args) {
        System.out.println(new LC278_FirstBadVersion_E().firstBadVersion(5));
    }
}
