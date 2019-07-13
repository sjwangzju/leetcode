package FullTime.FB;

import java.util.*;

/**
 * HashMap
 *
 * time: O(N*KlogK), K is avg len of word
 * space: O(N)
 */
public class LC49_GroupAnagrams_M {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String s: strs) {
            String cur = order(s);
            if (!map.containsKey(cur)) {
                map.put(cur, new LinkedList<>());
            }
            map.get(cur).add(s);
        }
        for (String k: map.keySet()) {
            res.add(map.get(k));
        }
        return res;
    }

    // order strings in alphabetic order
    public String order(String s) {
        char[] chs = s.toCharArray();
        Arrays.sort(chs);
        return new String(chs);
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = new LC49_GroupAnagrams_M().groupAnagrams(strs);

        for (List<String> list: res) {
            for (String s: list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
}
