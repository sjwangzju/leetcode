package Math;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjwang on 29/04/2018.
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error,
 * one of the numbers in the set got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 *
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 *
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 */

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] re = new int[2];
        int sum = 0;
        Map<Integer, Integer> M = new HashMap<>();
        for(int i : nums){
            if(M.containsKey(i)) re[0] = i;
            else{
                M.put(i, 1);
                sum += i;
            }
        }
        re[1] = (nums.length + 1) * nums.length / 2 - sum;
        return re;
    }

    public static void main(String args[]) {
        int[] nums = {1, 2, 2, 4};
        System.out.println(new SetMismatch().findErrorNums(nums));
    }
}
