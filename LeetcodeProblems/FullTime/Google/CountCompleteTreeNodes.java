package FullTime.Google;

public class CountCompleteTreeNodes {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // Solution 1
    // time: O(N), space: O(logN)
    /***************************************/
    public int countNodesI(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodesI(root.left) + countNodesI(root.right);
    }

    // Solution 2
    // if current subtree is full, return 2^d - 1 directly
    // time: O(N), space: O(logN)
    /***************************************/
    public int countNodesII(TreeNode root) {
        if (root == null) return 0;
        int left = getLeftHeight(root), right = getRightHeight(root);
        return left == right? (int)(Math.pow(2, left) - 1)
                : 1 + countNodesII(root.left) + countNodesII(root.right);
    }

    public int getLeftHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + getLeftHeight(root.left);
    }

    public int getRightHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + getRightHeight(root.right);
    }



}
