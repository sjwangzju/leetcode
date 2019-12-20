package FullTime.LinkedIn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {

    // Two strings are isomorphic if the characters in s can be replaced to get t.
    // No two characters may map to the same character but a character may map to itself.
    //
    // Input: s = "paper", t = "title"
    // Output: true
    //
    // time: O(N), space: O(1)
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Character> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
            } else {
                if (set.contains(c2)) return false;
                map.put(c1, c2);
                set.add(c2);
            }
        }
        return true;
    }
}
