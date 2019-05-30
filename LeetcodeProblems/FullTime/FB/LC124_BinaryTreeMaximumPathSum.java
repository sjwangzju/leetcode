package FullTime.FB;

/**
 * Binary tree recursion
 *
 * time: O(N), N is the num of nodes in the tree
 * space: O(lgN)~O(N), level of the tree
 */
public class LC124_BinaryTreeMaximumPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;

        int leftPath = Math.max(0, dfs(root.left));
        int rightPath = Math.max(0, dfs(root.right));

        res = Math.max(res, leftPath + rightPath + root.val);

        return Math.max(leftPath, rightPath) + root.val;
    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(-10);
        TreeNode t21 = new TreeNode(9);
        TreeNode t22 = new TreeNode(20);
        TreeNode t31 = new TreeNode(15);
        TreeNode t32 = new TreeNode(7);

        t11.left = t21; t11.right = t22;
        t22.left = t31; t22.right = t32;

        System.out.println(new LC124_BinaryTreeMaximumPathSum().maxPathSum(t11));
    }
}
