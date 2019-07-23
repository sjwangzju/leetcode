package FullTime.FB;

/**
 * 2D dp
 *
 * time: O(M*N)
 * space: O(M*N)
 */
public class LC72_EditDistance_H {

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];

        // initialize
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = dp[i - 1][j - 1];
                if (word2.charAt(j - 1) != word1.charAt(i - 1)) {
                    tmp++;
                }
                dp[i][j] = Math.min(tmp, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(new LC72_EditDistance_H().minDistance(word1, word2));
    }
}
