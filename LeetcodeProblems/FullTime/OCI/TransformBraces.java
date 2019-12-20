package FullTime.OCI;

public class TransformBraces {

    // transform rules:
    // 1. matched braces -> '0'
    // 2. unmatched '('  -> '1'
    // 3. unmatched ')'  -> '-1'
    //
    // e.g. ")21(21)a1(" ->  "-1210210a11"
    //
    // Thoughts:
    // 1. two passes:
    //      a. record the num of left and right braces
    //      b. transform matched braces into '0'
    // 2. remain unmatched braces -> transform them in the third pass
    //
    // time: O(N), space: O(N)
    public String transform(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder tmp = new StringBuilder();

        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' && left > 0) {
                tmp.append('0');
                left--;
            } else {
                if (c == '(') left++;
                tmp.append(c);
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '(' && right > 0) {
                tmp.setCharAt(i, '0');
                right--;
            } else if (c == ')') {
                right++;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < tmp.length(); i++) {
            char c = tmp.charAt(i);
            if (c == '(') {
                res.append('1');
            } else if (c == ')') {
                res.append("-1");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "(((456))";
        System.out.println(new TransformBraces().transform(s));
    }
}
