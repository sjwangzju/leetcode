package FullTime.FB;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Backtracking
 *
 * time: O(3^N+4^M), (N+M) is len of digits
 * space: O(3^N+4^M)
 */
public class LC17_LetterCombinationsOfAPhoneNumber_M {

    Map<Character, String> map = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) return res;
        backtracking(res, new StringBuilder(), 0, digits);
        return res;
    }

    public void backtracking(List<String> res, StringBuilder cur, int i, String digits) {
        if (i == digits.length()) {
            res.add(cur.toString());
            return;
        }
        String s = map.get(digits.charAt(i));
        for (int j = 0; j < s.length(); j++) {
            cur.append(s.charAt(j));
            backtracking(res, cur, i + 1, digits);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        String digits = "23";
        List<String> list = new LC17_LetterCombinationsOfAPhoneNumber_M().letterCombinations(digits);
        for (String s: list) {
            System.out.println(s);
        }
    }
}
