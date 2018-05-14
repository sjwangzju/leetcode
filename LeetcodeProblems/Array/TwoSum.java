package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjwang on 14/05/2018.
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] re = new int[2];
        for(int i = 0; i < nums.length; i ++){
            if(!map.containsKey(target - nums[i])) map.put(nums[i], i);
            else{
                re[0] = Math.min(i, map.get(target - nums[i]));
                re[1] = Math.max(i, map.get(target - nums[i]));
            }
        }
        return re;
    }

    public static void main(String args[]){
        int[] nums = {3,3};
        System.out.println(new TwoSum().twoSum(nums, 6)[1]);
    }
}
