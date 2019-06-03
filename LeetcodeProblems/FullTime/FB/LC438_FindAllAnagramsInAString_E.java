package FullTime.FB;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * sliding window - similar to LC76
 */
public class LC438_FindAllAnagramsInAString_E {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (char ch: p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int len = p.length();
        int cnt = 0;
        int l = 0, r = 0;
        Map<Character, Integer> window = new HashMap<>();

        while (r < s.length()) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(map.get(ch))) {
                    cnt++;
                }
            }
            while (l <= r && cnt == map.size()) {
                if (r - l + 1 == len) {
                    res.add(l);
                }
                char c = s.charAt(l);
                if (window.containsKey(c)) {
                    window.put(c, window.get(c) - 1);
                    if (window.get(c) < map.get(c)) {
                        cnt--;
                    }
                }
                l++;
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abacbabc";
        String p = "abc";
        System.out.println(new LC438_FindAllAnagramsInAString_E().findAnagrams(s, p));
    }
}
