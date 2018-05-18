package String;

/**
 * Created by sjwang on 05/17/2018.
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 *
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 * Input: "Hello, my name is John"
 * Output: 5
 */

public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if(s.length() == 0) return 0;
        char last = s.charAt(0); int count = 0;
        if(last != ' ') count ++;
        for(int i = 1; i < s.length(); i ++){
            if(last == ' ' && s.charAt(i) != ' ') count ++;
            last = s.charAt(i);
        }
        return count;
    }

    public static void main(String args[]){
        String s = "Hello, my name is John";
        System.out.println(new NumberOfSegmentsInAString().countSegments(s));
    }
}
