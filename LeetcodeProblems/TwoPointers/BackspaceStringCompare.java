package TwoPointers;

import java.util.ArrayList;

/**
 * Created by sjwang on 07/12/2018.
 *
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 *
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Note:
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 *
 * Follow up:
 * Can you solve it in O(N) time and O(1) space?
 *
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray(), t = T.toCharArray();
        return simp(s).equals(simp(t));
    }

    public String simp(char[] chs){
        ArrayList<Character> L = new ArrayList<>();
        for(int i = 0; i < chs.length; i ++){
            if(chs[i] != '#') L.add(chs[i]);
            else{
                if(L.size() > 0)
                    L.remove(L.size()  - 1);
            }
        }
        return L.toString();
    }

    public static void main(String args[]){
        String S = "ab#c", T = "ad#c";
        System.out.println(new BackspaceStringCompare().backspaceCompare(S, T));
    }
}
