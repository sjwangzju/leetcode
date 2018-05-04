package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjwang on 04/05/2018.
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 *
 * Examples:
 *
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 */

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : chs){
            if(!map.containsKey(ch)) map.put(ch, 1);
            else map.put(ch, map.get(ch) + 1);
        }
        for(char ch : chs) if(map.get(ch) == 1) return s.indexOf(ch);
        return -1;
    }

    public static void main(String args[]){
        String str = "loveleetcode";
        System.out.println(new FirstUniqueCharacterInAString().firstUniqChar(str));
    }
}
