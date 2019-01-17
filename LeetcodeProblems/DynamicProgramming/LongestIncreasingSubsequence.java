package DynamicProgramming;

/**
 * Created by sjwang on 08/18/2018.
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Note:
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int[] count = new int[nums.length];
        int longest = 0;
        for(int i = 0; i < nums.length; i++) {
            int max = 1;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    max = Math.max(max, count[j] + 1);
                }
            }
            count[i] = max;
            longest = Math.max(longest, max);
        }
        return longest;
    }
    public static void main(String args[]) {
        int[] nums = {4,10,4,3,8,9};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }
}
