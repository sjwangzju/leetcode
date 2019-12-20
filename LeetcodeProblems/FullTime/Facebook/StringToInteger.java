package FullTime.Facebook;

public class StringToInteger {

    // converts a string to an integer
    //
    // Input: "   -42"
    // Output: -42
    //
    // time: O(N), space: O(1)
    public int myAtoi(String str) {
        str = str.trim();
        if (str.length() == 0) return 0;
        char c = str.charAt(0);
        int sign = 1, start = 0;
        if (!Character.isDigit(c)) {
            if (c == '+' || c == '-') {
                sign = c == '+'? 1: -1;
                start = 1;
            }
        }
        return getNum(start, sign, str);
    }

    public int getNum(int start, int sign, String str) {
        long sum = 0;
        for (int i = start; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                break;
            }
            sum = sum * 10 + c - '0';
            if (sum > Integer.MAX_VALUE) {
                return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }
        }
        return (int)sum * sign;
    }
}
