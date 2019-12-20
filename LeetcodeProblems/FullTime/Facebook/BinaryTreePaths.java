package FullTime.Facebook;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a binary tree, return all root-to-leaf paths.
    //
    // DFS
    //
    // time: O(N), space: O(N)
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode root, String s) {
        if (root == null) return;

        if (s.length() > 0) s += "->";
        s += root.val + "";

        if (root.left == null && root.right == null) {
            res.add(s);
            return;
        }
        dfs(root.left, s);
        dfs(root.right, s);
    }
}
