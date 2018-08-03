package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 08/03/2018
 *
 * Given an input string, reverse the string word by word.
 *
 * Example:
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 *
 * Note:
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        List<String> L = new ArrayList<>();
        String temp = "", re;
        char[] chs = s.toCharArray();
        for(int i = 0; i < chs.length; i++) {
            if(chs[i] == ' ') {
                if(temp != "") L.add(temp);
                temp = "";
                continue;
            }
            temp += chs[i];
            if(i == chs.length - 1 && temp != "") L.add(temp);
        }
        if(L.size() == 0) return "";
        re = L.get(0);
        for(int i = 1; i < L.size(); i++) {
            re = L.get(i) + " " + re;
        }
        return re;
    }
    public static void main(String args[]){
        String s = "    ";
        System.out.println(new ReverseWordsInAString().reverseWords(s).length());
    }
}
