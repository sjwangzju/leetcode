package FullTime.FB;

/**
 * DP
 *
 * time: O(N^2)
 * space: O(N)
 */
public class LC646_PalindromicSubstrings_M {

    int[][] dp;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int cnt = 0;
        int n = s.length();
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j >= i; j--) {
                cnt += isPalindrom(s, i, j)? 1: 0;
            }
        }
        return cnt;
    }

    public boolean isPalindrom(String s, int i, int j) {
        if (i >= j) return true;
        if (dp[i][j] != 0) {
            return dp[i][j] == 1;
        }
        if (s.charAt(i) != s.charAt(j)) {
            dp[i][j] = -1;
        } else {
            boolean b = isPalindrom(s, i + 1, j - 1);
            dp[i][j] += b? 1: -1;
        }
        return dp[i][j] == 1;
    }

    public static void main(String[] args) {
        String s = "aaa";
        int n = new LC646_PalindromicSubstrings_M().countSubstrings(s);
        System.out.print(n);
    }
}
