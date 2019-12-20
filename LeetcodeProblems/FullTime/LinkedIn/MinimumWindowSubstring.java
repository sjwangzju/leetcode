package FullTime.LinkedIn;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    // Given a string S and a string T,
    // find the minimum window in S which will contain all the characters in T in complexity O(n).
    //
    // Input: S = "ADOBECODEBANC", T = "ABC"
    // Output: "BANC"
    //
    // Thoughts:
    // 1. HashMap + sliding window
    //
    // time: O(M+N)
    // space: O(K), K is num of unique characters in T
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";

        Map<Character, Integer> T = new HashMap<>();
        Map<Character, Integer> S = new HashMap<>();
        int lo = -1, hi = -1, i = 0, j = 0, len = s.length();

        for (char c: t.toCharArray()) {
            T.put(c, T.getOrDefault(c, 0) + 1);
        }

        int cnt = 0;
        while (j < s.length()) {
            char c = s.charAt(j);
            if (T.containsKey(c)) {
                S.put(c, S.getOrDefault(c, 0) + 1);
                if (S.get(c).equals(T.get(c))) {
                    cnt++;
                }
                while (i <= j && cnt == T.size()) {
                    char c2 = s.charAt(i);
                    if (j - i < len) {
                        lo = i;
                        hi = j;
                        len = j - i + 1;
                    }
                    if (S.containsKey(c2)) {
                        S.put(c2, S.get(c2) - 1);
                        if (S.get(c2) < T.get(c2)) {
                            cnt--;
                        }
                    }
                    i++;
                }
            }
            j++;
        }
        return lo == -1? "": s.substring(lo, hi + 1);
    }
}
