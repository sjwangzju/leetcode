package FullTime.FB;

/**
 * Binary Search
 *
 * time: O(logN)
 * space: O(1)
 */
public class LC34_FindFirstAndLastPositionOfElementInSortedArray_M {

    private int[] nums;
    private int target;

    public int[] searchRange(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int[] res = new int[]{-1,-1};
        if (nums == null || nums.length == 0) return res;

        res[0] = binarySearch(0, nums.length - 1, true);
        res[1] = binarySearch(0, nums.length - 1, false);
        return res;
    }

    public int binarySearch(int lo, int hi, boolean isLeft) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                if (isLeft && (mid == 0 || nums[mid - 1] < target)
                        || !isLeft && (mid == nums.length - 1 || nums[mid + 1] > target)) {
                    return mid;
                }
                if (isLeft) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {8};
        int target = 8;
        int[] res = new LC34_FindFirstAndLastPositionOfElementInSortedArray_M().searchRange(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
