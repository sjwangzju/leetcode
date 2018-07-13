package TwoPointers;

/**
 * Created by sjwang on 07/13/2018.
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 *
 * Example 2:
 * Input: "race a car"
 * Output: false
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char[] chs = s.toCharArray();
        int i = 0, j = chs.length - 1;
        while(i < j){
            char c1 = Character.toLowerCase(chs[i]), c2 = Character.toLowerCase(chs[j]);
            if(isValid(c1) && isValid(c2)){
                if(c1 != c2) return false;
                i++; j--;
            }
            else if(isValid(c1)) j--;
            else if(isValid(c2)) i++;
            else {
                i++; j--;
            }
        }
        return i >= j;
    }

    public boolean isValid(char ch){
        return Character.isDigit(ch) || Character.isLetter(ch);
    }

    public static void main(String args[]){
        String s = "A man, a plan, a canal: Panama";
        System.out.println(new ValidPalindrome().isPalindrome(s));
    }
}
