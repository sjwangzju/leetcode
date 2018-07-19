package TwoPointers;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sjwang on 07/19/2018.
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null) return 0;
        if(s.length() == 0 || s.length() == 1) return s.length();
        Set<Character> S = new HashSet<>();
        int max = 0, i = 0, j = 0;
        while(j < s.length()){
            if(!S.contains(s.charAt(j))){
                S.add(s.charAt(j++));
                max = max > S.size() ? max : S.size();
            }
            else S.remove(s.charAt(i++));
        }
        return max;
    }
    public static void main(String args[]){
        String s = "dvdf";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(s));
    }
}
