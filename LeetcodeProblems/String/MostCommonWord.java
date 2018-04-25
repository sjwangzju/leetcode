package String;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by sjwang on 25/04/2018.
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 *
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 *
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 */

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.split("\\s");
        HashMap<String, Integer> M = new HashMap<>();
        for(String str : words){
            String s = getWord(str);
            if(! Arrays.asList(banned).contains(s)){
                if(M.containsKey(s)) M.put(s, M.get(s) + 1);
                else M.put(s, 1);
            }
        }
        int max = 0; String re = "";
        for(String str : M.keySet()){
            if(M.get(str) > max){
                max = M.get(str);
                re = str;
            }
        }
        return re;
    }

    private String getWord(String str){
        char chs[] = str.toCharArray();
        StringBuffer words = new StringBuffer();
        for(int i = 0; i < chs.length; i++){
            if(chs[i] >= 'A' && chs[i] <= 'Z'){
                words.append((char)(chs[i] - 'A' + 'a'));
            }
            else if(chs[i] >= 'a' && chs[i] <= 'z'){
                words.append(chs[i]);
            }
        }
        return words.toString();
    }

    public static void main(String args[]){
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String str = new MostCommonWord().mostCommonWord(paragraph, banned);
        System.out.println(str);
    }
}
