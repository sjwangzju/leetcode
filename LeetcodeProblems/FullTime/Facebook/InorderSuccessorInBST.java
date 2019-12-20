package FullTime.Facebook;

public class InorderSuccessorInBST {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
    //
    // Solution1: recursive
    // time: O(N), space: O(N)
    TreeNode res = null;
    int prev = 0;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        inorder(root, p);
        return res;
    }

    public void inorder(TreeNode root, TreeNode p) {
        if (root == null) return;
        inorder(root.left, p);
        if (root.val > p.val) {
            if (res == null) {
                res = root;
            }
            return;
        }
        inorder(root.right, p);
    }


    // Solution2: iterative
    // time: O(N), space: O(1)
    public TreeNode inorderSuccessorII(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;

        TreeNode res = null;

        while (root != null) {
            if (root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }
}
