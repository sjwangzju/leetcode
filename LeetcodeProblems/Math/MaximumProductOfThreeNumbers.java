package Math;
import java.util.Arrays;

/**
 * Created by sjwang on 28/04/2018.
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 * Note:
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 */

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int mul1 = nums[0] * nums[1] * nums[len - 1];
        int mul2 = nums[len - 1] * nums[len - 2] * nums[len - 3];
        return Math.max(mul1, mul2);
    }

    public static void main(String args[]){
        int[] nums = {-3, 4, 0, 2, -5, 1};
        System.out.println(new MaximumProductOfThreeNumbers().maximumProduct(nums));
    }
}
