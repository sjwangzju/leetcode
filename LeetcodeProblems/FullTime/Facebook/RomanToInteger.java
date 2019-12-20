package FullTime.Facebook;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    /**
     * Roman to Integer
     *
     * e.g.
     * Input: "III"
     * Output: 3
     *
     * time: O(N), space: O(1)
     */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5);
        map.put('X', 10); map.put('L', 50);
        map.put('C', 100); map.put('D', 500);
        map.put('M', 1000);

        int res = 0, n1 = 0, n2 = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            n1 = map.get(s.charAt(i));
            n2 = map.get(s.charAt(i + 1));
            res += n1 >= n2? n1: -n1;
        }
        return res + map.get(s.charAt(s.length() - 1));
    }

    /**
     * Integer to Roman
     *
     * e.g.
     * Input: "LVIII"
     * Output: 58
     *
     * time: O(N), space: O(1)
     */
    public String intToRoman(int num) {
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] vals = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        StringBuilder res = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num >= vals[i]) {
                num -= vals[i];
                res.append(strs[i]);
            } else {
                i++;
            }
        }
        return res.toString();
    }
}
