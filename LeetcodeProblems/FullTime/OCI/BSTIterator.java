package FullTime.OCI;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST).
 * Your iterator will be initialized with the root node of a BST.
 *
 * next() and hasNext() should run in average O(1) time and uses O(h) memory,
 * where h is the height of the tree.
 */
public class BSTIterator {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        getLeftChildren(root);
    }

    public void getLeftChildren(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    // time: avg O(1)
    /** @return the next smallest number */
    public int next() {
        TreeNode tmp = stack.pop();
        getLeftChildren(tmp.right);
        return tmp.val;
    }

    // time: O(1)
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
