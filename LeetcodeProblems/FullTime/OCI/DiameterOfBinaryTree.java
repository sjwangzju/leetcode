package FullTime.OCI;

public class DiameterOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Given a binary tree, you need to compute the length of the diameter of the tree.
     * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
     * This path may or may not pass through the root.
     *
     * dfs
     *
     * time: O(N), space: O(N)
     */
    int res = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);
        res = Math.max(res, l + r);
        return 1 + Math.max(l, r);
    }
}
