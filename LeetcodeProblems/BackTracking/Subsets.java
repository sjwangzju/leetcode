package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sjwang on 10/06/2018.
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> L = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) {
            return L;
        }
        backtracking(L, cur, 0, nums);
        return L;
    }
    public void backtracking(List<List<Integer>> L, List<Integer> cur, int pos, int[] nums) {
        if (pos > nums.length) {
            return;
        } else {
            L.add(new ArrayList<>(cur));
            for (int i = pos; i < nums.length; i++) {
                if (cur.size() > 0 && nums[i] > cur.get(cur.size() - 1) || cur.size() == 0) {
                    cur.add(nums[i]);
                    backtracking(L, cur, pos + 1, nums);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
    public static void main(String args[]) {
        int[] nums = {1,2,3};
        List<List<Integer>> L = new Subsets().subsets(nums);
        for (int i = 0; i < L.size(); i++) {
            System.out.println(L.get(i));
        }
    }
}
