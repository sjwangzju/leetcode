package FullTime.LinkedIn;

import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.
 *
 * Shuffle the array [1,2,3] and return its result.
 * Any permutation of [1,2,3] must equally likely to be returned.
 *
 */
public class ShuffleArray {

    class Solution {

        int[] nums;
        Random rd;

        public Solution(int[] nums) {
            this.nums = nums;
            this.rd = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] res = nums.clone();
            for (int i = 0; i < nums.length; i++) {
                int j = rd.nextInt(i + 1);
                swap(res, i, j);
            }
            return res;
        }

        public void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
