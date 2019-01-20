package TuSimple;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    /**
     * time: O(N)
     * @param S
     * @param T
     * @return
     */
    public String minWindow(String S, String T) {
        Map<Character, Integer> dict = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            char ch = T.charAt(i);
            dict.put(ch, dict.getOrDefault(ch, 0) + 1);
        }

        int min = Integer.MAX_VALUE;
        String res = "";

        int l = 0;
        int r = 0;
        int cnt = 0;

        while (l <= r && r < S.length()) {
            char tmp = S.charAt(r);
            if (dict.containsKey(tmp)) {
                map.put(tmp, map.getOrDefault(tmp, 0) + 1);
                if (map.get(tmp) <= dict.get(tmp)) {
                    cnt++;
                }
            }

            while (cnt == T.length()) {
                String str = S.substring(l, r + 1);
                if (str.length() < min) {
                    min = str.length();
                    res = str;
                }
                char c = S.charAt(l);
                if (map.containsKey(c) && map.get(c) > 0) {
                    map.put(c, map.get(c) - 1);
                    if (map.get(c) < dict.get(c)) {
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
        String S = "ADOBECODEBANC";
        String T = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(S, T));
    }
}
