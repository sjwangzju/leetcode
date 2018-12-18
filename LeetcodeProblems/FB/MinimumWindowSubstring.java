package FB;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

//    /**
//     * runtime: O(n^2)
//     * @param S
//     * @param T
//     * @return
//     */
//    public String minWindow(String S, String T) {
//        Map<Character, Integer> map = new HashMap<>();
//        Map<Character, Integer> map2 = new HashMap<>();
//
//        for (int i = 0; i < T.length(); i++) {
//            map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0) + 1);
//        }
//        int start = 0;
//        int len = T.length();
//        int cnt = 0;
//        int minLen = Integer.MAX_VALUE;
//        String ret = "";
//
//        while (start < S.length()) {
//            for (int i = start; i < S.length(); i++) {
//                char ch = S.charAt(i);
//                String tmp = S.substring(start, i + 1);
//                if (map.containsKey(ch)) {
//                    map2.put(ch, map2.getOrDefault(ch, 0) + 1);
//                    if (map2.get(ch) == map.get(ch)) {
//                        cnt += map.get(ch);
//                    }
//                }
//                if (cnt == len) {
//                    if (tmp.length() < minLen) {
//                        minLen = tmp.length();
//                        ret = tmp;
//                    }
//                    map2 = new HashMap<>();
//                    break;
//                }
//            }
//            start++;
//            cnt = 0;
//        }
//        return ret;
//    }

    /**
     * runtime: O(n)
     * @param S
     * @param T
     * @return
     */
    public String minWindow2(String S, String T) {
        if (S.length() == 0 || T.length() == 0) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (int i = 0; i < T.length(); i++) {
            map.put(T.charAt(i), map.getOrDefault(T.charAt(i), 0) + 1);
        }

        int cnt = 0;
        int minLen = Integer.MAX_VALUE;
        String ret = "";

        int lo = 0; int hi = 0;

        while (hi < S.length()) {
            char ch = S.charAt(hi);
            if (map.containsKey(ch)) {
                map2.put(ch, map2.getOrDefault(ch, 0) + 1);
                if (map2.get(ch) <= map.get(ch)) {
                    cnt ++;
                }
            }
            while (cnt == T.length()) {
                String tmp = S.substring(lo, hi + 1);
                if (tmp.length() < minLen) {
                    ret = tmp;
                    minLen = tmp.length();
                }
                char c = S.charAt(lo);
                if (map2.containsKey(c) && map2.get(c) > 0) {
                    map2.put(c, map2.get(c) - 1);
                    if (map2.get(c) < map.get(c)) {
                        cnt--;
                    }
                }
                lo++;
            }
            hi++;
        }

        return ret;
    }

    public static void main(String[] args) {
        String S = "A";
        String T = "AA";
        String ret = new MinimumWindowSubstring().minWindow2(S, T);
        System.out.println(ret);
    }
}
