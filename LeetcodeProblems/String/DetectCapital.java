package String;

/**
 * Created by sjwang on 25/04/2018.
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 *
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * Example 1:
 * Input: "USA"
 * Output: True
 * Example 2:
 * Input: "FlaG"
 * Output: False
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        char[] chs = word.toCharArray();
        int count_u = 0, count_l = 0;
        if(isLowerCase(chs[0])){
            for(char ch : chs){
                if(isUpperCase(ch)) return false;
            }
            return true;
        }
        for(int i = 1; i < chs.length; i++){
            if(isUpperCase(chs[i])){
                count_u ++;
            }
            else{
                count_l ++;
            }
        }
        if(count_u == chs.length - 1 || count_l == chs.length - 1) return true;
        return false;
    }

    private boolean isLowerCase(char ch){
        return (ch >= 'a' && ch <= 'z');
    }

    private boolean isUpperCase(char ch){
        return (ch >= 'A' && ch <= 'Z');
    }

    public static void main(String args[]){
        String str = "flaG";
        System.out.println(new DetectCapital().detectCapitalUse(str));
    }
}
