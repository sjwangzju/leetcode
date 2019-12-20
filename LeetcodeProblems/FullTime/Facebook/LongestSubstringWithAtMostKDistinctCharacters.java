package FullTime.Facebook;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    // Given a string, find the length of the longest substring T that contains at most k distinct characters.
    //
    // Input: s = "eceba", k = 2
    // Output: 3
    // Explanation: T is "ece" which its length is 3.
    //
    // Sliding window
    //
    // time: O(N), space: O(K), K is num of unique charactersLon
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        while (j < s.length()) {
            char c1 = s.charAt(j);
            map.put(c1, map.getOrDefault(c1, 0) + 1);

            while (map.size() > k && i <= j) {
                char c2 = s.charAt(i++);
                map.put(c2, map.get(c2) - 1);
                if (map.get(c2) == 0) {
                    map.remove(c2);
                }
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
