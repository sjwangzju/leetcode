package FullTime.FB;


public class LC88_MergeSortedArray_E {

    // two pointers, copy from the beginning
    // time: O(M+N)
    // space: O(M)
    public void mergeI(int[] nums1, int m, int[] nums2, int n) {
        int[] tmp = new int[m];

        System.arraycopy(nums1, 0, tmp, 0, m);

        int p1 = 0, p2 = 0, p = 0;
        while (p1 < m && p2 < n) {
            if (tmp[p1] <= nums2[p2]) {
                nums1[p++] = tmp[p1++];
            } else {
                nums1[p++] = nums2[p2++];
            }
        }
        for (int i = p1; i < m; i++) {
            nums1[p++] = tmp[i];
        }
        for (int i = p2; i < n; i++) {
            nums1[p++] = nums2[i];
        }
    }

    // two pointers, copy from the end
    // time: O(M+N)
    // space: O(1)
    public void mergeII(int[] nums1, int m, int[] nums2, int n) {
        int p = nums1.length - 1;
        int p1 = m - 1, p2 = n - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums2[p2] >= nums1[p1]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
        for (int i = p1; i >= 0; i--) {
            nums1[p--] = nums1[i];
        }
        for (int i = p2; i >= 0; i--) {
            nums1[p--] = nums2[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int m = 3, n = 3;
        new LC88_MergeSortedArray_E().mergeII(nums1, m, nums2, n);
        for (int i: nums1) {
            System.out.print(i + " ");
        }
    }
}
