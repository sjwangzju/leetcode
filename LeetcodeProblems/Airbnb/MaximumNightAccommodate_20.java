package Airbnb;

import java.util.*;

public class MaximumNightAccommodate_20 {

    /**
     * the same as lc198
     * @param request
     * @return
     */
    public int findMaximumNights(int[] request) {
        if (request.length == 0 || request == null) return 0;

        int f1 = 0; int f2 = 0;
        for (int i = 0; i < request.length; i++) {
            int tmp = Math.max(f2, f1 + request[i]);
            f1 = f2;
            f2 = tmp;
        }
        return f2;
    }

    /**
     * lc213
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(findMax(nums, 0, nums.length - 2), findMax(nums, 1, nums.length - 1));
    }

    public int findMax(int[] nums, int start, int end) {
        int f1 = 0; int f2 = 0;
        for (int i = start; i <= end; i++) {
            int tmp = Math.max(f2, f1 + nums[i]);
            f1 = f2;
            f2 = tmp;
        }
        return f2;
    }

    /**
     * lc337
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        if (root == null) return 0;
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
    }

    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0,0};
        }
        int[] res = new int[2];
        int[] leftMax = helper(root.left);
        int[] rightMax = helper(root.right);
        res[0] = Math.max(leftMax[0], leftMax[1])
                + Math.max(rightMax[0], rightMax[1]);
        res[1] = root.val + leftMax[0] + rightMax[0];
        return res;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        int[] request = {1};
//        int max = new MaximumNightAccommodate_20().findMaximumNights(request);
//        System.out.println(max);

//        int max = new MaximumNightAccommodate_20().rob(request);
//        System.out.println(max);

        TreeNode t1 = new TreeNode(3);
        TreeNode t21 = new TreeNode(4);
        TreeNode t22 = new TreeNode(5);
        TreeNode t31 = new TreeNode(1);
        TreeNode t32 = new TreeNode(3);
        TreeNode t34 = new TreeNode(1);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32; t22.right = t34;
        int max = new MaximumNightAccommodate_20().rob(t1);
        System.out.println(max);
    }
}
