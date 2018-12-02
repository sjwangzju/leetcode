package Airbnb;

import java.util.*;

public class FindCaseCombinationOfString_21 {
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


    /**
     * lc78
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
        if (start > nums.length - 1) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (cur.size() == 0 || cur.size() > 0 && nums[i] > cur.get(cur.size() - 1)) {
                cur.add(nums[i]);
                getSubsets(nums, res, cur, start + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    /**
     * lc90
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
        getSubsetsWithDup(res, cur, nums, 0, new boolean[nums.length]);
        return res;
    }

    public void getSubsetsWithDup(List<List<Integer>> res, List<Integer> cur, int[] nums, int start, boolean[] used) {
        res.add(new ArrayList<>(cur));
        if (start > nums.length - 1) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i] || i > 0 && (nums[i] == nums[i - 1] && !used[i - 1] || cur.size() > 0 && nums[i] < cur.get(cur.size() - 1))) continue;
            cur.add(nums[i]);
            used[i] = true;
            getSubsetsWithDup(res, cur, nums, start + 1, used);
            used[i] = false;
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
//        int[] nums = {1,2,3};
//        List<List<Integer>> res = new ArrayList<>();
//        res = new FindCaseCombinationOfString_21().subsetsWithDup(nums);
//        for (List<Integer> list: res) {
//            for (int n: list) {
//                System.out.print(n + " ");
//            }
//            System.out.println();
//        }

        String input = "abc";
        List<String> res = new FindCaseCombinationOfString_21().permutationWithCases(input);
        for (String s: res) {
            System.out.println(s);
        }
    }
}
