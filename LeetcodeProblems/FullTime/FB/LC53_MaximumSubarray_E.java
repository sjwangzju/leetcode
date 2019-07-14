package FullTime.FB;

/**
 * DP
 *
 * time: O(N)
 * space: O(1)
 */
public class LC53_MaximumSubarray_E {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new LC53_MaximumSubarray_E().maxSubArray(nums));
    }
}
