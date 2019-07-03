package FullTime.FB;

/**
 * DFS
 *
 * time: O(N)
 * space: O(k), k is the max depth of brackets
 */
public class LC394_DecodeString_M {

    int tmp = 0;
    public String decodeString(String s) {
        return dfs(s, 0);
    }

    public String dfs(String s, int index) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        for (int i = index; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num *= 10;
                    num += s.charAt(i + 1) - '0';
                    i++;
                }
            }
            else if (Character.isLetter(ch)) {
                sb.append(ch);
            }
            else if (ch == '[') {
                String str = dfs(s, i + 1);
                for (int j = 0; j < num; j++) {
                    sb.append(str);
                }
                i = tmp;
            }
            else if (ch == ']') {
                tmp = i;
                return sb.toString();
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(new LC394_DecodeString_M().decodeString(s));
    }
}
