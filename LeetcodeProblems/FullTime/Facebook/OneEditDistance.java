package FullTime.Facebook;

public class OneEditDistance {

    // Given two strings s and t, determine if they are both one edit distance apart.
    //
    // Input: s = "ab", t = "acb"
    // Output: true
    // Explanation: We can insert 'c' into s to get t.
    //
    // time: O(min(M, N)), space: O(N)
    public boolean isOneEditDistance(String s, String t) {
        int l1 = s.length(), l2 = t.length();
        if (l1 > l2) return isOneEditDistance(t, s);
        if (l2 - l1 > 1) return false;

        for (int i = 0; i < l1; i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (c1 == c2) continue;

            if (l1 == l2) return s.substring(i + 1).equals(t.substring(i + 1));
            return s.substring(i).equals(t.substring(i + 1));
        }
        return l1 != l2;
    }


    // Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
    // time: O(M*N), space: O(M*N)
    public int minDistance(String word1, String word2) {
        int m = word2.length(), n = word1.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c1 = word2.charAt(i - 1), c2 = word1.charAt(j - 1);
                int n1 = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                int n2 = dp[i - 1][j - 1];
                if (c1 != c2) n2 += 1;
                dp[i][j] = Math.min(n1, n2);
            }
        }
        return dp[m][n];
    }
}
