package VMware;

public class BreakPalindrome {
    public String breakPalindrome(String s) {
        if (s == null || s.length() == 0) return "IMPOSSIBLE";
        char[] res = s.toCharArray();
        for (int i = 0; i <= s.length() / 2 - 1; i++) {
            if (s.charAt(i) != 'a') {
                res[i] = 'a';
                return String.valueOf(res);
            }
        }
        res[s.length() - 1] = 'b';
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new BreakPalindrome().breakPalindrome(s));
    }
}
