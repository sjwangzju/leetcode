package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

/**
 * HashMap
 *
 * time: O(N)
 * space: O(N)
 */
public class LC1_TwoSum_E {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] res = new LC1_TwoSum_E().twoSum(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }
}
