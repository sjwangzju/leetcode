package BackTracking;

import java.util.LinkedList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 */
public class LetterCombinationsOfAPhoneNumber {

    public String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        if(digits == null || digits.length() == 0) return res;
        backTracking(res, digits, "", 0);
        return res;
    }

    public void backTracking(List<String> res, String digits, String cur, int index) {
        if (index >= digits.length()) {
            res.add(cur);
            return;
        }

        String s = map[digits.charAt(index) - '0'];
        for (int i = 0; i < s.length(); i++) {
            backTracking(res, digits, cur + s.charAt(i), index + 1);
        }
    }

    public static void main(String args[]) {
        List<String> result = new LetterCombinationsOfAPhoneNumber().letterCombinations("232");
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
