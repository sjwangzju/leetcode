package FullTime.OCI;

public class ShortestWordDistance {

    // Given a list of words and two words word1 and word2,
    // return the shortest distance between these two words in the list.
    //
    // Example:
    // Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
    //
    // Input: word1 = "makes", word2 = "coding"
    // Output: 1
    //
    // time: O(N), space: O(1)
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
}
