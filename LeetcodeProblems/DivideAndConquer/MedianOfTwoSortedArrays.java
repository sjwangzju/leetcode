package DivideAndConquer;

/**
 * Created by sjwang on 10/07/2018.
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] tmp = nums1;
            nums1 = nums2;
            nums2 = tmp;
        }
        int m = nums1.length;
        int n = nums2.length;
        int iMin = 0;
        int iMax = m;
        int half = (m + n + 1) / 2;

        while (iMin <= iMax) {
            int i = iMin + (iMax - iMin) / 2;
            int j = half - i;
            if (i < iMax && nums1[i] < nums2[j - 1]) {
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int leftMax = 0;
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if (j == 0) {
                    leftMax = nums1[i - 1];
                } else {
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return leftMax;
                }

                int rightMin = 0;
                if (i == m) {
                    rightMin = nums2[j];
                } else if (j == n) {
                    rightMin = nums1[i];
                } else {
                    rightMin = Math.min(nums1[i], nums2[j]);
                }
                if ((m + n) % 2 == 0) {
                    return (leftMax + rightMin) / 2.0;
                }
            }
        }
        return 0.0;
    }

    public static void main(String args[]){
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double res = new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
