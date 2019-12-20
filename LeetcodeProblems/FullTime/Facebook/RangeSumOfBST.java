package FullTime.Facebook;

public class RangeSumOfBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given the root node of a binary search tree,
    // return the sum of values of all nodes with value between L and R (inclusive).
    //
    // Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
    // Output: 32
    //
    // time: O(N), space: O(N)
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;

        if (root.val < L) {
            return rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return rangeSumBST(root.left, L, R);
        }
        return root.val + rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L, R);
    }
}
