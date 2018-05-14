package Array;

/**
 * Created by sjwang on 14/05/2018.
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example 1:
 * Given nums = [3,2,2,3], val = 3,
 *
 * Your function should return length = 2, with the first two elements of nums being 2.
 *
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 * Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 *
 * Note that the order of those five elements can be arbitrary.
 *
 * It doesn't matter what values are set beyond the returned length.
 */

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] == val){
                if(count + i == nums.length) break;
                else{
                    count ++;
                    for(int j = i; j < nums.length - 1; j ++){
                        nums[j] = nums[j + 1];
                    }
                    i --;
                }
            }
        }
        return nums.length - count;
    }

    public static void main(String args[]){
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(new RemoveElement().removeElement(nums, 2));
    }
}
