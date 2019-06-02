package FullTime.FB;

/**
 * two pointers
 *
 * time: O(N)
 * space: O(1)
 */
public class LC125_ValidPalindrome_E {

    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;

        s = s.trim();
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            char ch1 = s.charAt(l);
            char ch2 = s.charAt(r);

            if (!Character.isLetter(ch1) && !Character.isDigit(ch1)) {
                l++;
                continue;
            }

            if (!Character.isLetter(ch2) && !Character.isDigit(ch2)) {
                r--;
                continue;
            }

            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new LC125_ValidPalindrome_E().isPalindrome(s));
    }
}
