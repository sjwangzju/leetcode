package FullTime.FB;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS - there should be no nodes after the first null node
 *
 * time: O(N), N is num of nodes
 * space: O(N)
 *
 */
public class LC958_CheckCompletenessOfABinaryTree_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) return false;

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

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(4);
        TreeNode t32 = new TreeNode(5);
        TreeNode t33 = new TreeNode(6);

        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        t22.left = t33;

        System.out.println(new LC958_CheckCompletenessOfABinaryTree_M().isCompleteTree(t1));
    }
}
