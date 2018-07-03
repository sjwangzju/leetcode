package Array;

import java.util.Arrays;

/**
 * Created by sjwang on 05/11/2018.
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 *
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */

public class MajorityElement {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String args[]){
        int[] nums = {2,2,1,1,1,2,2,3,3,4};
        System.out.println(new MajorityElement().majorityElement(nums));
    }
}
