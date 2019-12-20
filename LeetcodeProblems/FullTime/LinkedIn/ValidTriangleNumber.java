package FullTime.LinkedIn;

import java.util.Arrays;

public class ValidTriangleNumber {

    // Given an array consists of non-negative integers,
    // your task is to count the number of triplets chosen from the array
    // that can make triangles if we take them as side lengths of a triangle.
    //
    // Input: [2,2,3,4]
    // Output: 3
    // Explanation:
    // Valid combinations are:
    // 2,3,4 (using the first 2)
    // 2,3,4 (using the second 2)
    // 2,2,3
    //
    // Thoughts:
    // 1. sort + two pointers (i, j)
    // 2. fix the longest side, search for shorter sides
    //
    // time: O(N^2), space: O(1)
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        Arrays.sort(nums);
        for (int k = nums.length - 1; k > 1; k--) {
            int i = 0, j = k - 1;
            while (i < j) {
                if (nums[i] + nums[j] > nums[k]) {
                    res += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return res;
    }
}
