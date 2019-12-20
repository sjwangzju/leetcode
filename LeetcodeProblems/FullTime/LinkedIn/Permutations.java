package FullTime.LinkedIn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

    /**
     * Permutations I (no duplicates)
     *
     * Given a collection of distinct integers, return all possible permutations.
     *
     * Example:
     *
     * Input: [1,2,3]
     * Output:
     * [
     *   [1,2,3],
     *   [1,3,2],
     *   [2,1,3],
     *   [2,3,1],
     *   [3,1,2],
     *   [3,2,1]
     * ]
     *
     * Thoughts:
     * 1. backtracking + visited
     *
     * time: O(N!), space: O(N!)
     *
     */
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        backtracking(nums, visited, new ArrayList<>());
        return res;
    }

    public void backtracking(int[] nums, boolean[] visited, List<Integer> cur) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            cur.add(nums[i]);
            backtracking(nums, visited, cur);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * Permutations II (contains duplicates)
     *
     * Thoughts:
     * 1. sort + backtracking + visited
     *
     * time: O(N!), space: O(N!)
     */
    List<List<Integer>> res1 = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        backtrackingII(nums, visited, new ArrayList<>());
        return res1;
    }

    public void backtrackingII(int[] nums, boolean[] visited, List<Integer> cur) {
        if (cur.size() == nums.length) {
            res1.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            visited[i] = true;
            cur.add(nums[i]);
            backtrackingII(nums, visited, cur);
            visited[i] = false;
            cur.remove(cur.size() - 1);
        }
    }
}
