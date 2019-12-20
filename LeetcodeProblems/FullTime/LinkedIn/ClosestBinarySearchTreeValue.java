package FullTime.LinkedIn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ClosestBinarySearchTreeValue {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Closest Binary Search Tree Value (find one closest)
     *
     * Given a non-empty binary search tree and a target value,
     * find the value in the BST that is closest to the target.
     *
     * root = [4,2,5,1,3], target = 3.714286
     * output = [4]
     *
     * Thoughts:
     * 1. Iteratively
     * 2. keep searching left / right tree
     *
     * time: O(N), space: O(1)
     *
     */
    public int closestValue(TreeNode root, double target) {
        double diff = Double.MAX_VALUE;
        int res = 0;
        while (root != null) {
            if (Math.abs(root.val - target) < diff) {
                diff = Math.abs(root.val - target);
                res = root.val;
            }
            if (target <= root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }


    /**
     * Closest Binary Search Tree Value II (find k closest)
     *
     * Given a non-empty binary search tree and a target value,
     * find k values in the BST that are closest to the target.
     *
     * root = [4,2,5,1,3], target = 3.714286, and k = 2
     * output = [3,4]
     *
     * Thoughts:
     * 1. inorder traversal
     *
     * time: O(N), space: O(logN)
     */

    Queue<Integer> q = new LinkedList<>();

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        if (root == null || k == 0) return new LinkedList<>();
        inorder(root, target, k);
        return new LinkedList<>(q);
    }

    public void inorder(TreeNode root, double target, int k) {
        if (root == null) return;
        inorder(root.left, target, k);
        if (q.size() < k) {
            q.offer(root.val);
        } else {
            if (Math.abs(target - root.val) < Math.abs(target - q.peek())) {
                q.poll();
                q.offer(root.val);
            } else {
                return;
            }
        }
        inorder(root.right, target, k);
    }
}
