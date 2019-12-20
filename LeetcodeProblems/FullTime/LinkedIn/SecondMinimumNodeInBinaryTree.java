package FullTime.LinkedIn;

import java.util.PriorityQueue;

public class SecondMinimumNodeInBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given such a binary tree, you need to output the second minimum value in the set
    // made of all the nodes' value in the whole tree.
    //
    // If no such second minimum value exists, output -1 instead.
    //
    // BFS
    // time: O(N), space: O(N)
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;

        PriorityQueue<TreeNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        pq.offer(root);
        while (!pq.isEmpty()) {
            TreeNode node = pq.poll();
            if (node.val > root.val) return node.val;
            if (node.left != null) pq.offer(node.left);
            if (node.right != null) pq.offer(node.right);
        }
        return -1;
    }
}
