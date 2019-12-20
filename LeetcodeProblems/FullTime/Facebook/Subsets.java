package FullTime.Facebook;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // Given a set of distinct integers, nums, return all possible subsets (the power set).
    // Note: The solution set must not contain duplicate subsets.
    //
    // Input: nums = [1,2,3]
    // Output:
    // [
    //  [3],
    //  [1],
    //  [2],
    //  [1,2,3],
    //  [1,3],
    //  [2,3],
    //  [1,2],
    //  []
    // ]
    //
    // Thoughts:
    // 1. backtracking
    // 2. without duplicates
    //
    // time: O(2^N), space: O(2^N)

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0, new ArrayList<>());
        return res;
    }

    public void backtracking(int[] nums, int i, List<Integer> cur) {
        res.add(new ArrayList<>(cur));

        for (int j = i; j < nums.length; j++) {
            cur.add(nums[j]);
            backtracking(nums, j + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }
}
