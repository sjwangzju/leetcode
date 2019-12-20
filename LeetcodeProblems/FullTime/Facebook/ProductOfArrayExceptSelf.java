package FullTime.Facebook;

public class ProductOfArrayExceptSelf {

    // Given an array nums of n integers where n > 1,
    // return an array output such that output[i] is equal to
    // the product of all the elements of nums except nums[i].
    //
    // Input:  [1,2,3,4]
    // Output: [24,12,8,6]
    //
    // two passes
    // time: O(N), space: O(1)
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i];
        }

        int prev = 1;
        for (int i = nums.length - 1; i >= 1; i--) {
            res[i] = res[i - 1] * prev;
            prev *= nums[i];
        }
        res[0] = prev;
        return res;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf object = new ProductOfArrayExceptSelf();

        // test1
        int[] nums1 = {1,2,3,4};
        int[] res1 = object.productExceptSelf(nums1);
        for (int n: res1) System.out.print(n + " ");
        System.out.println();

        // test2
        int[] nums2 = {1,2,0,4};
        int[] res2 = object.productExceptSelf(nums2);
        for (int n: res2) System.out.print(n + " ");
        System.out.println();
    }
}
