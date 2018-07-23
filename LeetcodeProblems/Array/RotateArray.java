package Array;

/**
 * Created by sjwang on 07/23/2018.
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || nums == null) return;
        while(k >= nums.length){
            k -= nums.length;
        }
        ReverseArray(nums, 0, nums.length - 1);
        ReverseArray(nums, 0, k - 1);
        ReverseArray(nums, k, nums.length - 1);
        return;
    }
    public void ReverseArray(int[] n, int i, int j){
        while(i < j){
            swap(n, i++, j--);
        }
    }
    public void swap(int[] n, int i, int j){
        int temp = n[i];
        n[i] = n[j];
        n[j] = temp;
    }
    public static void main(String args[]){
        int[] nums = {1};
        new RotateArray().rotate(nums, 3);
        for(int i : nums){
            System.out.print(i + " ");
        }
    }
}
