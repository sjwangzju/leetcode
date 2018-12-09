package Airbnb;

import java.util.*;

public class FindCaseCombinationOfString_21 {

    // find permutations

    /**
     * lc46 -- nums[] is a collection of distinct integers
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        getPermutations(res, cur, nums);
        return res;
    }

    public void getPermutations(List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cur.contains(nums[i])) continue;
            cur.add(nums[i]);
            getPermutations(res, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * lc47 -- nums[] may contain duplicates
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0 || nums == null) {
            return res;
        }
        List<Integer> cur = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        getPermutationsII(used, res, cur, nums);
        return res;
    }

    public void getPermutationsII(boolean[] used, List<List<Integer>> res, List<Integer> cur, int[] nums) {
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            cur.add(nums[i]);
            used[i] = true;
            getPermutationsII(used, res, cur, nums);
            used[i] = false;
            cur.remove(cur.size() - 1);
        }
    }

    // find subsets

    /**
     * lc78: get subsets with no duplicates
     *
     * e.g. [1,2,3] ->
     * []
     * [1]
     * [1,2]
     * [1,2,3]
     * [2]
     * [2,3]
     * [3]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        getSubsets(nums, res, cur, 0);
        return res;
    }

    public void getSubsets(int[] nums, List<List<Integer>> res, List<Integer> cur, int start) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            cur.add(nums[i]);
            getSubsets(nums, res, cur, i + 1);
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * lc90: get subsets with duplicates
     *
     * e.g. [1,2,2] ->
     * []
     * [1]
     * [1,2]
     * [1,2,2]
     * [2]
     * [2,2]
     *
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        getSubsetsWithDup(res, cur, nums, 0);
        return res;
    }

    public void getSubsetsWithDup(List<List<Integer>> res, List<Integer> cur, int[] nums, int start) {
        res.add(new ArrayList<>(cur));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            getSubsetsWithDup(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }


    /**
     * find combination sum
     *
     * run time: O(2^n)
     * space: O(2^n)
     */

    /**
     * find combination sum with no duplicates, each element can be used multiple times
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> findCombinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backTracking(res, cur, nums, target, 0);
        return res;
    }

    public void backTracking(List<List<Integer>> res, List<Integer> cur, int[] nums, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) return;
            cur.add(nums[i]);
            backTracking(res, cur, nums, target - nums[i], i); // start index is still i because this element can be used again
            cur.remove(cur.size() - 1);
        }
    }

    /**
     * find combination sum with duplicates, each element can be used once
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> findCombinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        backTracking2(res, cur, nums, target, 0);
        return res;
    }

    public void backTracking2(List<List<Integer>> res, List<Integer> cur, int[] nums, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) return;
            if (i > start && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            backTracking2(res, cur, nums, target - nums[i], i + 1);
            cur.remove(cur.size() - 1);
        }
    }


    /**
     * AB_21
     * @param input
     * @return
     */
    public List<String> permutationWithCases(String input) {
        List<String> res = new ArrayList<>();
        if (input == null) return res;
        char[] chs = input.toCharArray();
        getPermutationWithCases(res, new StringBuilder(), chs, 0);
        return res;
    }

    public void getPermutationWithCases(List<String> res, StringBuilder cur, char[] chs, int start) {
        if (cur.length() == chs.length) {
            res.add(cur.toString());
            return;
        }
        for (int i = start; i < chs.length; i++) {
            if (i == cur.length()) {
                // add lowercase letter
                cur.append(Character.toLowerCase(chs[i]));
                getPermutationWithCases(res, cur, chs, start + 1);
                cur.deleteCharAt(cur.length() - 1);

                // add uppercase letter
                cur.append(Character.toUpperCase(chs[i]));
                getPermutationWithCases(res, cur, chs, start + 1);
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = new ArrayList<>();
        res = new FindCaseCombinationOfString_21().findCombinationSum2(nums, 5);
        for (List<Integer> list: res) {
            for (int n: list) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

//        String input = "abc";
//        List<String> res = new FindCaseCombinationOfString_21().permutationWithCases(input);
//        for (String s: res) {
//            System.out.println(s);
//        }
    }
}
