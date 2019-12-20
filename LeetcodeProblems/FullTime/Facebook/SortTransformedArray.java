package FullTime.Facebook;

public class SortTransformedArray {

    // Given a sorted array of integers nums and integer values a, b and c.
    // Apply a quadratic function of the form f(x) = ax2 + bx + c to each element x in the array.
    //
    // Input: nums = [-4,-2,2,4], a = 1, b = 3, c = 5
    // Output: [3,9,15,33]
    //
    // two pointers
    // time: O(N), space: O(1)
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] res = new int[nums.length];
        int index = a >= 0? nums.length - 1: 0;
        int i = 0, j = nums.length - 1;

        while (i <= j) {
            if (a >= 0) {
                res[index--] = func(nums[i], a, b, c) >= func(nums[j], a, b, c)? func(nums[i++], a, b, c): func(nums[j--], a, b, c);
            } else {
                res[index++] = func(nums[i], a, b, c) <= func(nums[j], a, b, c)? func(nums[i++], a, b, c): func(nums[j--], a, b, c);
            }
        }
        return res;
    }

    public int func(int x, int a, int b, int c) {
        return a*x*x + b*x + c;
    }
}
