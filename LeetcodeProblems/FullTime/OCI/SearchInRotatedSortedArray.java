package FullTime.OCI;

public class SearchInRotatedSortedArray {

    /**
     * Search In Rotated Sorted Array I (no duplicates)
     * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
     *
     * Example 1:
     * Input: nums = [4,5,6,7,0,1,2], target = 0
     * Output: 4
     *
     * binary search
     *
     * time: O(logN), space: O(1)
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[lo]) {
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


    /**
     * Search In Rotated Sorted Array II (may contain duplicates)
     *
     * Example 1:
     * Input: nums = [2,5,6,0,0,1,2], target = 0
     * Output: true
     *
     * Thoughts:
     * The only difference is that due to the existence of duplicates, we can have nums[lo] == nums[mid] and in that case,
     * the first half could be out of order (i.e. NOT in the ascending order, e.g. [3 1 2 3 3 3 3]) and we have to deal this case separately.
     *
     * 1. remove duplicates at tail
     * 2. binary search
     *
     * time: avg O(logN), worst O(N)
     * space: O(1)
     */
    public boolean searchII(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int lo = 0, hi = nums.length - 1;

        // remove duplicates at tail
        while (nums[lo] == nums[hi] && lo < hi) {
            hi--;
        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] >= nums[lo]) {
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
        return false;
    }
}
