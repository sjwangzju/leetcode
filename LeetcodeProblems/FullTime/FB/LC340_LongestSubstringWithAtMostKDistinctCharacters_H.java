package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

/**
 * sliding window
 *
 * time: O(n), n is len of s
 * space: O(k)
 */
public class LC340_LongestSubstringWithAtMostKDistinctCharacters_H {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int l = 0, r = 0;

        while (r < s.length()) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.size() <= k) {
                max = Math.max(max, r - l + 1);
            }
            while (l <= r && map.size() > k) {
                char c = s.charAt(l);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                l++;
            }
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aa";
        int k = 2;
        System.out.println(new LC340_LongestSubstringWithAtMostKDistinctCharacters_H().lengthOfLongestSubstringKDistinct(s, k));
    }
}
