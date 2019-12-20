package FullTime.Facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a binary tree, imagine yourself standing on the right side of it,
    // return the values of the nodes you can see ordered from top to bottom.
    //
    // Solution1: BFS
    // time: O(N), space: O(N)
    public List<Integer> rightSideViewI(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
                if (i == size - 1) res.add(node.val);
            }
        }
        return res;
    }

    // Solution2: DFS
    // time: O(N), space: O(N)
    /***********************************************************/
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideViewII(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null) return;
        if (level == res.size()) {
            res.add(root.val);
        }
        dfs(root.right, level + 1);
        dfs(root.left, level + 1);
    }
}
