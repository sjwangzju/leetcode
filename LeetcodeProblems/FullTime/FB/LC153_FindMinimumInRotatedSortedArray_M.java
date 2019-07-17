package FullTime.FB;

/**
 * Binary Search
 *
 * time: O(logN)
 * space: O(1)
 */
public class LC153_FindMinimumInRotatedSortedArray_M {

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length -1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid >= 1 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if (nums[mid] < nums[lo]) {
                hi = mid;
            } else {
                if (nums[mid] > nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(new LC153_FindMinimumInRotatedSortedArray_M().findMin(nums));
    }

}
