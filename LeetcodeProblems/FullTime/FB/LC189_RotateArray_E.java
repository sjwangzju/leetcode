package FullTime.FB;

/**
 * Reverse
 *
 * time: O(N)
 * space: O(1)
 */
public class LC189_RotateArray_E {

    public void rotate(int[] nums, int k) {
        while (k >= nums.length) {
            k -= nums.length;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++; j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        new LC189_RotateArray_E().rotate(nums, 7);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
