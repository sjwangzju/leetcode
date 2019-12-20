package FullTime.Facebook;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsK {

    // Given an array nums and a target value k,
    // find the maximum length of a subarray that sums to k.
    // If there isn't one, return 0 instead.
    //
    // Input: nums = [1, -1, 5, -2, 3], k = 3
    // Output: 4
    // Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
    //
    // Thoughts:
    // 1. HashMap:
    //    key: accumulative sum, value: index
    // 2. map.put(0, -1);
    //
    // time: O(N), space: O(N)
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0, max = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                max = Math.max(max, i - map.get(sum - k));
            }
            // if map contains key, don't update
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }

}
