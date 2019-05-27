package FullTime.FB;

/**
 * compare word by word, char by char
 *
 * time: O(N), N is the num of total chars in all words
 * space: O(1)
 */
public class LC953_VerifyingAnAlienDictionary_E {

    public boolean isAlienSorted(String[] words, String order) {
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];
            if (!compare(w1, w2, order)) return false;
        }
        return true;
    }

    public boolean compare(String word1, String word2, String order) {
        int len = Math.min(word1.length(), word2.length());
        for (int i = 0; i < len; i++) {
            int i1 = order.indexOf(word1.charAt(i));
            int i2 = order.indexOf(word2.charAt(i));
            if (i1 > i2) return false;
            if (i1 < i2) return true;
        }
        return word1.length() < word2.length();
    }

    public static void main(String[] args) {
        String[] words = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(new LC953_VerifyingAnAlienDictionary_E().isAlienSorted(words, order));
    }
}
