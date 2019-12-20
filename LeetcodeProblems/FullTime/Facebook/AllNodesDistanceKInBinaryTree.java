package FullTime.Facebook;

import java.util.*;

public class AllNodesDistanceKInBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Return a list of the values of all nodes that have a distance K from the target node.
    // The answer can be returned in any order.
    //
    // time: O(N), space: O(N)
    //
    List<Integer> res = new ArrayList<>();
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Set<TreeNode> visited = new HashSet<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if (root == null || target == null) return res;

        // DFS - set the parent for each node
        setParent(root);

        // BFS - traverse in level order
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                visited.add(cur);
                if (level == K) {
                    res.add(cur.val);
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

    // DFS
    public void setParent(TreeNode node) {
        if (node == null) return;
        if (node.left != null) {
            parent.put(node.left, node);
            setParent(node.left);
        }
        if (node.right != null) {
            parent.put(node.right, node);
            setParent(node.right);
        }
    }
}
