package Greedy;

import java.util.Arrays;

/**
 * Created by sjwang on 08/14/2018.
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 *
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Note:
 * You can assume that you can always reach the last index.
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int end = 0, far = 0, step = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, nums[i] + i);
            if(end == i) {
                step++;
                end = far;
            }
        }
        return step;
    }
    public static void main(String args[]){
        int[] nums = {2,3,1,1,4};
        System.out.println(new JumpGameII().jump(nums));
    }
}
