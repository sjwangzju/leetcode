package FullTime.LinkedIn;

public class FindFirstAndLastPosition {

    // Given an array of integers nums sorted in ascending order,
    // find the starting and ending position of a given target value.
    // If the target is not found in the array, return [-1, -1].
    //
    // Input: nums = [5,7,7,8,8,10], target = 8
    // Output: [3,4]
    //
    // binary search
    //
    // time: O(logN), space: O(1)
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null) return res;
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);

        return res[0] <= res[1]? res: new int[]{-1,-1};
    }

    public int findLeft(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public int findRight(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi;
    }
}
