package Amazon;

public class InterleavingString {

    /**
     * 2D dp
     *
     * time: O(m * n)
     * space: O(m * n)
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
        dp[0][0] = true;

        for (int j = 1; j < dp[0].length; j++) {
            dp[0][j] = dp[0][j - 1] && s1.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] && s2.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] && s2.charAt(i - 1) == s3.charAt(i + j - 1)
                        || dp[i][j - 1] && s1.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        System.out.println(new InterleavingString().isInterleave(s1, s2, s3));
    }
}
