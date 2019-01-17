package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjwang on 06/05/2018.
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 * Note:
 * The vowels does not include the letter "y".
 */

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] chs = s.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        map1.put('a', 1); map1.put('e', 1); map1.put('i', 1); map1.put('o', 1); map1.put('u', 1);
        map1.put('A', 1); map1.put('E', 1); map1.put('I', 1); map1.put('O', 1); map1.put('U', 1);
        int[] a = new int[chs.length];
        int l = 0;
        for(int i = 0; i < chs.length; i ++) {
            if(map1.containsKey(chs[i])){
                a[l] = i; l ++;
            }
        }
        for(int i = 0; i < l / 2; i ++){
            char temp = chs[a[i]];
            chs[a[i]] = chs[a[l - 1 - i]];
            chs[a[l - 1 - i]] = temp;
        }
        return new String(chs);
    }

    public static void main(String args[]){
        String str = "hello";
        System.out.println(new ReverseVowelsOfAString().reverseVowels(str));
    }
}
