package TuSimple;

import java.util.Arrays;

public class MinSumOfSubarray {

    /**
     * time: O(nlogn), space: O(1)
     * @param nums
     * @return
     */
    public int minSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int sum = 0;

        for (int i = 0; i < len; i++) {
            sum += (len - i) * nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(new MinSumOfSubarray().minSum(nums));
    }
}
