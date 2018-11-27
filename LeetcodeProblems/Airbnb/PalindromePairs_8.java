package Airbnb;

import java.util.*;

/**
 * time complexity: O(nL^2), L is the mean length of word, n is the num of words.
 */
public class PalindromePairs_8 {
    public List<List<Integer>> findPairs(String[] input) {
        List<List<Integer>> res = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            map.put(reverse(input[i]), i);
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length(); j++) {
                String prefix = input[i].substring(0, j + 1);
                String surfix = input[i].substring(j + 1);
                if (isPalindrome(prefix) && surfix.equals("") && map.containsKey("")) {
                    List<Integer> cur = new LinkedList<>();
                    cur.add(i);
                    cur.add(map.get(surfix));
                    res.add(cur);
                } else if (map.containsKey(prefix) && isPalindrome(surfix) && map.get(prefix) != i) {
                    List<Integer> cur = new LinkedList<>();
                    cur.add(i);
                    cur.add(map.get(prefix));
                    res.add(cur);
                }

            }
            for (int j = input[i].length() - 1; j >= 0; j--) {
                String prefix = input[i].substring(0, j + 1);
                String surfix = input[i].substring(j + 1);
                if (map.containsKey(surfix) && isPalindrome(prefix) && map.get(surfix) != i) {
                    List<Integer> cur = new LinkedList<>();
                    cur.add(map.get(surfix));
                    cur.add(i);
                    res.add(cur);
                } else if (isPalindrome(surfix) && prefix.equals("") && map.containsKey("")) {
                    List<Integer> cur = new LinkedList<>();
                    cur.add(map.get(prefix));
                    cur.add(i);
                    res.add(cur);
                }
            }
        }

        return res;
    }

    public String reverse(String s) {
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length / 2; i++) {
            char tmp = chs[i];
            chs[i] = chs[chs.length - 1 - i];
            chs[chs.length - 1 - i] = tmp;
        }
        return String.valueOf(chs);
    }

    public boolean isPalindrome(String s) {
        return s.equals(reverse(s));
    }

    public static void main(String[] args) {
//        String[] s1 = {"abcd", "dcba", "lls", "s", "sssll"};
        String[] s2 = {"a", ""};
        List<List<Integer>> res = new PalindromePairs_8().findPairs(s2);

        for (List<Integer> list: res) {
            System.out.print(list.get(0) + "  ");
            System.out.print(list.get(1));
            System.out.println();
        }
    }
}
