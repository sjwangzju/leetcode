package Airbnb;

import java.util.LinkedList;
import java.util.List;

public class TextJustification_12 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<>();
        int start = 0; int end = 0;

        StringBuilder sb = new StringBuilder();
        int curLen = 0;

        while (end < words.length) {
            while (end < words.length && maxWidth - curLen - words[end].length() >= end - start) {
                curLen += words[end].length();
                end++;
            }

            if (end == words.length) {
                res.add(leftJustification(start, end - 1, words, maxWidth));
            } else {
                res.add(fullJustification(start, end - 1, words, curLen, maxWidth));
            }

            curLen = 0;
            start = end;
            sb.setLength(0);
        }
        return res;
    }

    public String leftJustification(int start, int end, String[] words, int maxWidth) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(words[i] + " ");
        }
        sb.append(words[end]);
        int spaceNum = maxWidth - sb.length();
        for (int i = 0; i < spaceNum; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public String fullJustification(int start, int end, String[] words, int curLen, int maxWidth) {

        if (start == end) {
            return leftJustification(start, end, words, maxWidth);
        }

        StringBuilder sb = new StringBuilder();
        int spaceLenTotal = maxWidth - curLen;
        int spaceNum = end - start;
        int spaceLen = spaceLenTotal / spaceNum;
        int rest = spaceLenTotal - spaceLen * spaceNum;

        for (int i = start; i < end; i++) {
            sb.append(words[i]);
            int curSpaceLen = spaceLen;
            if (rest > 0) {
                curSpaceLen++;
                rest--;
            }
            for (int j = 0; j < curSpaceLen; j++) {
                sb.append(" ");
            }
        }
        sb.append(words[end]);
        return sb.toString();
    }

    public static void main(String[] args) {
//        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};

        String[] words2 = {"What","must","be","acknowledgment","shall","be"};

//        String[] words3 = {"Science","is","what","we","understand","well","enough","to","explain",
//                "to","a","computer.","Art","is","everything","else","we","do"};

        int maxWidth = 16;
        List<String> res = new TextJustification_12().fullJustify(words2, maxWidth);
        for (String s: res) {
            System.out.println(s + " " + s.length());
        }
    }
}
