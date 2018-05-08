package Array;

/**
 * Created by sjwang on 08/05/2018.
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        StringBuffer sb = new StringBuffer();
        int count = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == 0) count ++;
            else sb.append(nums[i] + " ");
        }
        for(int j = 0; j < count; j ++){
            if(j == count - 1) sb.append(0);
            else sb.append(0 + " ");
        }
        String[] str = sb.toString().split("\\s");
        for(int m = 0; m < str.length; m ++){
            nums[m] = Integer.valueOf(str[m]);
        }
    }

    public static void main(String args[]){
        int[] nums = {1, 0, 2, 0, 0, 3};
        new MoveZeroes().moveZeroes(nums);
        for(int i = 0; i < nums.length; i ++) System.out.println(nums[i]);
    }
}