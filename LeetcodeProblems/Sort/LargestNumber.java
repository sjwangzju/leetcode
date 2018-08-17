package Sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sjwang on 08/16/2018.
 *
 * Given a list of non negative integers, arrange them such that they form the largest number.
 *
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 *
 * Example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 *
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String str1 = s1 + s2;
                String str2 = s2 + s1;
                return str2.compareTo(str1);
            }
        };
        Arrays.sort(strs, comp);
        if(strs[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s);
        }
        return sb.toString();
    }
    public static void main(String args[]){
        int[] nums = {0,0};
        System.out.println(new LargestNumber().largestNumber(nums));
    }
}
