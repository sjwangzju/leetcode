package FB;

public class LC680ValidPalindromeII {

    /**
     * time: O(N), space: O(1)
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1);
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "cbbcc";
        System.out.println(new LC680ValidPalindromeII().validPalindrome(s));
    }
}
