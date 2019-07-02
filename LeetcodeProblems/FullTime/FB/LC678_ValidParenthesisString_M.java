package FullTime.FB;

/**
 * min - the num of '(' must be paired, max - the max num of '(' can be paired
 *
 * time: O(N)
 * space: O(1)
 */
public class LC678_ValidParenthesisString_M {

    public boolean checkValidString(String s) {
        if (s == null || s.length() == 0) return true;

        int min = 0, max = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                min++;
                max++;
            } else if (ch == ')') {
                min = Math.max(min - 1, 0);
                max--;
            } else {
                min = Math.max(min - 1, 0);
                max++;
            }
            if (max < 0) return false;
        }
        return min == 0;
    }

    public static void main(String[] args) {
        String s = "(*))*)";
        System.out.println(new LC678_ValidParenthesisString_M().checkValidString(s));
    }
}
