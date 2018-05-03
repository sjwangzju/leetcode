package String;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjwang on 03/05/2018.
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 *
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
 * You may assume that both strings contain only lowercase letters.
 *
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] mag = magazine.toCharArray(), note = ransomNote.toCharArray();
        Map<Character, Integer> dic = new HashMap<>();
        for(char ch : mag){
            if(!dic.containsKey(ch)) dic.put(ch, 1);
            else dic.put(ch, dic.get(ch) + 1);
        }
        for(char ch : note){
            if(!dic.containsKey(ch)) return false;
            else{
                if(dic.get(ch) == 0) return false;
                else dic.put(ch, dic.get(ch) - 1);
            }
        }
        return true;
    }

    public static void main(String args[]) {
        System.out.println(new RansomNote().canConstruct("aa", "ab"));
    }
}
