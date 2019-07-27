package FullTime.FB;

import java.util.LinkedList;
import java.util.List;

/**
 * backtracking
 *
 * time: O(n!)
 * space: O(n!)
 */
public class LC46_Permutations_M {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        backtracking(res, nums, new LinkedList<>());
        return res;
    }

    public void backtracking(List<List<Integer>> res, int[] nums, List<Integer> list) {
        if (list.size() == nums.length) {
            res.add(new LinkedList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!list.contains(nums[i])) {
                list.add(nums[i]);
                backtracking(res, nums, list);
                list.remove(list.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        List<List<Integer>> res = new LC46_Permutations_M().permute(nums);

        for (List<Integer> list: res) {
            for (int n: list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
