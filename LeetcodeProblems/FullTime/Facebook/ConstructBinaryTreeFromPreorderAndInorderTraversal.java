package FullTime.Facebook;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given preorder and inorder traversal of a tree, construct the binary tree.
    //
    // preorder = [3,9,20,15,7]
    // inorder = [9,3,15,20,7]
    //
    // Thoughts:
    // 1. build the tree recursively
    // 2. store the indexes in map
    //
    // time: O(N), space: O(N)
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    int i = 0;

    // find the index of preorder[i] in inorder arr
    // (lo, index - 1) is left tree
    // (index + 1, hi) is right tree
    public TreeNode build(int[] preorder, int lo, int hi) {
        if (lo > hi || i == preorder.length) return null;

        TreeNode root = new TreeNode(preorder[i++]);
        root.left = build(preorder, lo, map.get(root.val) - 1);
        root.right = build(preorder, map.get(root.val) + 1, hi);
        return root;
    }
}
