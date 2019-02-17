package Amazon;

import java.util.HashSet;
import java.util.Set;

public class LongestRepeatedSubstring {

    /**
     * time: O(n^2), space: O(n^2)
     * @param s
     * @return
     */
    public String findAllSubstring(String s) {
        Set<String> set = new HashSet<>();
        String res = "";
        int max = -1;

        for (int i = 0; i < s.length(); i++) {
            String cur = "";
            for (int j = i; j < s.length(); j++) {
                cur += s.charAt(j);
                if (set.contains(cur) && cur.length() > max) {
                    res = cur;
                    max = cur.length();
                } else {
                    set.add(cur);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "tomato";
        System.out.println(new LongestRepeatedSubstring().findAllSubstring(s));
    }
}
