package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjwang on 07/22/2018.
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0 || nums == null) return false;
        Map<Integer, Integer> M = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(!M.containsKey(nums[i])) M.put(nums[i], i);
            else if(i - M.get(nums[i]) <= k) return true;
            else M.put(nums[i], i);
        }
        return false;
    }
    public static void main(String args[]){
        int[] nums = {1,2,3,1,2,3};
        System.out.println(new ContainsDuplicateII().containsNearbyDuplicate(nums, 2));
    }
}
