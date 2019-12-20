package FullTime.Facebook;

public class MaximumSubarray {

    // Given an integer array nums, find the contiguous subarray
    // (containing at least one number) which has the largest sum and return its sum.
    //
    // Input: [-2,1,-3,4,-1,2,1,-5,4],
    // Output: 6
    // Explanation: [4,-1,2,1] has the largest sum = 6.
    //
    // time: O(N), space: O(1)
    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) sum = 0;
            sum += nums[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
