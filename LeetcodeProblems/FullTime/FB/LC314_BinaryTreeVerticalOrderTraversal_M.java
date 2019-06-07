package FullTime.FB;

import java.util.*;

/**
 * level order traversal (BFS + Map)
 *
 * time: O(N), N is the num of nodes
 * space: O(N)
 */
public class LC314_BinaryTreeVerticalOrderTraversal_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;

        Map<TreeNode, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> group = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();

        map.put(root, 0);
        q.offer(root);

        int min = 0;
        int max = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                int col = map.get(cur);
                min = Math.min(min, col);
                max = Math.max(max, col);

                group.putIfAbsent(col, new LinkedList<>());
                group.get(col).add(cur.val);

                if (cur.left != null) {
                    q.offer(cur.left);
                    map.put(cur.left, col - 1);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                    map.put(cur.right, col + 1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(group.get(i));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(4);
        TreeNode t32 = new TreeNode(5);
        TreeNode t41 = new TreeNode(6);
        TreeNode t42 = new TreeNode(7);

        t1.left = t21; t1.right = t22;
        t21.right = t31; t22.left = t32;
        t31.right = t41; t32.left = t42;

        System.out.println(new LC314_BinaryTreeVerticalOrderTraversal_M().verticalOrder(t1));
    }
}
