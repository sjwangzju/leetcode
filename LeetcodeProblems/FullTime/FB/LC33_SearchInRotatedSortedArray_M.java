package FullTime.FB;

/**
 * Transformed Binary Search
 *
 * time: O(logN)
 * space: O(1)
 */
public class LC33_SearchInRotatedSortedArray_M {

    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < nums[hi]) {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            } else {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,3};
        System.out.println(new LC33_SearchInRotatedSortedArray_M().search(nums, 5));
    }
}
