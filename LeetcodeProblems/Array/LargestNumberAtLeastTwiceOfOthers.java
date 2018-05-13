package Array;

import java.util.Arrays;

/**
 * Created by sjwang on 13/05/2018.
 * In a given integer array nums, there is always exactly one largest element.
 *
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 *
 * If it is, return the index of the largest element, otherwise return -1.
 *
 * Example 1:
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 *
 *
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 *
 * Note:
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 */

public class LargestNumberAtLeastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, nums.length);
        Arrays.sort(nums);
        if(nums.length == 1) return 0;
        else{
            if(nums[nums.length - 1] >= 2 * nums[nums.length - 2]){
                for(int i = 0; i < temp.length; i ++){
                    if(temp[i] == nums[nums.length - 1]) return i;
                }
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int[] nums = {1,3,5,4,20,9};
        System.out.println(new LargestNumberAtLeastTwiceOfOthers().dominantIndex(nums));
    }
}
