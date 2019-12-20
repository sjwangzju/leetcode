package FullTime.Facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    // Given a string containing digits from 2-9 inclusive,
    // return all possible letter combinations that the number could represent.
    //
    // Input: "23"
    // Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
    //
    // backtracking
    // time: O(3^N * 4^M), space: O(3^N * 4^M)
    Map<Character, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        map.put('2', "abc"); map.put('3', "def");
        map.put('4', "ghi"); map.put('5', "jkl");
        map.put('6', "mno"); map.put('7', "pqrs");
        map.put('8', "tuv"); map.put('9', "wxyz");
        if (digits == null || digits.length() == 0) return res;
        backtracking(new StringBuilder(), digits, 0);
        return res;
    }

    public void backtracking(StringBuilder s, String digits, int index) {
        if (index == digits.length()) {
            res.add(s.toString());
            return;
        }
        String tmp = map.get(digits.charAt(index));
        for (char c: tmp.toCharArray()) {
            s.append(c);
            backtracking(s, digits, index + 1);
            s.deleteCharAt(s.length() - 1);
        }
    }

}
