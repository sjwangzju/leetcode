package Array;

/**
 * Created by sjwang on 05/15/2018.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 *
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 */

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public static void main(String args[]){
        int[] nums = {3,6,8,10};
        int target = 3;
        System.out.println(new SearchInsertPosition().searchInsert(nums, target));
    }

}
