package FullTime.OCI;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // We are given a binary tree (with root node root), a target node, and an integer value K.
    // Return a list of the values of all nodes that have a distance K from the target node.
    //
    // Thoughts:
    // 1. stores the parent node in HashMap
    //
    // time: O(N), space: O(N)
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        dfs(root);
        q.offer(target);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                visited.add(cur);
                if (level == K) {
                    res.add(cur.val);
                    continue;
                }
                if (cur.left != null && !visited.contains(cur.left)) {
                    q.offer(cur.left);
                }
                if (cur.right != null && !visited.contains(cur.right)) {
                    q.offer(cur.right);
                }
                if (parent.containsKey(cur) && !visited.contains(parent.get(cur))) {
                    q.offer(parent.get(cur));
                }
            }
            if (level == K) break;
            level++;
        }
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            parent.put(root.left, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right, root);
            dfs(root.right);
        }
    }
}
