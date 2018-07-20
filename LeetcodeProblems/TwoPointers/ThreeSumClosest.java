package TwoPointers;

import java.util.Arrays;

/**
 * Created by sjwang on 07/20/2018.
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, re = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int l = i + 1, r = nums.length - 1;
            while(l < r){
               int val = target - (nums[i] + nums[l] + nums[r]);
               if(Math.abs(val) < min){
                   min = Math.abs(val);
                   re = target - val;
               }
               if(val < 0) r--;
               else if(val > 0) l++;
               else break;
            }
        }
        return re;
    }
    public static void main(String args[]){
        int[] nums = {1,1,1,0};
        System.out.println(new ThreeSumClosest().threeSumClosest(nums, -100));
    }
}
