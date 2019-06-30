package FullTime.FB;

import java.util.Arrays;

public class LC494_TargetSum_M {

    // Solution 1: brute force DFS
    // time: O(2^N)
    // space: O(N)
    int cnt = 0;
    public int findTargetSumWaysI(int[] nums, int S) {
        dfsI(nums, S, 0, 0);
        return cnt;
    }

    public void dfsI(int[] nums, int S, int sum, int i) {
        if (i == nums.length) {
            if (sum == S) {
                cnt++;
            }
            return;
        }
        dfsI(nums, S, sum + nums[i], i + 1);
        dfsI(nums, S, sum - nums[i], i + 1);
    }


    // Solution 2: DFS + memory
    // time: O(N*L), N is len of nums, L = 2001
    // space: O(N*L)
    public int findTargetSumWaysII(int[] nums, int S) {
        // dp col has an offset of 1000, because sum is [-1000, 1000]
        int[][] dp = new int[nums.length][2001];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        return dfsII(nums, S, 0, 0, dp);
    }

    public int dfsII(int[] nums, int S, int sum, int i, int[][] dp) {
        if (i == nums.length) {
            return sum == S? 1: 0;
        }
        if (dp[i][sum + 1000] != Integer.MIN_VALUE) {
            return dp[i][sum + 1000];
        }
        // sum ways for add
        int n1 = dfsII(nums, S, sum + nums[i], i + 1, dp);
        // sum ways for subtract
        int n2 = dfsII(nums, S, sum - nums[i], i + 1, dp);
        dp[i][sum + 1000] = n1 + n2;
        return dp[i][sum + 1000];
    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int S = 3;
        System.out.println(new LC494_TargetSum_M().findTargetSumWaysII(nums, S));
    }
}
