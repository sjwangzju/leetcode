package FB;

import java.util.HashMap;
import java.util.Map;

public class LC523ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 0 || nums == null) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) >= 2) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,0};
        int k = 0;
        System.out.println(new LC523ContinuousSubarraySum().checkSubarraySum(nums, k));
    }
}
