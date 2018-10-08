package BinarySearch;

/**
 * Created by sjwang on 10/08/2018.
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] index = new int[2];
        index[0] = -1;
        index[1] = -1;
        if (nums == null || nums.length == 0) {
            return index;
        }
        int mid1 = binary(nums, 0, nums.length - 1, target);
        int mid2 = binary(nums, 0, nums.length - 1, target);
        if (mid1 == -1) {
            return index;
        }
        while (mid2 + 1 < nums.length && nums[mid2 + 1] == target) {
            mid2 = binary(nums, mid2 + 1, nums.length - 1, target);
        }
        while (mid1 - 1 >= 0 && nums[mid1 - 1] == target) {
            mid1 = binary(nums, 0, mid1 - 1, target);
        }
        index[0] = mid1;
        index[1] = mid2;
        return index;
    }

    public int binary(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String args[]){
        int[] nums = {5,8,8,8,8,10};
        int target = 5;
        int[] index = new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, target);
        System.out.println(index[0]);
        System.out.println(index[1]);
    }
}
