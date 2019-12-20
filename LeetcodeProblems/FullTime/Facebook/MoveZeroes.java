package FullTime.Facebook;

public class MoveZeroes {

    // Given an array nums, write a function to move all 0's to
    // the end of it while maintaining the relative order of the non-zero elements.
    //
    // Input: [0,1,0,3,12]
    // Output: [1,3,12,0,0]
    //
    // time: O(N), space: O(1)
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, lo = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                swap(nums, i, lo++);
            }
            i++;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
