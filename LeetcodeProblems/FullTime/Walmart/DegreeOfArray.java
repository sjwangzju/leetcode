package FullTime.Walmart;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {

    // time: O(N), space: O(N)
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> index = new HashMap<>();
        Map<Integer, Integer> cnt = new HashMap<>();
        int degree = 0, res = nums.length;

        for (int i = 0; i < nums.length; i++) {
            if (!index.containsKey(nums[i])) {
                index.put(nums[i], i);
            }
            cnt.put(nums[i], cnt.getOrDefault(nums[i], 0) + 1);
            if (cnt.get(nums[i]) > degree) {
                degree = cnt.get(nums[i]);
                res = i - index.get(nums[i]) + 1;
            } else if (cnt.get(nums[i]) == degree) {
                res = Math.min(res, i - index.get(nums[i]) + 1);
            }
        }
        return res;
    }
}
