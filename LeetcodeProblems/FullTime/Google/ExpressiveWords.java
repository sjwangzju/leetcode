package FullTime.Google;

public class ExpressiveWords {
    // two pointers
    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String word: words) {
            if (isValid(S, word)) res++;
        }
        return res;
    }

    // time: O(M+N), space: O(1)
    public boolean isValid(String S, String word) {
        int i = 0, j = 0;
        while (i < S.length()) {
            if (j == word.length()) break;
            if (S.charAt(i) != word.charAt(j)) return false;

            char c = S.charAt(i);
            int previ = i, prevj = j;
            while (i < S.length() && S.charAt(i) == c) i++;
            while (j < word.length() && word.charAt(j) == c) j++;

            int di = i - previ, dj = j - prevj;
            if (di == dj) continue;
            if (dj > di || di < 3) return false;
        }
        return i == S.length() && j == word.length();
    }
}
