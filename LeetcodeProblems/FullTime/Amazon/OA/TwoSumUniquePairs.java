package FullTime.Amazon.OA;

import java.util.*;

public class TwoSumUniquePairs {

    public int findUniquePairs(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int n: nums) set.add(n);

        for (int num : nums) {
            if (map.containsKey(num) || map.containsKey(target - num)) continue;
            if (set.contains(target - num)) {
                map.put(num, target - num);
            }
        }
        return map.size();
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5};
        int target = 5;
        System.out.println(new TwoSumUniquePairs().findUniquePairs(nums, target));
    }
}
