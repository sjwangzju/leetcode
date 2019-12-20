package FullTime.Facebook;

public class ValidateBinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Solution 1:
    // 1. initialize: lo = Long.MIN_VALUE, hi = Long.MAX_VALUE
    //
    // time: O(N), space: O(logN)
    public boolean isValidBSTI(TreeNode root) {
        if (root == null) return true;
        return isValidI(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidI(TreeNode root, long lo, long hi) {
        if (root == null) return true;
        if (root.val >= hi || root.val <= lo) return false;

        return isValidI(root.left, lo, root.val) && isValidI(root.right, root.val, hi);
    }


    // Solution 2:
    // 1. initialize: lo = null, hi = null
    //
    // time: O(N), space: O(logN)
    public boolean isValidBSTII(TreeNode root) {
        if (root == null) return true;
        return isValidII(root, null, null);
    }

    public boolean isValidII(TreeNode root, Integer lo, Integer hi) {
        if (root == null) return true;

        if (hi != null && root.val >= hi || lo != null && root.val <= lo) return false;

        return isValidII(root.left, lo, root.val) && isValidII(root.right, root.val, hi);
    }
}
