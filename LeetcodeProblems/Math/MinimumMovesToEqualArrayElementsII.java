package Math;

import java.util.Arrays;

/**
 * Created by sjwang on 05/18/2018.
 * Given a non-empty integer array, find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing a selected element by 1 or decrementing a selected element by 1.
 *
 * You may assume the array's length is at most 10,000.
 *
 * Example:
 *
 * Input:
 * [1,2,3]
 *
 * Output:
 * 2
 *
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 *
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 */

public class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return 0;
        Arrays.sort(nums);
        int temp , sum = 0;
        if(nums.length % 2 == 0) temp = nums.length / 2 - 1;
        else temp = nums.length / 2;
        for(int i = 0; i < nums.length; i ++) sum += Math.abs(nums[i] - nums[temp]);
        return sum;
    }

    public static void main(String args[]){
        int[] nums = {1,1,100};
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(nums));
    }
}
