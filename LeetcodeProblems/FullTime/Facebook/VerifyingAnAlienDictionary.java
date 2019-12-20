package FullTime.Facebook;

public class VerifyingAnAlienDictionary {

    // Given a sequence of words written in the alien language, and the order of the alphabet,
    // return true if and only if the given words are sorted lexicographicaly in this alien language.
    // All characters in words[i] and order are English lowercase letters.
    //
    // Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
    // Output: false
    //
    // Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
    // Output: false
    //
    // time: O(n*l), l is the avg len of words
    // space: O(1)
    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1], word2 = words[i];
            if (!isValid(order, word1, word2)) return false;
        }
        return true;
    }

    public boolean isValid(String order, String word1, String word2) {
        int i = 0, j = 0;
        while (i < word1.length() && j < word2.length()) {
            int n1 = order.indexOf(word1.charAt(i++));
            int n2 = order.indexOf(word2.charAt(j++));
            if (n1 > n2) {
                return false;
            } else if (n1 < n2) {
                return true;
            }
        }
        return i == word1.length();
    }

    public static void main(String[] args) {
        String[] words1 = {"","cat","ca"};
        String[] words2 = {"","ca","cat"};
        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(words1, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(words2, "abcdefghijklmnopqrstuvwxyz"));
    }
}
