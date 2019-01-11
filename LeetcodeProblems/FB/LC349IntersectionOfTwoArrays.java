package FB;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LC349IntersectionOfTwoArrays {

    /**
     * binary search, when one array is extremely long, use this method
     *
     * otherwise, just do linear search, which has time of O(M + N)
     *
     * time: O(N logN), N is the longer array
     * space: O(M + N)
     *
     */
    public int[] intersection(int[] nums1, int[] nums2) {

        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] big;
        int[] small;
        Set<Integer> res = new HashSet<>();

        if (len1 > len2) {
            big = nums1;
            small = nums2;
        } else {
            big = nums2;
            small = nums1;
        }

        Arrays.sort(big);
        for (int i = 0; i < small.length; i++) {
            if (binarySearch(big, small[i])) {
                res.add(small[i]);
            }
        }

        int[] n = new int[res.size()];
        int i = 0;
        for (int num: res) {
            n[i++] = num;
        }
        return n;
    }

    public boolean binarySearch(int[] big, int n) {
        int lo = 0;
        int hi = big.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (big[mid] == n) return true;
            if (big[mid] < n) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return big[lo] == n;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] res = new LC349IntersectionOfTwoArrays().intersection(nums1, nums2);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
