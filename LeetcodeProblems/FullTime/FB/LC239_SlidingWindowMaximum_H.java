package FullTime.FB;


/**
 * DP - left & right
 *
 * time: O(N)
 * space: O(N)
 */
public class LC239_SlidingWindowMaximum_H {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = nums[0];
        right[len - 1] = nums[len - 1];

        for (int i = 1; i < len; i++) {
            left[i] = i % k == 0? nums[i]: Math.max(left[i - 1], nums[i]);

            int tmp = len - i - 1;
            right[tmp] = (tmp + 1) % k == 0? nums[tmp]: Math.max(right[tmp + 1], nums[tmp]);
        }

        int[] res = new int[len - k + 1];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(right[i], left[i + k - 1]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = new LC239_SlidingWindowMaximum_H().maxSlidingWindow(nums, k);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
