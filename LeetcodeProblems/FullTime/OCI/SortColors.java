package FullTime.OCI;

public class SortColors {

    // Given an array with n objects colored red, white or blue,
    // sort them in-place so that objects of the same color are adjacent,
    // with the colors in the order red, white and blue.
    //
    // Example:
    // Input: [2,0,2,1,1,0]
    // Output: [0,0,1,1,2,2]
    //
    // time: O(N), space: O(1)
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = nums.length - 1, k = 0;
        while (k <= j) {
            if (nums[k] == 0) {
                swap(nums, i++, k++);
            } else if (nums[k] == 2) {
                swap(nums, j--, k);
            } else {
                k++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
