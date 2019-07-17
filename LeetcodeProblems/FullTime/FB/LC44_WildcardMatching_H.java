package FullTime.FB;

/**
 * Similar to LC10
 *
 * time: O(M*N)
 * space: O(M*N)
 */
public class LC44_WildcardMatching_H {

    int[][] dp;
    public boolean isMatch(String s, String p) {
        dp = new int[s.length() + 1][p.length() + 1];
        return dfs(s, p, 0, 0);
    }

    public boolean dfs(String s, String p, int i, int j) {
        if (i == s.length() && j == p.length()) return true;

        if (j < p.length()) {
            if (dp[i][j] != 0) {
                return dp[i][j] == 1;
            }
            if (i == s.length()) {
                boolean b = p.charAt(j) == '*' && dfs(s, p, i, j + 1);
                dp[i][j] = b? 1: -1;
                return b;
            }
            char c1 = s.charAt(i);
            char c2 = p.charAt(j);
            if (c2 != '*') {
                if (c2 != '?' && c1 != c2) {
                    dp[i][j] = -1;
                    return false;
                }
                boolean b = dfs(s, p, i + 1, j + 1);
                dp[i][j] = b? 1: -1;
                return b;
            }
            for (int k = i; k <= s.length(); k++) {
                if (dfs(s, p, k, j + 1)) {
                    dp[i][j] = 1;
                    return true;
                }
            }
        }
        dp[i][j] = -1;
        return false;
    }

    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        System.out.println(new LC44_WildcardMatching_H().isMatch(s, p));
    }
}
