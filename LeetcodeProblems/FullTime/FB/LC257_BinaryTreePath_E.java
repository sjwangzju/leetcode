package FullTime.FB;

import java.util.LinkedList;
import java.util.List;

/**
 * DFS
 *
 * time: O(N)
 * space: O(logN)
 */
public class LC257_BinaryTreePath_E {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    List<String> res = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return res;
        dfs(root, "");
        return res;
    }

    public void dfs(TreeNode node, String cur) {
        if (cur.length() != 0) {
            cur += "->";
        }
        cur += node.val;

        if (node.left == null && node.right == null) {
            res.add(cur);
            return;
        }
        if (node.left != null) {
            dfs(node.left, cur);
        }
        if (node.right != null) {
            dfs(node.right, cur);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(5);
        t1.left = t21; t1.right = t22;
        t21.right = t31;

        List<String> res = new LC257_BinaryTreePath_E().binaryTreePaths(t1);
        for (String s: res) {
            System.out.println(s);
        }
    }
}
