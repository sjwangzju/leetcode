package FullTime.Facebook;

public class FindPeakElement {

    // Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
    // The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
    //
    // Input: nums = [1,2,1,3,5,6,4]
    // Output: 1 or 5
    // Explanation: Your function can return either index number 1 where the peak element is 2,
    //              or index number 5 where the peak element is 6.
    //
    // linear search
    // time: O(N), space: O(1)
    //
    public int findPeakElementI(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) return i;
        }
        return nums.length - 1;
    }


    // Thoughts:
    // 1. view any given sequence in nums array as alternating ascending and descending sequences
    // 2. binary search

    // time: O(logN), space: O(1)
    public int findPeakElementII(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}
