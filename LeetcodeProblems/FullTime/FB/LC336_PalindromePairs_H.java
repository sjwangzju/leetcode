package FullTime.FB;

//Given a list of unique words, find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
//
//Example 1:
//Input: ["abcd","dcba","lls","s","sssll"]
//Output: [[0,1],[1,0],[3,2],[2,4]]
//Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]

//Example 2:
//Input: ["bat","tab","cat"]
//Output: [[0,1],[1,0]]
//Explanation: The palindromes are ["battab","tabbat"]

import java.util.*;

/**
 * time: O(N*L^2)
 * space: O(N)
 */
public class LC336_PalindromePairs_H {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                // s1 in middle, s2 in right
                if (isPalindrome(s1)) {
                    String s2Reverse = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2Reverse) && map.get(s2Reverse) != i) {
                        res.add(Arrays.asList(map.get(s2Reverse), i));
                    }
                }
                // s2 in middle, s1 in left
                if (isPalindrome(s2) &&  s2.length() != 0) {
                    String s1Reverse = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1Reverse) && map.get(s1Reverse) != i) {
                        res.add(Arrays.asList(i, map.get(s1Reverse)));
                    }
                }
            }
        }
        return res;
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcd","dcba","lls","s","sssll"};
        List<List<Integer>> res = new LC336_PalindromePairs_H().palindromePairs(words);

        for (List<Integer> list: res) {
            System.out.println(list.get(0) + ", " + list.get(1));
        }
    }
}
