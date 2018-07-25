package String;

import java.util.Stack;

/**
 * Created by sjwang on 07/25/2018.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null) return true;
        Stack<Character> S = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i), ch2;
            if(S.isEmpty()) S.push(ch1);
            else{
                ch2 = S.peek();
                if(ch2 == '(' && ch1 == ')' || ch2 == '{' && ch1 == '}' || ch2 == '[' && ch1 == ']') S.pop();
                else S.push(ch1);
            }
        }
        return (S.isEmpty());
    }
    public static void main(String args[]){
        String s = "{()[]}";
        System.out.println(new ValidParentheses().isValid(s));
    }
}
