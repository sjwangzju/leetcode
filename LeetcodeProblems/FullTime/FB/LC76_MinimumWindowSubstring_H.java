package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

/**
 * sliding window
 *
 * time: O(N + M), N - len of s, M - len of t
 * space: O(N + M)
 */
public class LC76_MinimumWindowSubstring_H {

    public String minWindow(String s, String t) {
        Map<Character, Integer> Tmap = new HashMap<>();

        for (char ch: t.toCharArray()) {
            Tmap.put(ch, Tmap.getOrDefault(ch, 0) + 1);
        }

        int cnt = 0;
        int l = 0, r = 0;
        int p1 = 0, p2 = 0;
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();

        // extend (move right pointer forward)
        while (r < s.length()) {
            char ch = s.charAt(r);

            if (Tmap.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(Tmap.get(ch).intValue())) {
                    cnt++;
                }
            }

            // contract (move left pointer forward)
            while (l <= r && cnt == Tmap.size()) {
                int len = r - l + 1;
                if (len < min) {
                    min = len;
                    p1 = l;
                    p2 = r;
                }
                char cur = s.charAt(l);
                if (window.containsKey(cur)) {
                    window.put(cur, window.get(cur) - 1);
                    if (window.get(cur) < Tmap.get(cur)) {
                        cnt--;
                    }
                }
                l++;
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? "": s.substring(p1, p2 + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(new LC76_MinimumWindowSubstring_H().minWindow(s, t));
    }
}
