package FullTime.Google;

import java.util.*;

public class StringTransformsIntoAnotherString {

    // time: O(N), space: O(1)
    // Note: Need one extra character
    // eg1(LinkedList): a->b->c => b->c, a->b
    // eg2(cycle):      a->b->a => a->tmp, b->a, tmp->b
    public boolean canConvert(String str1, String str2) {
        if (str1.equals(str2)) return true;
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i), c2 = str2.charAt(i);
            if (map.containsKey(c1) && map.get(c1) != c2) return false;
            map.put(c1, c2);
        }
        return new HashSet<>(map.values()).size() < 26;
    }

    public static void main(String[] args) {
        String str1 = "aabcc", str2 = "ccdee";
        System.out.println(new StringTransformsIntoAnotherString().canConvert(str1, str2));
    }
}
