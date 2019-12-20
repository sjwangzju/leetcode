package FullTime.Facebook;

public class FlattenBinaryTreeToLinkedList {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a binary tree, flatten it to a linked list in-place.
    //
    // Solution1: post-order
    // time: O(N^2), space: O(N)
    public void flattenI(TreeNode root) {
        if (root == null) return;
        flattenI(root.left);
        flattenI(root.right);

        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;

        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = tmp;
    }


    /****************************************/
    // Solution2:
    // 1. In the flattened tree, each node's right child points to the next node of a pre-order traversal.
    // 2. do a reverse pre-order traversal (right, left, root)
    // 3. keep a variable to store prev TreeNode

    // time: O(N), space: O(N)
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = prev;
        prev = root;
    }
}
