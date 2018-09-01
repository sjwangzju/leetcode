package DynamicProgramming;

/**
 * Created by sjwang on 08/31/2018.
 *
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 *
 * Example 1:
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * Note:
 * 1 <= k <= len(nums) <= 16.
 * 0 < nums[i] < 10000.
 */
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;
        
    }
    public static void main(String args[]){
        int[] nums = {1,7,2,6,4,4,3,5};
        System.out.println(new PartitionToKEqualSumSubsets().canPartitionKSubsets(nums, 2));
    }
}
