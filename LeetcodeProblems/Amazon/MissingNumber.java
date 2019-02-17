package Amazon;

import java.util.Arrays;

public class MissingNumber {

    /**
     * bit manipulation
     *
     * time: O(N), space: O(1)
     *
     * @param nums
     * @return
     */
    public int missingNumberI(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

    /**
     * binary search
     *
     * time: O(NlogN) space: O(1)
     *
     * @param nums
     * @return
     */
    public int missingNumberII(int[] nums) {
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(new MissingNumber().missingNumberII(nums));
    }
}
