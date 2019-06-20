package FullTime.FB;

/**
 * DP
 *
 * time: O(N)
 * space: O(N)
 */
public class LC91_DecodeWays_M {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int len = s.length();
        int[] dp = new int[len + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 1; i < len; i++) {
            char ch1 = s.charAt(i - 1);
            char ch2 = s.charAt(i);
            if (ch2 != '0') {
                dp[i + 1] += dp[i];
            }
            if (ch1 == '1' || ch1 == '2' && ch2 >= '0' && ch2 <= '6') {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s = "1232124";
        System.out.println(new LC91_DecodeWays_M().numDecodings(s));
    }
}
