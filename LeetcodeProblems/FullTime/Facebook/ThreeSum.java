package FullTime.Facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    // Find all unique a + b + c = 0 in the array
    //
    // Given array nums = [-1, 0, 1, 2, -1, -4],
    // A solution set is:
    // [
    //  [-1, 0, 1],
    //  [-1, -1, 2]
    // ]
    //
    // Thoughts:
    // 1. sort
    // 2. one for loop nums[i] -> two pointers to find pairs
    // 3. edge cases: avoid duplicate numbers
    //
    // time: O(N^2), space: O(1)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // skip equal elements to avoid duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1, target = -nums[i];
            while (l < r) {
                int cur = nums[l] + nums[r];
                if (cur < target) l++;
                else if (cur > target) r--;
                else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // skip equal elements to avoid duplicates
                    while (l + 1 < r && nums[l] == nums[l + 1]) l++;
                    while (r - 1 > l && nums[r] == nums[r - 1]) r--;
                    l++;
                    r--;
                }
            }
        }
        return res;
    }
}
