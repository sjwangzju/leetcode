package FullTime.Facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinarySearchTreeIterator {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Implement an iterator over a binary search tree (BST)
    //
    // Solution1:
    // 1. inorder traversal -> put all elements in the list in the constructor
    //
    // time: constructor: O(N)
    //       next: O(1)
    //       hasNext: O(1)
    // space: O(N) for the list
    public class BSTIteratorI {
        List<Integer> list;
        int index;
        public BSTIteratorI(TreeNode root) {
            this.list = new ArrayList<>();
            this.index = 0;
            inorder(root);
        }

        // time: O(N)
        public void inorder(TreeNode root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.val);
            inorder(root.right);
        }

        // time: O(1)
        /** @return the next smallest number */
        public int next() {
            return list.get(index++);
        }

        // time: O(1)
        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return index < list.size();
        }
    }


    // Solution2:
    // 1. use stack to store left children, getLeftChildren(root)
    // 2. pop a TreeNode out, and find the left children of root.right

    // time: constructor: O(h)
    //       next: avg O(1), worst O(N)
    //       hasNext: O(1)
    // space: O(h)
    public class BSTIteratorII {

        Stack<TreeNode> stack;
        public BSTIteratorII(TreeNode root) {
            this.stack = new Stack<>();
            getLeftChildren(root);
        }

        public void getLeftChildren(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        // time: avg: O(1), worst: O(N) (skewed tree)
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
}
