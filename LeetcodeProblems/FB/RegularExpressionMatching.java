package FB;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if (p.length() == 0 || p == null) {
            return s.length() == 0 || s == null;
        }
        if (p.length() == 1 || p.charAt(1) != '*') {
            return s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')
                    && isMatch(s.substring(1), p.substring(1));
        }
        return isMatch(s, p.substring(2)) ||
                s.length() > 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') && isMatch(s.substring(1), p);
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.println(new RegularExpressionMatching().isMatch(s, p));
    }
}
