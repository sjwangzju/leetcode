package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sjwang on 11/05/2018.
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] appear = new int[nums.length];
        List<Integer> L = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
            appear[nums[i] - 1] = 1;
        }
        for(int j = 0; j < appear.length; j ++){
            if(appear[j] == 0) L.add(j + 1);
        }
        return L;
    }

    public static void main(String args[]){
        int[] nums = {1, 1, 2, 2};
        System.out.println(new FindAllNumbersDisappearedInAnArray().findDisappearedNumbers(nums));
    }
}
