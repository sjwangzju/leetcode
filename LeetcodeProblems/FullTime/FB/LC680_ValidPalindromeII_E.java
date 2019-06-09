package FullTime.FB;

/**
 * Two Pointers + Recursive
 *
 * time: O(N)
 * space: O(1)
 *
 */
public class LC680_ValidPalindromeII_E {

    public boolean validPalindrome(String s) {
        return isValid(s, 0, s.length() - 1, true);
    }

    public boolean isValid(String s, int i, int j, boolean flag) {
        if (i >= j) return true;
        char ch1 = s.charAt(i);
        char ch2 = s.charAt(j);

        if (ch1 == ch2) {
            return isValid(s, i + 1, j - 1, flag);
        }
        if (!flag) return false;
        return isValid(s, i + 1, j, false) || isValid(s, i, j - 1, false);
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(new LC680_ValidPalindromeII_E().validPalindrome(s));
    }
}
