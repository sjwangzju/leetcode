package FullTime.FB;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * Recursive
 *
 * time: O(5^n)
 * space: O(n)
 */
public class LC247_StrobogrammaticNumberII_M {

    List<String> res = new LinkedList<>();
    Map<Character, Character> map = new HashMap<>();

    public List<String> findStrobogrammatic(int n) {
        map.put('0','0');
        map.put('1','1');
        map.put('6','9');
        map.put('8','8');
        map.put('9','6');
        dfs(n, 0, new char[n]);
        return res;
    }

    public void dfs(int n, int i, char[] cur) {
        if (n == 0) return;
        if (i == (n + 1) / 2) {
            res.add(String.valueOf(cur));
            return;
        }
        for (char c: map.keySet()) {
            if (i == 0 && n > 1 && c == '0') {
                continue;
            }
            if (n % 2 == 1 && i == n / 2 && (c == '6' || c == '9')) {
                continue;
            }
            cur[i] = c;
            cur[n - 1 - i] = map.get(c);
            dfs(n, i + 1, cur);
        }
    }

    public static void main(String[] args) {
        List<String> res = new LC247_StrobogrammaticNumberII_M().findStrobogrammatic(3);
        for (String s: res) {
            System.out.println(s);
        }
    }
}
