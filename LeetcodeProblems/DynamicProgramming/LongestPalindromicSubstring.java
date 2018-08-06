package DynamicProgramming;

/**
 * Created by sjwang on 08/06/2018.
 *
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int len = s.length(), max = 0;
        String re = "";
        boolean[][] p = new boolean[len][len];
        for(int j = 0; j < len; j++) {
            for(int i = 0; i <= j ; i++) {
                p[i][j] = s.charAt(i) == s.charAt(j) && (i == j || j == i + 1 || p[i + 1][j - 1]);
                if(p[i][j] == true && j - i + 1 > max) {
                    max = j - i + 1;
                    re = s.substring(i, j + 1);
                }
            }
        }
        return re;
    }
    public static void main(String args[]){
        String s = "babad";
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(s));
    }
}
