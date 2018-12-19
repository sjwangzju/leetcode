package FB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

    /**
     * recursive, time: O(3^N), N is the len of digits; space: O(N^2)
     * @param digits
     * @param dict
     * @return
     */
    public List<String> findCombinations(String digits, Map<Character, char[]> dict) {
        List<String> res = new ArrayList<>();
        recursive(res, "", digits, 0, dict);
        return res;
    }

    public void recursive(List<String> res, String str, String digits, int index, Map<Character, char[]> dict) {
        if (str.length() == digits.length()) {
            res.add(str);
            return;
        }
        for (char ch: dict.get(digits.charAt(index))) {
            recursive(res, str + ch, digits, index + 1, dict);
        }
    }

    public static void main(String[] args) {
        Map<Character, char[]> dict = new HashMap<>();
        char[] ch1 = {'A','B','C'};
        char[] ch2 = {'D','E','F'};
        char[] ch3 = {'G','H','I'};
        char[] ch4 = {'J','K','L'};
        dict.put('1', ch1);
        dict.put('2', ch2);
        dict.put('3', ch3);
        dict.put('4', ch4);
        List<String> res = new LetterCombinationsOfPhoneNumber().findCombinations("321",dict);
        for (String s: res) {
            System.out.println(s);
        }
    }
}
