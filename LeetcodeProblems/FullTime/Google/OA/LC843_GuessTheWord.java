package FullTime.Google.OA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC843_GuessTheWord {

    public class Master {
        // return the num of exact matches
        int guess(String word){return 0;}
    }

    public void findSecretWord(String[] wordlist, Master master) {
        if (wordlist == null || wordlist.length == 0) return;
        List<String> words = new ArrayList<>();

        for (String w: wordlist) words.add(w);
        Collections.sort(words);

        for (int i = 0; i < 10; i++) {
            int cur = master.guess(words.get(0));
            // success
            if (cur == 6) break;
            // continue guessing
            words = updateList(words, cur, words.get(0));
        }
    }

    // keep the potential words
    // potential words: have the same number of exact matches
    public List<String> updateList(List<String> words, int cur, String word) {
        List<String> res = new ArrayList<>();
        for (String s: words) {
            int tmp = 0;
            for (int i = 0; i < 6; i++) {
                if (s.charAt(i) == word.charAt(i)) {
                    tmp++;
                }
            }
            if (tmp == cur) res.add(s);
        }
        return res;
    }
}
