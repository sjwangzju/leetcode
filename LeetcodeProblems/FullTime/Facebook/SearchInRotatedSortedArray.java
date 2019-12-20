package FullTime.Facebook;

public class SearchInRotatedSortedArray {

    // Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
    // You are given a target value to search. If found in the array return its index, otherwise return -1.
    //
    // Input: nums = [4,5,6,7,0,1,2], target = 0
    // Output: 4
    //
    // binary search
    // time: O(NlogN), space: O(1)
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
