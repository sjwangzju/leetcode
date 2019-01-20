package TuSimple;

public class MaximumSubarray {

    /**
     * lc 53
     *
     * follow up: find two subarrays with the max sum
     *
     * time: O(N), space: O(N)
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (leftSum < 0) {
                leftSum = nums[i];
            } else {
                leftSum += nums[i];
            }
            left[i] = leftSum;
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (rightSum < 0) {
                rightSum = nums[i];
            } else {
                rightSum += nums[i];
            }
            right[i] = rightSum;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, left[i] + right[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}
