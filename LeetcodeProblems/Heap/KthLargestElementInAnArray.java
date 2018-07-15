package Heap;

import java.util.Arrays;

/**
 * Created by sjwang on 07/15/2018.
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0) return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    public static void main(String args[]){
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new KthLargestElementInAnArray().findKthLargest(nums, k));
    }
}
