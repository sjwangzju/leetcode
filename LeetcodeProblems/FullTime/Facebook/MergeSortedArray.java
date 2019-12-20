package FullTime.Facebook;

public class MergeSortedArray {

    // Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    // nums1 has enough space to hold nums2
    //
    // Input:
    // nums1 = [1,2,3,0,0,0], m = 3
    // nums2 = [2,5,6],       n = 3
    //
    // Output: [1,2,2,3,5,6]
    //
    // Thoughts:
    // 1. two pointers
    // 2. start from the end of both array, add the larger one to nums1
    //
    // time: O(m + n), space: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = nums1.length - 1, i = m - 1, j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[pos--] = nums1[i--];
            } else {
                nums1[pos--] = nums2[j--];
            }
        }
        while (i >= 0) {
            nums1[pos--] = nums1[i--];
        }
        while (j >= 0) {
            nums1[pos--] = nums2[j--];
        }
        // move the m+n sorted elements to front
        // set other elements to be 0
        pos++;
        for (int k = 0; k < nums1.length; k++) {
            nums1[k] = k < m + n? nums1[pos++]: 0;
        }
    }
}
