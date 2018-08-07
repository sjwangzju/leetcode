package DynamicProgramming;

/**
 * Created by sjwang on 08/07/2018.
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        int n1 = 1, n2 = 1;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '0') n1 = 0;
            if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                n1 = n1 + n2;
                n2 = n1 - n2;
            }else {
                n2 = n1;
            }
        }
        return n1;
    }
    public static void main(String args[]){
        String s = "206";
        System.out.println(new DecodeWays().numDecodings(s));
    }
}
