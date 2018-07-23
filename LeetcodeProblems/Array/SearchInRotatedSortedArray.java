package Array;

/**
 * Created by sjwang on 07/23/2018.
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return -1;
        int left = 0, right = nums.length - 1;
        while(left < right - 1){
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            if(nums[left] < nums[mid]){
                if(nums[left] <= target && target <= nums[mid]) right = mid;
                else left = mid;
            }
            else{
                if(nums[mid] <= target && target <= nums[right]) left = mid;
                else right = mid;
            }
        }
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }
    public static void main(String args[]){
        int[] nums = {0,1,2,3,4,5,6,7};
        System.out.println(new SearchInRotatedSortedArray().search(nums, 5));
    }
}
