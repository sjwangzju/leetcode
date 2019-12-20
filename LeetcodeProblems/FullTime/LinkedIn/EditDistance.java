package FullTime.LinkedIn;

public class EditDistance {

    // Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
    // You have the following 3 operations permitted on a word:
    //
    // 3 operations:
    // 1. Insert a character
    // 2. Delete a character
    // 3. Replace a character
    //
    // Example 1:
    // Input: word1 = "horse", word2 = "ros"
    // Output: 3
    // Explanation:
    // horse -> rorse (replace 'h' with 'r')
    // rorse -> rose (remove 'r')
    // rose -> ros (remove 'e')
    //
    // 2D DP
    // time: O(l1*l2), space: O(l1*l2)
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l2 + 1][l1 + 1];

        for (int i = 0; i <= l2; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= l1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= l2; i++) {
            for (int j = 1; j <= l1; j++) {
                char c1 = word1.charAt(j - 1), c2 = word2.charAt(i - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j],
                            Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
            }
        }
        return dp[l2][l1];
    }
}
