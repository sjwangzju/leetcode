package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjwang on 06/05/2018.
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * Example 1:
 * Input: "abab"
 *
 * Output: True
 *
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * Input: "aba"
 *
 * Output: False
 */

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        
        return false;
    }

    public static void main(String args[]){
        String str = "abacabac";
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern(str));
    }
}