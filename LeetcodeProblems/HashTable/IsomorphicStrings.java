package HashTable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sjwang on 07/31/2018.
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 * Input: s = "egg", t = "add"
 * Output: true
 *
 * Example 2:
 * Input: s = "foo", t = "bar"
 * Output: false
 *
 * Example 3:
 * Input: s = "paper", t = "title"
 * Output: true
 *
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Set<Character> S = new HashSet<>();
        Map<Character, Character> m = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char ss = s.charAt(i), tt = t.charAt(i);
            if(!m.containsKey(ss)) {
                if(!S.contains(tt)) {
                    m.put(ss, tt);
                    S.add(tt);
                }
                else return false;
            }
            else {
                if(tt != m.get(ss)) return false;
            }
        }
        return true;
    }
    public static void main(String args[]){
        String s = "paper", t = "title";
        System.out.println(new IsomorphicStrings().isIsomorphic(s, t));
    }
}
