package FullTime.Facebook;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
    // If two nodes are in the same row and column, the order should be from left to right.
    //
    // Thoughts:
    // 1. BFS traversal
    // 2. two hashMaps to store the index of each node
    // 3. keep updating min & max index
    //
    // time: O(N), space: O(N)
    List<List<Integer>> res = new ArrayList<>();
    Map<TreeNode, Integer> map = new HashMap<>();
    Map<Integer, List<Integer>> index = new HashMap<>();
    int min = 0, max = 0;

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return res;
        map.put(root, 0);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            int i = map.get(tmp);
            min = Math.min(min, i);
            max = Math.max(max, i);

            if (!index.containsKey(i)) {
                index.put(i, new ArrayList<>());
            }
            index.get(i).add(tmp.val);

            if (tmp.left != null) {
                map.put(tmp.left, i - 1);
                q.offer(tmp.left);
            }
            if (tmp.right != null) {
                map.put(tmp.right, i + 1);
                q.offer(tmp.right);
            }
        }

        for (int i = min; i <= max; i++) {
            res.add(index.get(i));
        }
        return res;
    }
}
