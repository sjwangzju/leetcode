package String;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 *
 * Explanation: There is no common prefix among the input strings.
 * Note: All given inputs are in lowercase letters a-z.
 */

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int len = 1; String pre = "";
        if(strs.length == 0 || strs[0].length() == 0) return "";
        if(strs.length == 1) return strs[0];
        while(true){
            for(int i = 0; i < strs.length; i ++){
                if(len > strs[i].length()){
                    if(len > 1) return strs[i].substring(0, len - 1);
                    return "";
                }
                if(i == 0) pre = strs[0].substring(0, len);
                else if(strs[i].substring(0, len).equals(pre) == false){
                    if(len > 1)  return strs[i].substring(0, len - 1);
                    else return "";
                }
            }
            len ++;
        }
    }
    public static void main(String args[]){
        String[] strs = {"dog","racecar","car"};
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(strs));
    }
}
