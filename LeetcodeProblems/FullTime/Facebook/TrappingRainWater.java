package FullTime.Facebook;

public class TrappingRainWater {

    // Given n non-negative integers representing an elevation map where the width of each bar is 1,
    // compute how much water it is able to trap after raining.
    //
    // Input: [0,1,0,2,1,0,1,3,2,1,2,1]
    // Output: 6
    //
    // time: O(N), space: O(N)
    public int trapI(int[] height) {
        if (height == null || height.length == 0) return 0;

        int res = 0, len = height.length;
        int[] left = new int[len];
        int[] right = new int[len];

        left[0] = height[0];
        for (int i = 1; i < len; i++) {
            left[i] = Math.max(left[i - 1], height[i]);
        }

        right[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], height[i]);
        }

        for (int i = 0; i < len; i++) {
            res += Math.max(0, Math.min(left[i], right[i]) - height[i]);
        }
        return res;
    }


    // Solution 2: two pointers
    // time: O(N), space: O(1)
    public int trapII(int[] height) {
        if (height == null || height.length == 0) return 0;

        int l = 0, r = height.length - 1;
        int leftMax = 0, rightMax = 0, res = 0;

        while (l <= r) {
            if (height[l] > leftMax) leftMax = height[l];
            if (height[r] > rightMax) rightMax = height[r];

            res += leftMax <= rightMax? leftMax - height[l++]: 0;
            res += rightMax < leftMax? rightMax - height[r--]: 0;
        }
        return res;
    }
}
