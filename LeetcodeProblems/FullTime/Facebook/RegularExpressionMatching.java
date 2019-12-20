package FullTime.Facebook;

public class RegularExpressionMatching {

    /**
     * Regex:
     * 1. '.' any character
     * 2. '*' zero or more
     *
     * Input:
     * s = "aab"
     * p = "c*a*b"
     * Output: true
     *
     * Thoughts:
     * 1. 2D DP
     *
     * time: O(M*N), space: O(M*N)
     *
     */
    public boolean isMatchI(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // initialize the first row
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int c1 = s.charAt(i - 1), c2 = p.charAt(j - 1);
                if (c1 == c2 || c2 == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2 == '*') {
                    if (p.charAt(j - 2) == c1 || p.charAt(j - 2) == '.') {
                        // a* counts as multiple || single || zero
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }


    /**
     * Regex:
     * 1. '+', one or more
     * 2. '*', zero ore more
     *
     * e.g.
     *  "a+" represents one "a" or infinite "a"
     *  "a*" represents zero "a" or infinite "a"
     *
     *
     * Thoughts:
     * 1. 2D DP
     *
     * time: O(M*N), space: O(M*N)
     *
     */
    public boolean isMatchII(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // initialize the first row
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int c1 = s.charAt(i - 1), c2 = p.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2 == '*') {
                    if (p.charAt(j - 2) == c1) {
                        // a* counts as multiple || single || zero
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                } else if (c2 == '+') {
                    if (p.charAt(j - 2) == c1) {
                        // a+ counts as multiple || single
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[m][n];
    }


    /**
     * Regex:
     * 1. '?', any character
     * 2. '*', any sequence of characters
     *
     * Thoughts:
     * 1. 2D DP
     *
     * time: O(M*N), space: O(M*N)
     *
     */
    public boolean isMatchIII(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // initialize the first row
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int c1 = s.charAt(i - 1), c2 = p.charAt(j - 1);
                if (c1 == c2 || c2 == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (c2 == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatchI("aaaabc", "a+b*"));
    }
}
