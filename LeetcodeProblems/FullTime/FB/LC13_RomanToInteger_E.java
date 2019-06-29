package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

/**
 * time: O(N)
 * space: O(1)
 */
public class LC13_RomanToInteger_E {

    public int romanToInt(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I',1);
        dict.put('V',5);
        dict.put('X',10);
        dict.put('L',50);
        dict.put('C',100);
        dict.put('D',500);
        dict.put('M',1000);

        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (dict.get(s.charAt(i)) < dict.get(s.charAt(i + 1))) {
                res -= dict.get(s.charAt(i));
            } else {
                res += dict.get(s.charAt(i));
            }
        }
        return res + dict.get(s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(new LC13_RomanToInteger_E().romanToInt(s));
    }
}
