package FullTime.FB;

public class LC516_LongestPalindromicSubsequence_M {

    // Solution1: 2D dp
    // time: O(N^2)
    // space: O(N^2)
    public int longestPalindromeSubseqI(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }


    // Solution2: DFS + memo
    // time: O(N^2)
    // space: O(N^2)
    public int longestPalindromeSubseqII(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return dfs(dp, 0, s.length() - 1, s);
    }

    public int dfs(int[][] dp, int i, int j, String s) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        if (i > j) return 0;
        if (i == j) return 1;

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = dfs(dp, i + 1, j - 1, s) + 2;
        } else {
            dp[i][j] = Math.max(dfs(dp, i + 1, j, s), dfs(dp, i, j - 1, s));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(new LC516_LongestPalindromicSubsequence_M().longestPalindromeSubseqII(s));
    }
}
