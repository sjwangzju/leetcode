package FullTime.OCI;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {

    // Given two arrays, write a function to compute their intersection.
    // Each element in the result must be unique.
    // The result can be in any order.
    //
    // Input: nums1 = [1,2,2,1], nums2 = [2,2]
    // Output: [2]
    //
    // time: O(l1+l2), space: O(min(l1, l2))
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return new int[0];
        if (nums1.length > nums2.length) return intersection(nums2, nums1);

        Set<Integer> set = new HashSet<>();
        for (int n: nums1) set.add(n);

        List<Integer> list = new ArrayList<>();
        for (int n: nums2) {
            if (set.contains(n)) {
                list.add(n);
                set.remove(n);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
