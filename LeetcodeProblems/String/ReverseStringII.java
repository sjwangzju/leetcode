package String;

/**
 * Created by sjwang on 05/05/2018.
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string.
 * If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */

public class ReverseStringII {
    public String reverseStr(String s, int k) {
        int num = s.length() / (2 * k), rest = s.length() % (2 * k), start, end;
        if(rest >= k) num ++;
        for(int i = 0; i < num; i ++){
            start = 2 * i * k;
            end  = start + k - 1;
            String str= re(s.substring(start, end + 1));
            s = s.substring(0, start) + str + s.substring(end + 1, s.length());
        }
        if(rest < k) {
            start = s.length() - rest;
            end = s.length() - 1;
            String str= re(s.substring(start, end + 1));
            s = s.substring(0, start) + str;
        }
        return s;
    }

    public String re(String s) {
        char[] chs = s.toCharArray();
        for(int i = 0; i < s.length() / 2; i ++){
            char temp = chs[i];
            chs[i] = chs[s.length() - 1 - i];
            chs[s.length() - 1 - i] = temp;
        }
        return new String(chs);
    }

    public static void main(String args[]){
        String str = "abcdefgt";
        System.out.println(new ReverseStringII().reverseStr(str, 3));
    }
}
