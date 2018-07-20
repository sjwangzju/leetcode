package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sjwang on 07/20/2018.
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> L = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int sum = -nums[i], l = i + 1, r = nums.length - 1;
            if(i > 0 && nums[i] == nums[i-1]) continue;
            while(l < r){
                int a = nums[l] + nums[r];
                if(a > sum) r--;
                else if(a < sum) l++;
                else{
                    L.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l+1]) l++;
                    while(l < r && nums[r] == nums[r-1]) r--;
                    l++; r--;
                }
            }
        }
        return L;
    }
    public static void main(String args[]){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(nums));
    }
}
