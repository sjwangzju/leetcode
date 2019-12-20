package FullTime.LinkedIn;

public class PartitionToKEqualSumSubsets {

    // Given an array of integers nums and a positive integer k,
    // find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
    //
    // Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
    // Output: True
    // Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
    //
    // Note:
    // 1 <= k <= len(nums) <= 16.
    // 0 < nums[i] < 10000.
    //
    // Backtracking
    // time: O(k*2^N) -> O(2^N) for each subset
    // space: O(k*N)
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int n: nums) sum += n;
        if (sum % k != 0) return false;

        boolean[] visited = new boolean[nums.length];
        return isValid(nums, visited, sum/k, 0, k, 0);
    }

    public boolean isValid(int[] nums, boolean[] visited, int target, int index, int k, int cur) {
        if (k == 1) return true;
        if (cur > target) return false;
        if (cur == target) {
            return isValid(nums, visited, target, 0, k - 1, 0);
        }

        for (int i = index; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (isValid(nums, visited, target, i + 1, k, cur + nums[i])) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
