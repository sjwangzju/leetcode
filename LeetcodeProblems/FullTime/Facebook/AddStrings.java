package FullTime.Facebook;

public class AddStrings {

    // input: "101", "909"
    // output: "1010"
    //
    // time: O(M+N), space: O(M+N)
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();

        int i = num1.length() - 1, j = num2.length() - 1;
        int prev = 0, cur = 0;

        while (i >= 0 || j >= 0) {
            cur = prev;
            if (i >= 0) {
                cur += num1.charAt(i--) - '0';
            }
            if (j >= 0) {
                cur += num2.charAt(j--) - '0';
            }
            prev = cur / 10;
            cur %= 10;
            res.insert(0, cur);
        }
        if (prev != 0) res.insert(0, prev);
        return res.toString();
    }
}
