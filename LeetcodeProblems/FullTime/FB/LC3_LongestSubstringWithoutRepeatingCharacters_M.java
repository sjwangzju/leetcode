package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

/**
 * Sliding Window
 *
 * time: O(N)
 * space: O(k), k is max len of string with distinct characters
 */
public class LC3_LongestSubstringWithoutRepeatingCharacters_M {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, r = 0, max = 1;
        while (r < s.length()) {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (l <= r && r - l + 1 > map.size()) {
                char c = s.charAt(l);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new LC3_LongestSubstringWithoutRepeatingCharacters_M().lengthOfLongestSubstring(s));
    }
}
