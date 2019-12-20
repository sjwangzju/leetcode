package FullTime.Facebook;

public class NextPermutation {

    // Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
    //
    // 1,2,3 → 1,3,2
    // 3,2,1 → 1,2,3
    // 1,1,5 → 1,5,1
    //
    // Thoughts:
    // 1. find the element nums[i] right before a continuous decreasing subarray
    //    decreasing subarray means: the last permutation of this combination
    //    e.g.  62|5430 -> i = 1, nums[i] = 2
    // 2. find the smallest nums[j] larger than nums[i]
    //    e.g.  62|5430 -> j = 4, nums[j] = 3
    // 3. swap nums[i] and nums[j[
    //    e.g.  63|5420
    // 4. reverse the decreasing part
    //    e.g.  63|0245

    // edge case: e.g. 654320 -> the last permutation
    //                 reverse the whole string (654320 -> 023456)

    // time: O(N), space: O(1)
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = nums.length - 1;
        while (i >= 1 && nums[i - 1] >= nums[i]) {
            i--;
        }
        i--;

        // find the smallest nums[j] larger than nums[i]
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > i && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        // reverse the subarray after index i
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int i) {
        int j = nums.length - 1;
        while (i <= j) {
            swap(nums, i++, j--);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
