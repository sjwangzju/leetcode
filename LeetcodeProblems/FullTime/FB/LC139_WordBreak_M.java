package FullTime.FB;

import java.util.Arrays;
import java.util.List;

/**
 * DFS + Memory
 *
 * time: O(N^2)
 * space: O(N)
 */
public class LC139_WordBreak_M {

    int[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new int[s.length() + 1];
        return isValid(s, 0, wordDict);
    }

    public boolean isValid(String s, int i, List<String> wordDict) {
        if (i == s.length()) {
            dp[i] = 1;
            return true;
        }
        for (int j = i; j < s.length(); j++) {
            String tmp = s.substring(i, j + 1);
            if (wordDict.contains(tmp)) {
                if (dp[j + 1] == -1) continue;
                if (dp[j + 1] == 1 || dp[j + 1] == 0 && isValid(s, j + 1, wordDict)) {
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i] = -1;
        return false;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(new LC139_WordBreak_M().wordBreak(s, wordDict));
    }
}
