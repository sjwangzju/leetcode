package FullTime.LinkedIn;

import java.util.Random;

public class KthLargestElementInArray {

    // Find the kth largest element in an unsorted array.
    // Note that it is the kth largest element in the sorted order, not the kth distinct element.
    //
    // Input: [3,2,1,5,6,4] and k = 2
    // Output: 5
    //
    // quick select
    // time: O(N), space: O(N)
    public int findKthLargest(int[] nums, int k) {
        return partition(nums, nums.length - k, 0, nums.length - 1);
    }

    public int partition(int[] nums, int k, int lo, int hi) {
        if (lo == hi) return nums[lo];
        Random rd = new Random();

        int pivotIndex = lo + rd.nextInt(hi - lo);
        pivotIndex = quickSelect(nums, k, pivotIndex, lo, hi);
        if (pivotIndex == k) {
            return nums[k];
        } else if (pivotIndex > k) {
            return partition(nums, k, lo, pivotIndex - 1);
        }
        return partition(nums, k, pivotIndex + 1, hi);
    }

    public int quickSelect(int[] nums, int k, int pivotIndex, int lo, int hi) {
        int pivot = nums[pivotIndex], pt = lo;
        swap(nums, hi, pivotIndex);
        for (int i = lo; i <= hi; i++) {
            if (nums[i] < pivot) {
                swap(nums, pt++, i);
            }
        }
        swap(nums, pt, hi);
        return pt;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
