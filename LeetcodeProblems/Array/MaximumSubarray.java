package Array;

/**
 * Created by sjwang on 07/16/2018.
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        for(int i : nums){
            if(sum < 0) sum = i;
            else sum += i;
            if(sum > max) max = sum;
        }
        return max;
    }
    public static void main(String args[]){
        int[] nums = {-2,1,-3,-4,-1,2,1,-5,4};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }
}
