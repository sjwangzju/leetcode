package FullTime.Facebook;

import java.util.HashSet;
import java.util.Set;

public class IsValidBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given an array of TreeNodes, return whether they can construct one and only one binary tree
    //
    // Thoughts: (valid binary tree?)
    // 1. no cycle
    // 2. each node has only one parent
    // 3. connected
    //
    // time: O(N), space: O(N)
    public boolean isValid(TreeNode[] nodes) {
        Set<TreeNode> set = new HashSet<>();
        for (TreeNode node: nodes) {
            // check if cycle exists
            if (node.left != null && set.contains(node.left)
                    || node.right != null && set.contains(node.right)) {
                return false;
            }
            if (node.left != null) set.add(node.left);
            if (node.right != null) set.add(node.right);
        }
        // only root node is not in the set
        // check connected & cycle
        if (set.size() + 1 != nodes.length) return false;

        // check the number of nodes in the set
        int cnt = 0;
        for (TreeNode node: nodes) {
            if (set.contains(node)) {
                cnt++;
            }
        }
        return nodes.length == cnt + 1;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(3);
        TreeNode n3 = new TreeNode(4);
        n1.left = n21; n1.right = n22;
        n3.left = n1;
        n22.right = n3;
        TreeNode[] nodes = new TreeNode[4];
        nodes[0] = n22;
        nodes[1] = n1;
        nodes[2] = n21;
        nodes[3] = n3;
        boolean res = new IsValidBinaryTree().isValid(nodes);
        System.out.println(res);
    }
}
