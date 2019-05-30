package FullTime.FB;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Requirement: time: o(1), memory O(h) h is height of the tree
 *
 * Solution1: in-order traversal
 * time: O(1)
 * space: O(N), N is num of nodes
 *
 * Solution2: stack
 * time: O(1)
 * space: O(h)
 *
 */
public class LC173_BinarySearchTreeIterator_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // solution 1 - in-order traversal
    static class BSTIteratorI {

        Queue<Integer> queue;

        public BSTIteratorI(TreeNode root) {
            this.queue = new LinkedList<>();
            dfs(root);
        }

        public void dfs(TreeNode root) {
            if (root == null) return;
            dfs(root.left);
            queue.offer(root.val);
            dfs(root.right);
        }

        /** @return the next smallest number */
        public int next() {
            return queue.poll();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return queue.size() > 0;
        }
    }

    // solution 2 - stack
    static class BSTIteratorII {

        Stack<TreeNode> stack;
        TreeNode cur;

        public BSTIteratorII(TreeNode root) {
            this.stack = new Stack<>();
            this.cur = root;
        }

        /** @return the next smallest number */
        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode t = stack.pop();
            cur = t.right;
            return t.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !(stack.empty() && cur == null);
        }
    }

    public static void main(String[] args) {
        TreeNode t11 = new TreeNode(7);
        TreeNode t21 = new TreeNode(3);
        TreeNode t22 = new TreeNode(15);
        TreeNode t31 = new TreeNode(9);
        TreeNode t32 = new TreeNode(20);

        t11.left = t21; t11.right = t22;
        t22.left = t31; t22.right = t32;

        BSTIteratorII iterator = new BSTIteratorII(t11);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
