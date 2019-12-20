package FullTime.Facebook;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // BFS - null node should be the last to visit
    // time: O(N), space: O(N)
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        boolean isEnd = false;
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                isEnd = true;
            } else {
                if (isEnd) return false;
                q.offer(cur.left);
                q.offer(cur.right);
            }
        }
        return true;
    }
}
