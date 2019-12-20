package FullTime.Facebook;

public class MaximumSumOf3NonOverlappingSubarrays {

    // In a given array nums of positive integers,
    // find three non-overlapping subarrays(size k) with maximum sum.
    //
    // 2d DP
    // 1. tmp = sum[j] - sum[j - k] + dp[i - 1][j - k];
    //
    // time: O(N), space: O(N)
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int len = nums.length;
        int[] sum = new int[len + 1];

        for (int i = 1; i <= len; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        int[][] dp = new int[4][len + 1];
        int[][] pos = new int[4][len + 1];

        for (int i = 1; i <= 3; i++) {
            for (int j = i * k; j <= len; j++) {
                int tmp = sum[j] - sum[j - k] + dp[i - 1][j - k];
                if (tmp > dp[i][j - 1]) {
                    dp[i][j] = tmp;
                    pos[i][j] = j - k;
                } else {
                    dp[i][j] = dp[i][j - 1];
                    pos[i][j] = pos[i][j - 1];
                }
            }
        }

        int[] res = new int[3];
        res[2] = pos[3][len];
        for (int i = 1; i >= 0; i--) {
            res[i] = pos[i + 1][res[i + 1]];
        }
        return res;
    }
}
