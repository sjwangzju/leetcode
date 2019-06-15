package FullTime.FB;

/**
 * dp - two arrays: leftMax & rightMax
 *
 * volume of rain at pos i: min(leftmax[i], rightmax[i]) - height[i]
 *
 * time: O(N)
 * space: O(N)
 */
public class LC42_TrappingRainWater_H {

    public int trap(int[] height) {
        if (height == null || height.length < 3) return 0;

        int len = height.length;
        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int sum = 0;

        leftMax[0] = height[0];
        rightMax[len - 1] = height[len - 1];

        for (int i = 1; i < len; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 0; i < len; i++) {
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] height = {1,0,2};
        System.out.println(new LC42_TrappingRainWater_H().trap(height));
    }
}
