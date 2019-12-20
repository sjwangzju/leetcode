package FullTime.Facebook;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    // non-negative numbers, check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is,
    // sums up to n*k where n is also an integer.
    //
    // Input: [23, 2, 4, 6, 7],  k=6
    // Output: True
    // Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
    //
    // Thoughts:
    // 1. HashMap: key: sum %= k, val: index
    // 2. edge case:
    //    k = 0 -> map.put(0, -1)
    //
    // time: O(N), space: O(k)
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        // k = 0
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // k = 0
            if (k != 0) sum %= k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // test1
        int[] nums1 = {5,2,19,6,3};
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(nums1, 2));

        // test2: edge case, k = 0
        int[] nums2 = {5,0,0,6,3};
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(nums2, 0));
    }
}
