package FullTime.FB;

/**
 * time: O(N)
 * space: O(1)
 */
public class LC674_LongestContinuousIncreasingSubsequence_E {

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1, cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur++;
                max = Math.max(max, cur);
            } else {
                cur = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println(new LC674_LongestContinuousIncreasingSubsequence_E().findLengthOfLCIS(nums));
    }
}
