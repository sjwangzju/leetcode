package FullTime.Facebook;

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
    // 1. use two HashMaps to store character frequency in s and t
    // 2. sliding window
    //
    // time: O(M+N), space: O(1)
    public String minWindow(String s, String t) {
        Map<Character, Integer> T = new HashMap<>();
        Map<Character, Integer> S = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            T.put(c, T.getOrDefault(c, 0) + 1);
        }

        int len = Integer.MAX_VALUE, lo = -1, hi = -1, cnt = 0;
        int i = 0, j = 0;
        while (j < s.length()) {
            char c1 = s.charAt(j);
            if (T.containsKey(c1)) {
                S.put(c1, S.getOrDefault(c1, 0) + 1);
                if (S.get(c1).equals(T.get(c1))) {
                    cnt++;
                }
                while (cnt == T.size() && i <= j) {
                    if (j - i + 1 < len) {
                        len = j - i + 1;
                        lo = i;
                        hi = j;
                    }
                    char c2 = s.charAt(i++);
                    if (S.containsKey(c2)) {
                        S.put(c2, S.get(c2) - 1);
                        if (S.get(c2) < T.get(c2)) {
                            cnt--;
                        }
                    }
                }
            }
            j++;
        }
        return lo == -1? "": s.substring(lo, hi + 1);
    }
}
