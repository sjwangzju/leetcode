package FullTime.Facebook;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    // Given an array of integers and an integer k,
    // find the total number of continuous subarrays whose sum equals to k.
    //
    // Input:nums = [1,1,1], k = 2
    // Output: 2
    //
    // Thoughts:
    // 1. store sum frequency in HashMap
    // time: O(N), space: O(N)
    public int subarraySumI(int[] nums, int k) {
        int res = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }

    // if non-negative, can use two pointers
    // time: O(N), space: O(1)
    public int subarraySumII(int[] nums, int k) {
        int i = 0, j = 0, sum = 0, cnt = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum > k && i < j) {
                sum -= nums[i++];
            }
            if (sum == k) cnt++;
            j++;
        }
        return cnt;
    }


    public static void main(String[] args) {
        // test1: {2}, {4,-2}, {2}, {2,0}
        int[] nums = {2,4,-2,2,0};
        System.out.println(new SubarraySumEqualsK().subarraySumI(nums, 2));

        // test 2: non-negative
        int[] nums2 = {4,5,2,1,3,6};
        System.out.println(new SubarraySumEqualsK().subarraySumII(nums2, 8));
    }
}
