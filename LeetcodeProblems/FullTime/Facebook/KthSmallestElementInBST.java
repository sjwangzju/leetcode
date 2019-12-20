package FullTime.Facebook;

public class KthSmallestElementInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
    //
    // preorder
    // time: O(N), space: O(N)
    int res = -1, i = 1;
    public int kthSmallest(TreeNode root, int k) {
        preorder(root, k);
        return res;
    }

    public void preorder(TreeNode root, int k) {
        if (root == null || i > k) return;
        preorder(root.left, k);
        if (i == k) {
            res = root.val;
        }
        i++;
        preorder(root.right, k);
    }
}
