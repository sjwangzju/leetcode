package Array;

/**
 * Created by sjwang on 07/13/2018.
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to
 * the product of all the elements of nums except nums[i].
 *
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int re[] = new int[nums.length];
        for(int i = 0, mul = 1; i < nums.length; i ++){
            re[i] = mul;
            mul *= nums[i];
        }
        for(int i = nums.length - 1, mul = 1; i >= 0; i --){
            re[i] *= mul;
            mul *= nums[i];
        }
        return re;
    }
    public static void main(String args[]){
        int[] nums = {1,2,3,4};
        System.out.println(new ProductOfArrayExceptSelf().productExceptSelf(nums));
    }
}
