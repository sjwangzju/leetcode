package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sjwang on 07/23/2018.
 *
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * Note: The algorithm should run in linear time and in O(1) space.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: [3]
 *
 * Example 2:
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 0 || nums == null) return  new ArrayList<>();
        List<Integer> L = new ArrayList<>();
        int num1 = 0, num2 = 0, count1 = 0, count2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(num1 == nums[i]) count1++;
            else if(num2 == nums[i]) count2++;
            else if(count1 == 0){
                count1 = 1;
                num1 = nums[i];
            }
            else if(count2 == 0){
                count2 = 1;
                num2 = nums[i];
            }
            else{
                count1--; count2--;
            }
        }
        count1 = 0; count2 = 0;
        for(int i : nums){
            if(i == num1) count1++;
            if(i == num2) count2++;
        }
        if(count1 > nums.length / 3) L.add(num1);
        if(count2 > nums.length / 3 && num1 != num2) L.add(num2);
        return L;
    }
    public static void main(String args[]){
        int[] nums = {2,1,1,2,2,1,3};
        System.out.println(new MajorityElementII().majorityElement(nums));
    }
}
