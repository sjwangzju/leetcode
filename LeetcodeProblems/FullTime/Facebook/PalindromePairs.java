package FullTime.Facebook;

import java.util.*;

public class PalindromePairs {

    // Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
    // so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
    //
    // Input: ["abcd","dcba","lls","s","sssll"]
    // Output: [[0,1],[1,0],[3,2],[2,4]]
    // Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
    //
    // time: O(N*L^2), L is avg len of word
    // space: O(N)
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);

                if (isPalindrome(s1)) {
                    String rs2 = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(rs2) && map.get(rs2) != i) {
                        res.add(Arrays.asList(map.get(rs2), i));
                    }
                }

                if (s2.length() > 0 && isPalindrome(s2)) {
                    String rs1 = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(rs1) && map.get(rs1) != i) {
                        res.add(Arrays.asList(i, map.get(rs1)));
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            char c1 = s.charAt(i++), c2 = s.charAt(j--);
            if (c1 != c2) return false;
        }
        return true;
    }
}
