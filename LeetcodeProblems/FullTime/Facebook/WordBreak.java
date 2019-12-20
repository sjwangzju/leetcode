package FullTime.Facebook;

import java.util.*;

public class WordBreak {

    /**
     * Word Break I
     *
     * e.g.
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     *
     * Thoughts:
     * 1. recursion + memo
     *
     * time: O(N^2), space: O(N)
     */
    public boolean wordBreakI(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];

        return isValid(set, dp, s, 0);
    }

    public boolean isValid(Set<String> set, int[] dp, String s, int i) {
        if (i == s.length()) return true;
        if (dp[i] != 0) return dp[i] == 1;

        boolean res = false;
        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            if (set.contains(sub) && isValid(set, dp, s, j + 1)) {
                res = true;
                break;
            }
        }
        dp[i] = res? 1: -1;
        return res;
    }



    /**
     * Word Break II
     *
     * e.g.
     * Input:
     * s = "catsanddog"
     * wordDict = ["cat", "cats", "and", "sand", "dog"]
     *
     * Output:
     * [
     *   "cats and dog",
     *   "cat sand dog"
     * ]
     *
     * Thoughts:
     * 1. recursion + memo
     * 2. HashMap:
     *      key: index
     *      val: all possible strings start from index i
     *
     *
     * time: O(N^3) - size of recursion stack is O(N^2), creation of list is O(N)
     * space: O(N^3)
     */
    Map<Integer, List<String>> map = new HashMap<>();
    public List<String> wordBreakII(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        map.put(s.length(), Arrays.asList(""));
        return dfs(wordSet, s, 0);
    }

    public List<String> dfs(Set<String> wordSet, String s, int i) {
        // pruning - visited before, return directly
        if (map.containsKey(i)) return map.get(i);

        List<String> tmp = new ArrayList<>();
        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);

            if (wordSet.contains(sub)) {
                for (String str: dfs(wordSet, s, j + 1)) {
                    if (str.length() == 0) tmp.add(sub);
                    else tmp.add(sub + " " + str);
                }
            }
        }
        map.put(i, tmp);
        return tmp;
    }
}
