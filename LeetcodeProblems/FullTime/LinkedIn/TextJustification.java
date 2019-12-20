package FullTime.LinkedIn;

import java.util.LinkedList;
import java.util.List;

public class TextJustification {

    // time: O(N), space: O(N)
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> strs = split(words, maxWidth);
        int size = strs.size();
        for (int i = 0 ; i < size; i++) {
            strs.set(i, justify(strs.get(i), maxWidth, i, size));
        }
        return strs;
    }

    // assign the words for each line
    public List<String> split(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        int curL = 0, i = 0;
        StringBuilder s = new StringBuilder();
        while (i < words.length) {
            int l = words[i].length();
            if (s.length() == 0) {
                curL += l;
                s.append(words[i]);
                i++;
                continue;
            }
            if (curL + l + 1 <= maxWidth) {
                curL += l + 1;
                s.append(" ").append(words[i]);
                i++;
            } else {
                res.add(s.toString());
                curL = 0;
                s = new StringBuilder();
            }
        }
        if (s.length() != 0) res.add(s.toString());
        return res;
    }

    public String justify(String str, int maxWidth, int i, int size) {
        String[] arr = str.split(" ");
        int total = 0;
        for (String s: arr) {
            total += s.length();
        }
        if (i == size - 1 || arr.length == 1) {
            return leftJustified(str, maxWidth, total + arr.length - 1);
        }
        return fullyJustified(str, maxWidth, total, arr);
    }

    public String leftJustified(String str, int maxWidth, int total) {
        StringBuilder s = new StringBuilder(str);
        for (int i = 0; i < maxWidth - total; i++) {
            s.append(" ");
        }
        return s.toString();
    }

    public String fullyJustified(String str, int maxWidth, int total, String[] arr) {
        int avg = (maxWidth - total) / (arr.length - 1);
        int num = (maxWidth - total) - (arr.length - 1) * avg;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            if (i >= 1) {
                int spacesN = i <= num? avg + 1: avg;
                for (int j = 0; j < spacesN; j++) {
                    res.append(" ");
                }
            }
            res.append(arr[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example"};
        new TextJustification().fullJustify(words, 16);
    }
}
