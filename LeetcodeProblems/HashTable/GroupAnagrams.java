package HashTable;

import java.util.*;

/**
 * Created by sjwang on 07/30/2018.
 *
 * Given an array of strings, group anagrams together.
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> L = new ArrayList<>();
        Map<String, List<String>> m = new HashMap<>();
        for(String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String ss = String.valueOf(chs);
            if(!m.containsKey(ss)) {
                m.put(ss, new ArrayList<>());
            }
            m.get(ss).add(s);
        }
        for(String s : m.keySet()) L.add(m.get(s));
        return L;
    }
    public static void main(String args[]){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(new GroupAnagrams().groupAnagrams(strs));
    }
}
