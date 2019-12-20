package FullTime.Facebook;

import java.util.Arrays;

public class TargetSum {

    // Find out how many ways to assign symbols to make sum of integers equal to target S.
    //
    // Input: nums is [1, 1, 1, 1, 1], S is 3.
    // Output: 5
    // Explanation:
    // -1+1+1+1+1 = 3
    // +1-1+1+1+1 = 3
    // +1+1-1+1+1 = 3
    // +1+1+1-1+1 = 3
    // +1+1+1+1-1 = 3
    //
    // Solution1: basic recursion
    // time: O(2^N), space: O(N)
    int res = 0;
    public int findTargetSumWaysI(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
        dfsI(nums, S, 0, 0);
        return res;
    }

    public void dfsI(int[] nums, int S, int i, int cur) {
        if (i == nums.length) {
            if (cur == S) {
                res++;
            }
            return;
        }
        dfsI(nums, S, i + 1, cur + nums[i]);
        dfsI(nums, S, i + 1, cur - nums[i]);
    }


    // Solution2:
    // 1. recursion + memo (2D dp)
    // 2. The sum is in range [-1000,1000]
    // 3. int[][] dp = new int[nums.length][2000]
    //
    // time: O(l*N), l=2000
    // space: O(l*N)
    public int findTargetSumWaysII(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;

        int[][] dp = new int[nums.length][2000];
        for (int[] d: dp) {
            Arrays.fill(d, -1);
        }
        dfs(nums, S, 0, 0, dp);
        return dp[0][1000];
    }

    public int dfs(int[] nums, int S, int i, int cur, int[][] dp) {
        if (i == nums.length) {
            return cur == S? 1: 0;
        }
        if (dp[i][cur + 1000] >= 0) return dp[i][cur + 1000];
        int sum = 0;
        sum += dfs(nums, S, i + 1, cur + nums[i], dp);
        sum += dfs(nums, S, i + 1, cur - nums[i], dp);
        dp[i][cur + 1000] = sum;
        return sum;
    }
}
