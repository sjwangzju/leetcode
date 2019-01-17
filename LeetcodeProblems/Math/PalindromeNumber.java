package Math;

/**
 * Created by sjwang on 30/04/2018.
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:
 *
 * Input: 121
 * Output: true
 * Example 2:
 *
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x == 0) return true;
        int temp = x, sum = 0, digit;
        while(x != 0){
            digit = x % 10;
            sum = sum * 10 + digit;
            x /= 10;
        }
        return sum == temp;
    }

    public static void main(String args[]) {
        System.out.println(new PalindromeNumber().isPalindrome(2147483647));
    }
}
