package FullTime.OCI;

public class DecodeString {

    // Given an encoded string, return its decoded string.
    //
    // s = "3[a]2[bc]", return "aaabcbc".
    // s = "3[a2[c]]", return "accaccacc".
    // s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
    //
    // You may assume that the input string is always valid;
    // No extra white spaces, square brackets are well-formed, etc.
    //
    // DFS
    // time: O(N), space: O(N)
    int i = 0;
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        StringBuilder res = new StringBuilder();
        int sum = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sum = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    sum *= 10;
                    sum += s.charAt(i + 1) - '0';
                    i++;
                }
                i++;
            }
            else if (Character.isLetter(c)) {
                i++;
                res.append(c);
            }
            else if (c == '[') {
                i++;
                String next = decodeString(s);
                for (int k = 0; k < sum; k++) {
                    res.append(next);
                }
            }
            else if (c == ']') {
                i++;
                break;
            }
        }
        return res.toString();
    }
}
