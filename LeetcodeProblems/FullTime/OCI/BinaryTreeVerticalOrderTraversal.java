package FullTime.OCI;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // BFS
    // time: O(N), space: O(N)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Map<TreeNode, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> index = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        int min = 0, max = 0;

        map.put(root, 0);
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            int i = map.get(cur);
            min = Math.min(min, i);
            max = Math.max(max, i);

            index.putIfAbsent(i, new ArrayList<>());
            index.get(i).add(cur.val);

            if (cur.left != null) {
                map.put(cur.left, i - 1);
                q.offer(cur.left);
            }
            if (cur.right != null) {
                map.put(cur.right, i + 1);
                q.offer(cur.right);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(index.get(i));
        }
        return res;
    }
}
