package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sjwang on 09/18/2018.
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> L = new ArrayList<>();
        if (candidates.length == 0 || candidates == null) {
            return L;
        }
        Arrays.sort(candidates);
        backTracking(L, new ArrayList<>(), candidates, 0, target);
        return L;
    }

    public void backTracking(List<List<Integer>> L, List<Integer> cur, int[] candidates, int curSum, int target) {
        if (curSum > target) {
            return;
        }
        if (curSum == target) {
            L.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < candidates.length && curSum + candidates[i] <= target; i++) {
            if (cur.size() > 0 && cur.get(cur.size() - 1) <= candidates[i] || cur.size() == 0) {
                cur.add(candidates[i]);
                backTracking(L, cur, candidates, curSum + candidates[i], target);
                cur.remove(cur.size() - 1);
            }
        }
    }

    public static void main(String args[]) {
        int[] candidates = {2,3,5};
        int target = 8;
        List<List<Integer>> L = new CombinationSum().combinationSum(candidates, target);
        for (int i = 0; i < L.size(); i++) {
            System.out.println(L.get(i));
        }
    }
}
