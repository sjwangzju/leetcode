package FullTime.Facebook;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // Given an unsorted array of integers, find the length of longest increasing subsequence.
    //
    // Input: [10,9,2,5,3,7,101,18]
    // Output: 4
    // Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
    //
    // Solution1: DP
    // time: O(N^2), space: O(N)
    public int lengthOfLISI(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    // Solution2:
    // 1. DP + binary search
    // time: O(NlogN), space: O(N)
    /*********************************************************/
    public int lengthOfLISII(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int pos = findPos(dp, nums[i], len);
            dp[pos] = nums[i];
            if (pos == len) {
                len++;
            }
        }
        return len;
    }

    // find the position to insert n
    // time: O(NlogN), space: O(N)
    public int findPos(int[] dp, int n, int len) {
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (dp[mid] < n) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
