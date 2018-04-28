package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjwang on 28/04/2018.
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 */

public class RomanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> M = new HashMap<>();
        M.put('I', 1); M.put('V', 5); M.put('X', 10); M.put('L', 50);
        M.put('C', 100); M.put('D', 500); M.put('M', 1000);

        char[] chs = s.toCharArray();
        int sum = 0, i = 0, temp, val = 0;
        while(i < chs.length){
            temp = M.get(chs[i]);
            if(temp == val * 5 || temp == val * 10){
                sum += (temp - 2 * val);
                val = 0;
            }
            else{
                val = temp;
                sum += temp;
            }
            i += 1;
        }
        return sum;
    }

    public static void main(String args[]){
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }

}
