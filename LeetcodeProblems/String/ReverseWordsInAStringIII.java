package String;

import java.lang.reflect.Array;

/**
 * Created by sjwang on 25/04/2018.
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

public class ReverseWordsInAStringIII {

    public String reverseWords(String s) {
        String[] arr = s.split("\\s");
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < arr.length; i ++){
            String ss = reverseWord(arr[i]);
            if(i == arr.length - 1){
                sb.append(ss);
            }
            else{
                sb.append(ss + " ");
            }
        }
        return sb.toString();
    }

    private static String reverseWord(String s){
        char[] chs = s.toCharArray();
        for(int i = 0; i < s.length() / 2; i++){
            char temp = chs[i];
            chs[i] = chs[s.length() - 1 - i];
            chs[s.length() - 1 - i] = temp;
        }
        return new String(chs);
    }

    public static void main(String args[]){
        String str = "Let's take LeetCode contest";
        System.out.println(new ReverseWordsInAStringIII().reverseWords(str));
    }
}
