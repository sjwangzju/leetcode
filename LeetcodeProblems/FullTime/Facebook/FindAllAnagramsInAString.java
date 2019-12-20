package FullTime.Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {

    // Input:
    // s: "cbaebabacd" p: "abc"
    //
    // Output:
    // [0, 6]
    //
    // Explanation:
    // The substring with start index = 0 is "cba", which is an anagram of "abc".
    // The substring with start index = 6 is "bac", which is an anagram of "abc".
    //
    // Thoughts:
    // 1. sliding window
    //
    // time: O(N), space: O(1)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> P = new HashMap<>();
        Map<Character, Integer> S = new HashMap<>();

        for (char c: p.toCharArray()) {
            P.put(c, P.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0, cnt = 0;
        while (j < s.length()) {
            char c1 = s.charAt(j);
            if (P.containsKey(c1)) {
                S.put(c1, S.getOrDefault(c1, 0) + 1);
                if (S.get(c1).equals(P.get(c1))) {
                    cnt++;
                }
                while (cnt == P.size() && i <= j) {
                    if (j - i + 1 == p.length()) {
                        res.add(i);
                    }
                    char c2 = s.charAt(i++);
                    S.put(c2, S.get(c2) - 1);
                    if (S.get(c2) < P.get(c2)) {
                        cnt--;
                    }
                }
                j++;
            } else {
                // reset
                cnt = 0;
                S = new HashMap<>();
                j++;
                i = j;
            }
        }
        return res;
    }

}
