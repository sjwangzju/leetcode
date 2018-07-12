package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sjwang on 07/12/2018.
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
 *
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> L = new ArrayList<>();
        int i = 0, j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                L.add(nums1[i]);
                i ++; j ++;
            }
            else if(nums1[i] < nums2[j]) i ++;
            else j ++;
        }
        int[] re = new int[L.size()];
        int m = 0;
        for(int num : L){
            re[m ++] = num;
        }
        return re;
    }
    public static void main(String args[]){
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        System.out.println(new IntersectionOfTwoArraysII().intersect(nums1, nums2).length);
    }
}
