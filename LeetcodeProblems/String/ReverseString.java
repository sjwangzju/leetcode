package String;

/**
 * Created by sjwang on 23/04/2018.
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 */

public class ReverseString {

    public String reverseString(String s) {
        char[] chs = s.toCharArray();
        for(int i = 0; i < s.length() / 2; i ++){
            char ch = chs[i];
            chs[i] = chs[s.length() - 1 - i];
            chs[s.length() - 1 - i] = ch;
        }
        return new String(chs);
    }

    public static void main(String args[]){
        String str = "applee.";
        System.out.println(new ReverseString().reverseString(str));
    }
}
