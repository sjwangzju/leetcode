package FullTime.LinkedIn;

public class BinaryTreeUpsideDown {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a binary tree where all the right nodes are either leaf nodes with a sibling
    // (a left node that shares the same parent node) or empty,
    // flip it upside down and turn it into a tree where
    // the original right nodes turned into left leaf nodes. Return the new root.
    //
    // Input: [1,2,3,4,5]
    //
    //     1
    //    / \
    //   2   3
    //  / \   \
    // 4   5   6
    //
    // Output: return the root of the binary tree [4,5,2,#,#,3,1]
    //
    //   4
    //  / \
    // 5   2
    //    / \
    //   3   1
    //    \
    //     6
    //
    // Thoughts: recursively
    //
    // bottom left -> root
    //
    // 1.for left subtree:
    //      parent        -> right child
    //      right_sibling -> left child
    //
    // 2.for right subtree: no change
    //
    // time: O(N), space: O(logN)
    //
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        return newRoot;
    }
}
