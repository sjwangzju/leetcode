package Array;

/**
 * Created by sjwang on 07/23/2018.
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        if(nums.length == 0 || nums == null) return 0;
        int left = 0, right = nums.length - 1;
        if(nums[left] <= nums[right]) return nums[left];
        while(left < right - 1){
            int mid = (left + right) / 2;
            if(nums[left] < nums[mid]) left = mid;
            else right = mid;
        }
        return nums[right];
    }
    public static void main(String args[]){
        int[] nums = {0,1,2};
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(nums));
    }
}
