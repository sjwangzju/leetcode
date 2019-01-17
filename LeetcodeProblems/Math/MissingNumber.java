package Math;

/**
 * Created by sjwang on 28/04/2018.
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = (nums.length + 1) * nums.length / 2, add = 0;
        for(int i : nums){
            add += i;
        }
        return (sum - add);
    }

    public static void main(String args[]){
        int[] nums = {3, 0 ,1};
        System.out.println(new MissingNumber().missingNumber(nums));
    }

}
