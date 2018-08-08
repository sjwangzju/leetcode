package DynamicProgramming;

/**
 * Created by sjwang on 08/08/2018.
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class RangeSumQueryImmutable {
    public static class NumArray {
        int[] sum;
        public NumArray(int[] nums) {
            for(int i = 1; i < nums.length; i++) {
                nums[i] += nums[i - 1];
            }
            sum = nums;
        }

        public int sumRange(int i, int j) {
            if(i == 0) return sum[j];
            return sum[j] - sum[i - 1];
        }
    }
    public static void main(String args[]){
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray n = new NumArray(nums);
        System.out.println(n.sumRange(0,1));
        System.out.println(n.sumRange(0,2));
        System.out.println(n.sumRange(4,5));
    }
}
