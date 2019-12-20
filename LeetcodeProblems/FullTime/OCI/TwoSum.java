package FullTime.OCI;

import java.util.*;

public class TwoSum {

    /**
     * Two Sum
     *
     * Return indices of the two numbers such that they add up to a specific target.
     * Only one solution, may not use the same element twice.
     *
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     *
     *
     * Solution: HashMap
     *
     * time: O(N), space: O(N)
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


    /**
     * Three Sum
     *
     * Given array nums = [-1, 0, 1, 2, -1, -4],
     * A solution set is:
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * Solution:
     * 1. sort + two pointers
     * 2. corner cases: remove duplicates
     *
     * time: O(N^2), space: O(1)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            // remove duplicate nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int tmp = nums[j] + nums[k];
                if (tmp == -nums[i]) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    // remove duplicate nums[j] and nums[k]
                    while (j + 1 < k && nums[j + 1] == nums[j]) j++;
                    while (k - 1 > j && nums[k - 1] == nums[k]) k--;
                    j++;
                    k--;
                } else if (tmp < -nums[i]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }


    /**
     * Four Sum
     *
     * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
     * A solution set is:
     * [
     *   [-1,  0, 0, 1],
     *   [-2, -1, 1, 2],
     *   [-2,  0, 0, 2]
     * ]
     *
     * Solution:
     * 1. +1 more for loop on 3sum
     *
     * time: O(N^3), space: O(1)
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            // remove duplicate nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int l = i + 1; l < nums.length - 2; l++) {
                // remove duplicate nums[l]
                if (l > i + 1 && nums[l] == nums[l - 1]) continue;
                int j = l + 1, k = nums.length - 1;
                while (j < k) {
                    int tmp = nums[i] + nums[l] + nums[j] + nums[k];
                    if (tmp == target) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[j], nums[k]));
                        // remove duplicate nums[j] and nums[k]
                        while (j + 1 < k && nums[j + 1] == nums[j]) j++;
                        while (k - 1 > j && nums[k - 1] == nums[k]) k--;
                        j++;
                        k--;
                    } else if (tmp < target) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }
        return res;
    }
}
