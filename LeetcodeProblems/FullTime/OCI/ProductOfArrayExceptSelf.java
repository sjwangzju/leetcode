package FullTime.OCI;

public class ProductOfArrayExceptSelf {

    // Given an array nums of n integers where n > 1,
    // return an array output such that output[i] is equal to
    // the product of all the elements of nums except nums[i].
    //
    // time: O(N), space: O(1)
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];

        int[] res = new int[nums.length];
        int product = 1;
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            res[i] = product;
        }
        product = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            res[i] = product * res[i - 1];
            product *= nums[i];
        }
        res[0] = product;
        return res;
    }
}
