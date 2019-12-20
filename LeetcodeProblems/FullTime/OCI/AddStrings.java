package FullTime.OCI;

public class AddStrings {

    // Given two non-negative integers num1 and num2 represented as string,
    // return the sum of num1 and num2.
    //
    // Both num1 and num2 contains only digits 0-9.
    // Both num1 and num2 does not contain any leading zero.
    //
    // time: O(m+n), space: O(1)
    public String addStrings(String num1, String num2) {
        int prev = 0, i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder res = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int cur = prev;
            if (i >= 0) cur += num1.charAt(i--) - '0';
            if (j >= 0) cur += num2.charAt(j--) - '0';
            prev = cur / 10;
            cur %= 10;
            res.append(cur);
        }
        if (prev != 0) res.append(prev);
        return res.reverse().toString();
    }
}
