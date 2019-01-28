package Amazon;

import java.util.Arrays;

public class ClosestTwoSum {

    /**
     * time: O(nlogn), space: O(1)
     * @param nums1
     * @param nums2
     * @param n
     */
    public void findClosestSum(int[] nums1, int[] nums2, int n) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int r = nums2.length - 1;
        int n1 = 0;
        int n2 = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (l < nums1.length && r >= 0) {
            int tmp = nums1[l] + nums2[r];
            if (tmp <= n && n - tmp < min) {
                min = n - tmp;
                n1 = nums1[l];
                n2 = nums2[r];
            }
            if (tmp < n) {
                l++;
            } else {
                r--;
            }
        }
        System.out.println(n1);
        System.out.println(n2);
    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,5,6};
        int[] nums2 = {6,2,12,10};
        new ClosestTwoSum().findClosestSum(nums1, nums2, 10);
    }
}
