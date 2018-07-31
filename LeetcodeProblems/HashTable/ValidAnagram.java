package HashTable;

import java.util.Arrays;

/**
 * Created by sjwang on 07/31/2018.
 *
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        Arrays.sort(ss);
        Arrays.sort(tt);
        return String.valueOf(ss).equals(String.valueOf(tt));
    }
    public static void main(String args[]){
        String s = "anagram", t = "nagaram";
        System.out.println(new ValidAnagram().isAnagram(s, t));
    }
}
