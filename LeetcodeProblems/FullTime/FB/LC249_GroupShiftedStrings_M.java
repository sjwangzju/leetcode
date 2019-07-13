package FullTime.FB;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * HashMap
 *
 * time: O(N)
 * space: O(N)
 */
public class LC249_GroupShiftedStrings_M {

    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strings) {
            String str = getFirst(s);
            if (!map.containsKey(str)) {
                map.put(str, new LinkedList<>());
            }
            map.get(str).add(s);
        }

        for (String k: map.keySet()) {
            res.add(map.get(k));
        }
        return res;
    }

    public String getFirst(String s) {
        StringBuilder res = new StringBuilder();
        int offset = s.charAt(0) - 'a';
        for (char ch: s.toCharArray()) {
            char tmp = (char) (ch - offset);
            if (tmp < 'a') {
                tmp += 26;
            }
            res.append(tmp);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] strings = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        new LC249_GroupShiftedStrings_M().groupStrings(strings);
    }
}
