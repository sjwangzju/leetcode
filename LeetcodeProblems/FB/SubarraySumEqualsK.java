package FB;

import java.util.HashMap;
import java.util.Map;

/**
 * 10.30.
 */
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int cnt = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int n : nums) {
            sum += n;
            if (map.containsKey(sum - k)) {
                cnt += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,4};
        int count = new SubarraySumEqualsK().subarraySum(nums, 3);
        System.out.println(count);
    }
}
