package FB;

import java.util.HashMap;
import java.util.Map;


public class LC560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);

        int sum = 0;
        int cnt = 0;
        for (int n: nums) {
            sum += n;
            if (count.containsKey(sum - k)) {
                cnt += count.get(sum - k);
            }
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = {-1,4,1,2,5};
        int count = new LC560SubarraySumEqualsK().subarraySum(nums, 5);
        System.out.println(count);
    }
}
