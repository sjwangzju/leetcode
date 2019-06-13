package FullTime.FB;

/**
 * compare substring
 *
 * time: O(N)
 * space: O(1)
 */
public class LC161_OneEditDistance_M {

    public boolean isOneEditDistance(String s, String t) {
        int lt = t.length();
        int ls = s.length();

        if (Math.abs(lt - ls) > 1) return false;
        if (lt < ls) {
            return isOneEditDistance(t, s);
        }
        for (int i = 0; i < ls; i++) {
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if (ch1 != ch2) {
                if (ls == lt) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                } else {
                    return s.substring(i).equals(t.substring(i + 1));
                }
            }
        }
        return lt == ls + 1;
    }

    public static void main(String[] args) {
        String s = "";
        String t = "a";
        System.out.println(new LC161_OneEditDistance_M().isOneEditDistance(s, t));
    }
}
