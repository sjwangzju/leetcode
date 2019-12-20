package FullTime.LinkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShortestWordDistance {

    /**
     * Shortest Word Distance I (call one time - word1 & word2 are different)
     *
     * Example:
     *
     * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
     *
     * Input: word1 = “coding”, word2 = “practice”
     * Output: 3
     *
     * Input: word1 = "makes", word2 = "coding"
     * Output: 1
     *
     * Thoughts:
     * 1. use i, j to record the position of word1 and word2
     * 2. keep updating i, j, and shortest distance
     *
     * time: O(N), N is num of words
     * space: O(1)
     *
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int i = -1, j = -1, res = Integer.MAX_VALUE;
        for (int k = 0; k < words.length; k++) {
            if (words[k].equals(word1)) {
                i = k;
                if (j != -1) {
                    res = Math.min(res, i - j);
                }
            }
            else if (words[k].equals(word2)) {
                j = k;
                if (i != -1) {
                    res = Math.min(res, j - i);
                }
            }
        }
        return res;
    }

    /**
     * Shortest Word Distance II (call multiple times with different words)
     *
     * Thoughts:
     * 1. record the indexes of each word in a map
     * 2. two pointers to search two index lists, get shortest distance
     *    l1.get(i) < l2.get(j) -> i++
     *    else                  -> j++
     *
     *
     * time: O(N), N is num of words
     * space: O(N)
     *
     */
    static class WordDistanceII {

        Map<String, List<Integer>> map = new HashMap<>();

        public WordDistanceII(String[] words) {
            this.map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                map.putIfAbsent(words[i], new ArrayList<>());
                map.get(words[i]).add(i);
            }
        }

        // time: O(l1 + l2)
        public int shortest(String word1, String word2) {
            int i = 0, j = 0, res = Integer.MAX_VALUE;
            List<Integer> l1 = map.get(word1);
            List<Integer> l2 = map.get(word2);

            while (i < l1.size() && j < l2.size()) {
                res = Math.min(res, Math.abs(l1.get(i) - l2.get(j)));
                if (l1.get(i) < l2.get(j)) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }
    }



    /**
     * Shortest Word Distance III (word1 & word2 may be the same)
     *
     * time: O(N), N is num of words
     * space: O(1)
     *
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int i = -1, j = -1, res = Integer.MAX_VALUE;
        for (int k = 0; k < words.length; k++) {
            if (words[k].equals(word1)) {
                if (word2.equals(word1)) {
                    if (i != -1) {
                        res = Math.min(res, k - i);
                    }
                } else if (j != -1) {
                    res = Math.min(res, k - j);
                }
                i = k;
            }
            else if (words[k].equals(word2)) {
                if (word2.equals(word1)) {
                    if (j != -1) {
                        res = Math.min(res, k - j);
                    }
                } else if (i != -1) {
                    res = Math.min(res, k - i);
                }
                j = k;
            }
        }
        return res;
    }

}
