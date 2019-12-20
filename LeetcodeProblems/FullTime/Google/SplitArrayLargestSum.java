package FullTime.Google;

import java.util.Arrays;

public class SplitArrayLargestSum {

    // Solution 1: 2D DP
    // time: O(n^2*m), space: O(n*m)

    // dp[i][j] is minimum largest sum to split nums[0~j] into i parts
    // dp[i][j] = min{dp[i - 1][k], nums[k + 1] + ... + nums[j]}, k = [0,j-1]
    /*************************************************/
    public int splitArrayI(int[] nums, int m) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 0; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j],
                            Math.max(dp[i - 1][k], sum[j] - sum[k]));
                }
            }
        }
        return dp[m][n];
    }

    // Solution 2
    /*************************************************/


    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        int m = 2;
        System.out.println(new SplitArrayLargestSum().splitArrayI(nums, m));
    }
}
