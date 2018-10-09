package BinarySearch;

/**
 * Created by sjwang on 10/08/2018.
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 *
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 *
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 */
public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return false;
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[left] < nums[mid] || nums[right] < nums[mid]){
                if(nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            else if (nums[left] > nums[mid] || nums[mid] < nums[right]){
                if(nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }
        return false;
    }

    public static void main(String args[]){
        int[] nums = {3,1};
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, 1));
    }
}
