package Sort;

/**
 * Created by sjwang on 08/16/2018.
 *
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * Return 0 if the array contains less than 2 elements.
 *
 * Example 1:
 * Input: [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either
 *              (3,6) or (6,9) has the maximum difference 3.
 *
 * Example 2:
 * Input: [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 *
 * Note:
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 * Try to solve it in linear time/space.
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2) return 0;
        int max = Integer.MIN_VALUE;
        for(int n : nums) {
            if(n >= max) {
                max = n;
            }
        }
        int[] arr = new int[max + 1];
        for(int n : nums) {
            arr[n] = 1;
        }
        int res = 0, a = 0;
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] != 0) {
                res = Math.max(res, j - a);
                a = j;
            }
        }
        return res;
    }
    public static void main(String args[]){
        int[] nums = {3,6,9,1,50};
        System.out.println(new MaximumGap().maximumGap(nums));
    }
}
