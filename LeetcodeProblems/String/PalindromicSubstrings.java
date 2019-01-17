package String;

/**
 * Created by sjwang on 05/16/2018.
 * Given a string, your task is to count how many palindromic substrings in this string.
 *
 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 * Note:
 * The input string length won't exceed 1000.
 */

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = s.length();
        for(int i = 0; i < s.length(); i ++){
            for(int j = i + 1; j < s.length(); j ++){
                if(isPalindromic(s.substring(i, j + 1))) count ++;
            }
        }
        return count;
    }

    public boolean isPalindromic(String s){
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length / 2; i ++){
            if(chs[i] != chs[chs.length - 1 - i]) return false;
        }
        return true;
    }

    public static void main(String args[]){
        String s = "bab";
        System.out.println(new PalindromicSubstrings().countSubstrings(s));
    }
}
