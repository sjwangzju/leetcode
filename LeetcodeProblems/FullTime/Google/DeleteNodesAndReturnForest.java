package FullTime.Google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    List<TreeNode> res = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int n: to_delete) {
            set.add(n);
        }
        if (!set.contains(root.val)) res.add(root);
        delete(root);
        return res;
    }

    public TreeNode delete(TreeNode root) {
        if (root == null) return null;
        root.left = delete(root.left);
        root.right = delete(root.right);
        if (set.contains(root.val)) {
            if (root.left != null) res.add(root.left);
            if (root.right != null) res.add(root.right);
            root.val = -1;
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(3);
        n1.left = n21; n1.right = n22;
        List<TreeNode> res = new DeleteNodesAndReturnForest().delNodes(n1, new int[]{2});
    }
}
