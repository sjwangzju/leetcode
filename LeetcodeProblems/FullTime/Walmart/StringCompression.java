package FullTime.Walmart;

public class StringCompression {

    // time: O(N), space: O(1)
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) return 0;
        int i = 0, j = 0;
        while (j < chars.length) {
            char ch = chars[j];
            int cnt = 0;
            while (j < chars.length && chars[j] == ch) {
                j++;
                cnt++;
            }
            chars[i++] = ch;
            if (cnt > 1) {
                for (char c: Integer.toString(cnt).toCharArray()) {
                    chars[i++] = c;
                }
            }
        }
        return i;
    }
}
