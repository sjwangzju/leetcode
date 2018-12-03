package Airbnb;

public class kEditDistance_23 {
    /**
     * lc72
     * @param word1
     * @param word2
     * @return
     *
     * e.g. dp[i][j]
     *
     *     a b c d
     *   0 1 2 3 4
     * a 1 0 1 2 3
     * b 2 1 0 1 2
     * c 3 2 1 0 1
     *
     * time: O(n * m)
     * space: O(m * m)
     *
     */
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[l1][l2];
    }

    /**
     * lc161
     * @param s
     * @param t
     * @return
     */
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length();
        int n = t.length();
        int num = Math.min(m, n);

        int i = 0; int j  = 0;
        while (i < num && s.charAt(i) == t.charAt(i)) i++;
        while (j < num - i && s.charAt(m - 1 - j) == t.charAt(n - 1 - j)) j++;
        return i + j == m + n - num - 1;
    }




    public static void main(String[] args) {
//        String word1 = "intention";
//        String word2 = "execution";
//        int min = new kEditDistance_23().minDistance(word1, word2);
//        System.out.println(min);

        String s = "abc";
        String t = "ac";
        System.out.println(new kEditDistance_23().isOneEditDistance(s, t));
    }
}
