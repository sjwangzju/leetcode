package FullTime.OCI;

public class MaximumSubarray {

    // Given an integer array nums,
    // find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
    //
    // Input: [-2,1,-3,4,-1,2,1,-5,4],
    // Output: 6
    // Explanation: [4,-1,2,1] has the largest sum = 6.
    //
    // time: O(N), space: O(1)
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
            }
            sum += nums[i];
            res = Math.max(res, sum);
        }
        return res;
    }


    // follow-up
    // print the lo&hi bound of the maximum subarray
    public int maxSubArrayII(int[] nums) {
        int res = Integer.MIN_VALUE, sum = 0;
        int p1 = 0, p2 = 0, lo = 0, hi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = 0;
                p1 = i;
                p2 = i;
            } else {
                p2++;
            }
            sum += nums[i];
            if (sum > res) {
                res = sum;
                lo = p1;
                hi = p2;
            }
        }
        System.out.println(lo + ", " + hi);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        new MaximumSubarray().maxSubArrayII(nums);
    }
}
