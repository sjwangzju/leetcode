package Greedy;

/**
 * Created by sjwang on 08/14/2018.
 *
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example 1:
 * Input: "bcabc"
 * Output: "abc"
 *
 * Example 2:
 * Input: "cbacdcbc"
 * Output: "acdb"
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0 || s == null) return "";
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a'] += 1;
        int pri = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) < s.charAt(pri)) pri = i;
            count[s.charAt(i) - 'a'] -= 1;
            if(count[s.charAt(i) - 'a'] == 0) break;
        }
        return s.charAt(pri) + removeDuplicateLetters(s.substring(pri + 1).replaceAll("" + s.charAt(pri), ""));
    }
    public static void main(String args[]){
        String s = "cbacdcbc";
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters(s));
    }
}
