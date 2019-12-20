package FullTime.Facebook;

public class DiameterOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a binary tree, you need to compute the length of the diameter of the tree.
    // The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
    // This path may or may not pass through the root.
    // Note: The length of path between two nodes is represented by the number of edges between them.
    //
    // time: O(N), space: O(N)
    //
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        getHeight(root);
        return max;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        max = Math.max(max, leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }

}
