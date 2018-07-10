package TwoPointers;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sjwang on 07/10/2018.
 * Given two arrays, write a function to compute their intersection.
 *
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 */

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> inter = new HashSet<>();
        for(int i = 0; i < nums1.length; i ++){
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i ++){
            if(set.contains(nums2[i])){
                inter.add(nums2[i]);
            }
        }
        int[] re = new int[inter.size()];
        int i = 0;
        for(int nums : inter){
            re[i ++] = nums;
        }
        return re;
    }

    public static void main(String args[]){
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        System.out.println(new IntersectionOfTwoArrays().intersection(nums1, nums2)[0]);
    }
}
