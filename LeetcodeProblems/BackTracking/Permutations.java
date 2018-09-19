package BackTracking;

import java.util.*;

/**
 * Created by sjwang on 09/18/2018.
 *
 * Given a collection of distinct integers, return all possible permutations.
 *
 * Example:
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
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> L = new ArrayList<>();
        if (nums == null || nums.length == 0) return L;
        List<Integer> l = new ArrayList<>();
        backTracking(L, l, nums);
        return L;
    }

    public void backTracking(List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) {
                continue;
            }
            cur.add(nums[i]);
            backTracking(res, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String args[]) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new Permutations().permute(nums);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
