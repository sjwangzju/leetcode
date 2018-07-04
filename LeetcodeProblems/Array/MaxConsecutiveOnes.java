package Array;

/**
 * Created by sjwang on 05/11/2018.
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 *
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, max = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 1){
                count ++;
                if(count > max) max = count;
            }
            if(nums[i] == 0) count = 0;
        }
        return max;
    }

    public static void main(String args[]){
        int[] nums = {1,1,1,1,0,1,1,1};
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
    }
}
