package FullTime.Facebook;

public class DecodeWays {

    // Given a non-empty string containing only digits, determine the total number of ways to decode it.
    //
    // Input: "226"
    // Output: 3
    // Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    //
    // Thoughts:
    // 1. DP
    // 2. edge case: '0' can't exist alone (only "10" or "20")
    //
    // time: O(N), space: O(N)
    //
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0'? 0: 1;

        for (int i = 1; i < s.length(); i++) {
            char c1 = s.charAt(i - 1), c2 = s.charAt(i);
            if (c2 >= '1' && c2 <= '9') {
                dp[i + 1] += dp[i];
            }
            if (c1 == '1' || c1 == '2' && c2 >= '0' && c2 <= '6') {
                dp[i + 1] += dp[i - 1];
            } else if (c2 == '0') {
                return 0;
            }
        }
        return dp[dp.length - 1];
    }
}
