package FullTime.FB;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * BFS
 *
 * time: O(N), N is num of nodes
 * space: O(N)
 */
public class LC199_BinaryTreeRightSIdeView_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
                if (i == size - 1) {
                    res.add(cur.val);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(5);
        TreeNode t32 = new TreeNode(4);
        t1.left = t21; t1.right = t22;
        t21.right = t31; t22.right = t32;
        List<Integer> res = new LC199_BinaryTreeRightSIdeView_M().rightSideView(t1);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
