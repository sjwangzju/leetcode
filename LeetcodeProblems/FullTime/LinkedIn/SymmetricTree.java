package FullTime.LinkedIn;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     *
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     *
     *
     */

    // Solution1: recursive
    // time: O(N), space: O(N)
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSame(root.left, root.right);
    }

    public boolean isSame(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;
        return n1.val == n2.val && isSame(n1.left, n2.right) && isSame(n1.right, n2.left);
    }


    // Solution2: iterative
    // time: O(N), space: O(N)
    public boolean isSymmetricII(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode n1 = q.poll();
            TreeNode n2 = q.poll();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null || n1.val != n2.val) return false;
            q.offer(n1.left);
            q.offer(n2.right);
            q.offer(n1.right);
            q.offer(n2.left);
        }
        return true;
    }
}
