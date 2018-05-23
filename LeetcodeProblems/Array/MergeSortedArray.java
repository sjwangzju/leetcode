package Array;

import java.util.ArrayList;

/**
 * Created by sjwang on 05/16/2018.
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 *
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * Output: [1,2,2,3,5,6]
 */

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        ArrayList<Integer> L = new ArrayList<>();
        int i = 0, j = 0;
        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                L.add(nums1[i]); i ++;
            }
            else{
                L.add(nums2[j]); j ++;
            }
        }
        if(i == m){
            for(int k = j; k < n; k ++) L.add(nums2[k]);
        }
        else if(j == n){
            for(int k = i; k < m; k ++) L.add(nums1[k]);
        }
        for(int l = 0; l < L.size(); l ++){
            nums1[l] = L.get(l);
        }
    }

    public static void main(String args[]){
        int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
        int m = 3, n = 3;
        new MergeSortedArray().merge(nums1, m, nums2, n);
    }
}
