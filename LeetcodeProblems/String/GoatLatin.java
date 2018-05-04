package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjwang on 04/05/2018.
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 *
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 *
 * Notes:
 *
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 */

public class GoatLatin {
    public String toGoatLatin(String S) {
        String[] strs = S.split("\\s");
        StringBuffer sb = new StringBuffer();
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 1); map.put('e', 1); map.put('i', 1); map.put('o', 1); map.put('u', 1);
        int count = 1;
        for(String s : strs){
            if(!map.containsKey(s.charAt(0)) && !map.containsKey((char) (s.charAt(0) + 'a' - 'A'))) {
                String ss = s.substring(0, 1);
                s = s.substring(1, s.length());
                s += ss;
            }
            s += "ma";
            for(int i = 0; i < count; i ++) s += 'a';
            if(count < strs.length) s += ' ';
            sb.append(s);
            count ++;
        }
        return sb.toString();
    }

    public static void main(String args[]){
        String str = "The quick brown fox jumped over the lazy dog";
        System.out.println(new GoatLatin().toGoatLatin(str));
    }
}
