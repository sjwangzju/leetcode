package FullTime.FB;

/**
 * Approach 1:
 *
 * Requirement: without division and in O(n)
 *
 * left[i] and right[i] - product of all elements on the left and right of index i
 *
 * time: O(N), N is the len of nums
 * space: O(N)
 *
 *
 *
 * Approach 2:
 *
 * using constant space complexity (output array doesn't count as extra space)
 *
 * use res[] to save left elements product; R *= nums[i]
 *
 * time: O(N)
 * space: O(1)
 *
 */
public class LC238_ProductOfArrayExceptSelf_M {

    public int[] productExceptSelfI(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = left[i] * right[i];
        }

        return res;
    }

    public int[] productExceptSelfII(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        res[0] = 1;
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int R = 1;
        for (int i = len - 1; i >= 0; i--) {
            res[i] = R * res[i];
            R = R * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] res = new LC238_ProductOfArrayExceptSelf_M().productExceptSelfII(nums);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
