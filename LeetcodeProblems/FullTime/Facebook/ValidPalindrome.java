package FullTime.Facebook;

public class ValidPalindrome {


    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
    //
    // Input: "A man, a plan, a canal: Panama"
    // Output: true
    //
    // time: O(N), space: O(1)
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char c1 = Character.toLowerCase(s.charAt(i));
            char c2 = Character.toLowerCase(s.charAt(j));
            if (!(Character.isLetter(c1) || Character.isDigit(c1))) {
                i++;
            }
            else if (!(Character.isLetter(c2) || Character.isDigit(c2))) {
                j--;
            }
            else {
                if (c1 != c2) return false;
                i++;
                j--;
            }
        }
        return true;
    }


    // Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
    //
    // Input: "abca"
    // Output: True
    // Explanation: You could delete the character 'c'.
    //
    // time: O(N), space: O(1)
    public boolean validPalindromeII(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "acbba";
        System.out.println(new ValidPalindrome().validPalindromeII(s));
    }
}
