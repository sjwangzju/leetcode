package FullTime.FB;

import java.util.Arrays;
import java.util.List;

public class LC824_GoatLatin_E {

    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        List<Character> vowels = Arrays.asList('a','e','i','o','u');
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            char first = words[i].charAt(0);

            if (!vowels.contains(Character.toLowerCase(first))) {
                words[i] = words[i].substring(1);
                words[i] += first;
            }
            words[i] += "ma";
            for (int j = 0; j < i + 1; j++) {
                words[i] += "a";
            }
            res.append(words[i]).append(" ");
        }

        return res.toString().substring(0, res.length() - 1);
    }

    public static void main(String[] args) {
        String s = "The quick brown fox jumped over the lazy dog";
        System.out.println(new LC824_GoatLatin_E().toGoatLatin(s));
    }
}
