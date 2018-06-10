package String;

/**
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 *
 * Example 2:
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 *
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 */

public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        int len1 = haystack.length(), len2 = needle.length();
        if(len2 > len1) return -1;
        for(int i = 0; i < len1; i ++){
            if(i + len2 <= len1)
                if(haystack.substring(i, i + len2).equals(needle)) return i;
        }
        return -1;
    }
    public static void main(String args[]){
        System.out.println(new ImplementstrStr().strStr("", "l4l"));
    }
}
