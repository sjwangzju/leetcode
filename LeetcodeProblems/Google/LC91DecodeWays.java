package Google;

public class LC91DecodeWays {

    /**
     * dp
     *
     * time: O(N), space: O(N)
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int n1 = Integer.parseInt(s.substring(i - 1, i));
            int n2 = Integer.parseInt(s.substring(i - 2, i));

            if (n1 >= 1 && n1 <= 9) {
                dp[i] += dp[i - 1];
            }

            if (n2 >= 10 && n2 <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "225";
        System.out.println(new LC91DecodeWays().numDecodings(s));
    }
}
