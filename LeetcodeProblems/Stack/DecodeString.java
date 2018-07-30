package Stack;

import java.util.Stack;

/**
 * Created by sjwang on 07/30/2018.
 *
 * Given an encoded string, return it's decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<Integer> num = new Stack<>();
        Stack<String> letter = new Stack<>();
        String re = "";
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int sum = 0;
            if(cur >= '0' && cur <= '9') {
                while(cur >= '0' && cur <= '9'){
                    sum = 10 * sum + cur - '0';
                    i ++;
                    cur = s.charAt(i);
                }
                num.push(sum);
                letter.push("");
            }
            if(cur == '[') continue;
            if(cur >= 'a' && cur <= 'z' || cur >= 'A' && cur <= 'Z') letter.push(cur + "");
            if(cur == ']') {
                String temp = ""; int n = num.pop();
                while(!letter.peek().equals("")) temp = letter.pop() + temp;
                letter.pop();
                String add = "";
                for(int j = 0; j < n; j++) add = add + temp;
                if(num.isEmpty()) letter.push(re + add);
                else letter.push(add);
            }
        }
        while(!letter.isEmpty()) re = letter.pop() + re;
        return re;
    }
    public static void main(String args[]){
        String s = "sd2[f2[e]g]i";
        System.out.println(new DecodeString().decodeString(s));
    }
}