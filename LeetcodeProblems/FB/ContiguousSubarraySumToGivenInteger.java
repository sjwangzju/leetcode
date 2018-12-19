package FB;

public class ContiguousSubarraySumToGivenInteger {

    /**
     * 1. contains only positive numbers
     * 2. the array is unordered
     *
     * sliding window, time: O(N), space: O(1)
     * @param nums
     * @param target
     * @return
     */
    public boolean continuousSumI(int[] nums, int target) {
        int lo = 0;
        int hi = 0;
        int sum = 0;
        while (hi < nums.length) {
            sum += nums[hi];
            while (sum > target && lo < hi) {
                sum -= nums[lo];
                lo++;
            }
            if (sum == target) {
                return true;
            }
            hi++;
        }
        return false;
    }

    /**
     * 1. this solution works when the array contains negative numbers
     *
     * save the subsums in tmp[], time: O(N^2)
     * @param nums
     * @param target
     * @return
     */
    public boolean continuousSumII(int[] nums, int target) {
        int[] tmp = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            tmp[i] = sum;
        }
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == target) {
                return true;
            }
            for (int j = 0; j < i; j++) {
                if (tmp[i] - tmp[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {-4,5,-6,0};
        int target = -5;
        boolean res = new ContiguousSubarraySumToGivenInteger().continuousSumII(nums,  target);
        System.out.println(res);
    }
}
