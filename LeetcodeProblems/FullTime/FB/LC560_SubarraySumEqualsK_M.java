package FullTime.FB;

import java.util.HashMap;
import java.util.Map;

/**
 * continuous subarray sum
 * sum(i+1,j) = sum(0,j) - sum(0,i) with frequency map
 *
 * time: O(N), N is the len of array
 * space: O(N)
 */
public class LC560_SubarraySumEqualsK_M {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        map.put(nums[0], 1);
        if (nums[0] == k) cnt++;

        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            if (nums[i] == k) cnt++;

            int tmp = nums[i] - k;
            if (map.containsKey(tmp)) {
                cnt += map.get(tmp);
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(new LC560_SubarraySumEqualsK_M().subarraySum(nums, 1));
    }
}
