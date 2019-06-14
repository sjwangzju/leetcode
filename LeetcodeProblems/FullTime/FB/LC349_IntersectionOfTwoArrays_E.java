package FullTime.FB;

import java.util.*;

/**
 * time: O(M+N)
 * space: O(Math.min(M,N))
 */
public class LC349_IntersectionOfTwoArrays_E {

    public int[] intersection(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        if (l1 > l2) return intersection(nums2, nums1);

        Set<Integer> s1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int n: nums1) {
            s1.add(n);
        }
        for (int n: nums2) {
            if (s1.contains(n)) {
                res.add(n);
            }
        }
        int[] tmp = new int[res.size()];
        int i = 0;
        for (int n: res) {
            tmp[i++] = n;
        }
        return tmp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] res = new LC349_IntersectionOfTwoArrays_E().intersection(nums1, nums2);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
