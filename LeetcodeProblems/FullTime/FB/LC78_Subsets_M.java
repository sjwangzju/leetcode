package FullTime.FB;

import java.util.LinkedList;
import java.util.List;

/**
 * Backtracking
 *
 * time: O(2^N)
 * space: O(2^N)
 */
public class LC78_Subsets_M {

    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        backtracking(nums, 0, new LinkedList<>());
        return res;
    }

    public void backtracking(int[] nums, int i, List<Integer> cur) {
        res.add(new LinkedList<>(cur));
        if (i == nums.length) {
            return;
        }

        for (int j = i; j < nums.length; j++) {
            cur.add(nums[j]);
            backtracking(nums, j + 1, cur);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = new LC78_Subsets_M().subsets(nums);
        for (List<Integer> list: res) {
            for (int n: list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
