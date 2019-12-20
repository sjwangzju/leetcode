package FullTime.Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StrobogrammaticNumber {

    /**
     * Strobogrammatic Number I
     *
     * 6-9,8-8,0-0,1-1
     * map + two pointers
     *
     * time: O(N), space: O(1)
     */
    public boolean isStrobogrammaticI(String num) {
        if (num == null || num.length() == 0) return true;

        Map<Character, Character> map = new HashMap<>();
        map.put('0','0'); map.put('1','1'); map.put('8','8');
        map.put('6','9'); map.put('9','6');

        int i = 0, j = num.length() - 1;
        while (i <= j) {
            char c1 = num.charAt(i++), c2 = num.charAt(j--);
            if (!map.containsKey(c1) || map.get(c1) != c2) {
                return false;
            }
        }
        return true;
    }


    /**
     * Strobogrammatic Number II
     *
     * 6-9,8-8,0-0,1-1
     *
     * Thoughts:
     * 1. recursion
     * 2. map + two pointers + char[]
     *
     * time: O(5^(N/2)), space: O(N) for char[]
     *
     */
    List<String> res = new ArrayList<>();
    Map<Character, Character> map = new HashMap<>();

    public List<String> findStrobogrammatic(int n) {
        map.put('0','0'); map.put('1','1'); map.put('8','8');
        map.put('6','9'); map.put('9','6');

        dfs(0, n - 1, new char[n]);
        return res;
    }

    public void dfs(int i, int j, char[] chs) {
        if (i > j) {
            res.add(new String(chs));
            return;
        }

        for (char c: map.keySet()) {
            // no beginning '0' (when len > 1)
            if (i == 0 && j != 0 && c == '0') continue;
            // only '1' or '8' can be put in the middle (odd len)
            if (i == j && (c == '6' || c == '9')) continue;
            chs[i] = c;
            chs[j] = map.get(c);
            dfs(i + 1, j - 1, chs);
        }
    }
}
