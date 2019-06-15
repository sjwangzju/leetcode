package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

/**
 * sliding window, similar to LC76
 *
 * time: O(M+N), M is len of s1, N is len of s2
 * space: O(M)
 */
public class LC567_PermutationInString_M {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> m1 = new HashMap<>();
        for (char ch: s1.toCharArray()) {
            m1.put(ch, m1.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = 0;
        int len = s2.length();
        int cnt = 0;
        Map<Character, Integer> m2 = new HashMap<>();

        while (r < len) {
            char cur = s2.charAt(r);

            if (m1.containsKey(cur)) {
                m2.put(cur, m2.getOrDefault(cur, 0) + 1);
                if (m2.get(cur).equals(m1.get(cur))) {
                    cnt++;
                }
            }

            while (l <= r && cnt == m1.size()) {
                if (r - l == s1.length() - 1) {
                    return true;
                }
                char ch = s2.charAt(l);
                if (m2.containsKey(ch)) {
                    m2.put(ch, m2.get(ch) - 1);
                    if (m2.get(ch) < m1.get(ch)) {
                        cnt--;
                    }
                }
                l++;
            }
            r++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "dcda";
        System.out.println(new LC567_PermutationInString_M().checkInclusion(s1, s2));
    }
}
