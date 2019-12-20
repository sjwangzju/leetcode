package FullTime.Facebook;

public class SortColors {

    // Given an array with n objects colored red, white or blue,
    // sort them in-place so that objects of the same color are adjacent,
    // with the colors in the order red(0), white(1) and blue(2).
    //
    // Input: [2,0,2,1,1,0]
    // Output: [0,0,1,1,2,2]
    //
    // two pointers + swap
    // time: O(N), space: O(1)
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, lo = 0, hi = nums.length - 1;
        while (i <= hi) {
            if (nums[i] == 2) {
                swap(nums, i, hi--);
            } else if (nums[i] == 0) {
                swap(nums, i++, lo++);
            } else {
                i++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
