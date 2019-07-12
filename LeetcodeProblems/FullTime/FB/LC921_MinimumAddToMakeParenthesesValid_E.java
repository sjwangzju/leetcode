package FullTime.FB;

/**
 * time: O(N)
 * space: O(1)
 */
public class LC921_MinimumAddToMakeParenthesesValid_E {

    public int minAddToMakeValid(String S) {
        if (S == null || S.length() == 0) return 0;
        int cnt = 0, left = 0;

        for (char ch: S.toCharArray()) {
            if (ch == '(') {
                left++;
                continue;
            }
            if (left > 0) {
                left--;
            } else {
                cnt++;
            }
        }
        return cnt + left;
    }

    public static void main(String[] args) {
        String S = "()))((";
        System.out.println(new LC921_MinimumAddToMakeParenthesesValid_E().minAddToMakeValid(S));
    }
}
