package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 07/23/2018.
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 *
 * Example 1:
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 *
 * Example 2:
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range.
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0 || nums == null) return new ArrayList<>();
        List<String> L = new ArrayList<>();
        if(nums.length == 1) {
            L.add(Integer.toString(nums[0])); return L;
        }
        int start = 0, end = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] == 1) end++;
            else{
                if(start == end) L.add(Integer.toString(nums[start]));
                else L.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[end]));
                start = i;
                end = i;
            }
        }
        if(start == end) L.add(Integer.toString(nums[start]));
        else L.add(Integer.toString(nums[start]) + "->" + Integer.toString(nums[end]));
        return L;
    }
    public static void main(String args[]){
        int[] nums = {0,1,2,4,5,7};
        System.out.println(new SummaryRanges().summaryRanges(nums));
    }
}
