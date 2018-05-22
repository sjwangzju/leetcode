package Array;

/**
 * Created by sjwang on 05/15/2018.
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] != nums[j]) nums[++j] = nums[i];
        }
        return j + 1;
    }

    public static void main(String args[]){
        int[] nums = {1,2,2,3,3,3,4,5,6,6};
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
    }
}
