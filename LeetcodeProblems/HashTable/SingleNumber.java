package HashTable;

/**
 * Created by sjwang on 07/30/2018.
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int n = nums[0];
        for(int i = 1; i < nums.length; i++) {
            n ^= nums[i];
        }
        return n;
    }
    public static void main(String args[]){
        int[] nums = {2,2,1};
        System.out.println(new SingleNumber().singleNumber(nums));
    }
}
