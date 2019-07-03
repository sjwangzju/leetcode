package FullTime.FB;

/**
 * DP
 *
 * time: O(N^2)
 * space: O(N^2)
 */
public class LC5_LongestPalindromicSubstring_M {

    public String longestPalindrome(String s) {
        int max = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > max) {
                    res = s.substring(i, j + 1);
                    max = j - i + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(new LC5_LongestPalindromicSubstring_M().longestPalindrome(s));
    }
}
