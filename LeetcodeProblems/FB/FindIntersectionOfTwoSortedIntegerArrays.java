package FB;

import java.util.ArrayList;
import java.util.List;

public class FindIntersectionOfTwoSortedIntegerArrays {
    /**
     * Two pointers (linear search) - time: O(M + N), space: O(1)
     * @param nums1
     * @param nums2
     * @return
     */
    public List<Integer> findIntersectionI (int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        int pos1 = 0; int pos2 = 0;
        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] < nums2[pos2]) {
                 pos1++;
            } else if (nums1[pos1] > nums2[pos2]) {
                pos2++;
            } else {
                res.add(nums1[pos1]);
                pos1++;
                pos2++;
            }
        }
        return res;
    }


    /**
     * binary search - time: O(M * log(N)), N is the len of the longer array, space: O(1)
     *
     * Binary search is better than linear search when M is small
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public List<Integer> findIntersectionII (int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int start = 0;
        for(int i = 0; i < nums1.length; i++) {
            int target = nums1[i];
            int index = binarySearch(nums2, start, nums2.length - 1, target);
            if (nums2[index] == target) {
                res.add(target);
                start = index + 1;
            }
        }
        return res;
    }

    public int binarySearch(int[] nums2, int lo, int hi, int target) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums2[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,3,6,6,17,21};
        int[] nums2 = {2,4,6,6,6,21};
        List<Integer> res = new FindIntersectionOfTwoSortedIntegerArrays().findIntersectionII(nums1, nums2);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
