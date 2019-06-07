package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap - find sum with the same mod
 *
 * time: O(N)
 * space: O(N)
 */
public class LC523_ContinuousSubarraySum_M {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> mod = new HashMap<>();
        int sum = 0;
        mod.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            if (mod.containsKey(sum)) {
                if (i - mod.get(sum) >= 2) {
                    return true;
                }
            } else {
                mod.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(new LC523_ContinuousSubarraySum_M().checkSubarraySum(nums, k));
    }
}
