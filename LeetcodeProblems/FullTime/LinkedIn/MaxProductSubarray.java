package FullTime.LinkedIn;

public class MaxProductSubarray {

    // Given an integer array nums, find the contiguous subarray within an array
    // (containing at least one number) which has the largest product.
    //
    // Example 1:
    // Input: [2,3,-2,4]
    // Output: 6
    // Explanation: [2,3] has the largest product 6.
    //
    // time: O(N), space: O(1)
    public int maxProduct(int[] nums) {
        // p1 records min product, p2 records max product
        int p1 = nums[0], p2 = nums[0], res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // if nums[i] < 0, swap p1 and p2
            if (nums[i] < 0) {
                int tmp = p1;
                p1 = p2;
                p2 = tmp;
            }
            p1 = Math.min(nums[i], p1 * nums[i]);
            p2 = Math.max(nums[i], p2 * nums[i]);
            res = Math.max(res, p2);
        }
        return res;
    }
}
