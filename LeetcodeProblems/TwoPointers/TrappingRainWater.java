package TwoPointers;


/**
 * Created by sjwang on 07/20/2018.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
 * In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 *
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        int leftmax = 0, rightmax = 0, sum = 0,
                i = 0, j = height.length - 1;
        while(i <= j){
            leftmax = Math.max(leftmax, height[i]);
            rightmax = Math.max(rightmax, height[j]);
            if(height[i] <= height[j]) sum += leftmax - height[i++];
            else sum += rightmax - height[j--];
        }
        return sum;
    }
    public static void main(String args[]){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
