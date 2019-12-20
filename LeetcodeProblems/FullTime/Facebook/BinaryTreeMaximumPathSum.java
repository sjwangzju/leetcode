package FullTime.Facebook;

public class BinaryTreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a non-empty binary tree, find the maximum path sum.
    // The path must contain at least one node and does not need to go through the root.
    //
    // time: O(N), space: O(N)
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);
        max = Math.max(root.val + leftMax + rightMax, max);
        return root.val + Math.max(leftMax, rightMax);
    }
}
