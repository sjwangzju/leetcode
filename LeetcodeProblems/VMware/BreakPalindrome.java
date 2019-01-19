package VMware;

public class BreakPalindrome {
    public String breakPalindrome(String s) {
        char[] res = s.toCharArray();
        for (int i = 0; i <= s.length() / 2 - 1; i++) {
            if (s.charAt(i) != 'a') {
                res[i] = 'a';
                return String.valueOf(res);
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {
        String s = "bab";
        System.out.println(new BreakPalindrome().breakPalindrome(s));
    }
}
