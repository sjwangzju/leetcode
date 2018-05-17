package String;

/**
 * Created by sjwang on 05/17/2018.
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * Example:
 * Input: "Hello World"
 * Output: 5
 */

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        int i = s.length() - 1, len = 0;
        while(s.charAt(i) != ' '){
            len ++;
            if(i == 0) break;
            i --;
        }
        return len;
    }

    public static void main(String args[]){
        String s = " ";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
    }
}
