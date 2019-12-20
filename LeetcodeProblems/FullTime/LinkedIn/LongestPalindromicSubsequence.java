package FullTime.LinkedIn;

public class LongestPalindromicSubsequence {

    // Given a string s, find the longest palindromic subsequence's length in s.
    // You may assume that the maximum length of s is 1000.
    //
    // Example 1:
    // Input:
    // "bbbab"
    // Output:
    // 4
    //
    // 2D DP
    // time: O(N^2), space: O(N^2)
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        int[][] dp = new int[len][len];

        return getLongest(s, dp, 0, len - 1);
    }

    public int getLongest(String s, int[][] dp, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != 0) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = 2 + getLongest(s, dp, i + 1, j - 1);
        } else {
            dp[i][j] = Math.max(getLongest(s, dp, i + 1, j), getLongest(s, dp, i, j - 1));
        }
        return dp[i][j];
    }
}
