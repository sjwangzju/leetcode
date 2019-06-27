package FullTime.FB;

import java.util.HashSet;
import java.util.Set;

/**
 * Backtracking with memory - Use Set for memorization
 *
 * time: O(2^N)
 * space: O(2^N)
 */
public class LC416_PartitionEqualSubsetSum_M {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        if (sum % 2 == 1) return false;

        return backtracking(sum, nums, 0, 0, new HashSet<>());
    }

    public boolean backtracking(int sum, int[] nums, int cur, int i, Set<Integer> visited) {
        if (cur == sum / 2) {
            return true;
        }
        if (visited.contains(cur) || i > nums.length || cur > sum / 2) {
            return false;
        }
        visited.add(cur);
        for (int j = i; j < nums.length; j++) {
            cur += nums[j];
            if (backtracking(sum, nums, cur, j + 1, visited)) {
                return true;
            }
            cur -= nums[j];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        System.out.println(new LC416_PartitionEqualSubsetSum_M().canPartition(nums));
    }
}
