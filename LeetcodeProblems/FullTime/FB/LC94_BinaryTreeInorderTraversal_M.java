package FullTime.FB;

import java.util.LinkedList;
import java.util.List;

/**
 * Recursion
 */
public class LC94_BinaryTreeInorderTraversal_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        inorder(res, root);
        return res;
    }

    public void inorder(List<Integer> res, TreeNode node) {
        if (node == null) return;
        inorder(res, node.left);
        res.add(node.val);
        inorder(res, node.right);
    }
}
