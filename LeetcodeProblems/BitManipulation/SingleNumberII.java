package BitManipulation;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sjwang on 08/04/2018.
 *
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,3,2]
 * Output: 3
 *
 * Example 2:
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> M = new HashMap<>();
        for(int n : nums) {
            if(M.containsKey(n)) {
                if(M.get(n) == 2) M.remove(n);
                else M.put(n, M.get(n) + 1);
            }
            else M.put(n, 1);
        }
        int re = 0;
        for(int n : M.keySet()) {
            re = n;
        }
        return re;
    }
    public static void main(String args[]){
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(new SingleNumberII().singleNumber(nums));
    }
}
