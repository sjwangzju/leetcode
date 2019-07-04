package FullTime.FB;

import java.util.*;

/**
 * HashMap save parent, then BFS from target node
 *
 * time: O(N)
 * space: O(N)
 */
public class LC863_AllNodesDistanceKInBinaryTree_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    Map<TreeNode, TreeNode> parent = new HashMap<>();
    List<TreeNode> visited = new LinkedList<>();
    List<Integer> res = new LinkedList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        findParent(root, null);
        // BFS
        int dist = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.add(target);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (dist == K) {
                    res.add(cur.val);
                    continue;
                }
                addNode(cur.left, q);
                addNode(cur.right, q);
                addNode(parent.get(cur), q);
            }
            if (dist == K) break;
            dist++;
        }
        return res;
    }

    public void addNode(TreeNode node, Queue<TreeNode> q) {
        if (node != null && !visited.contains(node)) {
            q.offer(node);
            visited.add(node);
        }
    }

    // O(N)
    public void findParent(TreeNode node, TreeNode p) {
        if (node == null) return;
        parent.put(node, p);
        findParent(node.left, node);
        findParent(node.right, node);
    }


    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t21 = new TreeNode(5);
        TreeNode t22 = new TreeNode(1);
        TreeNode t31 = new TreeNode(6);
        TreeNode t32 = new TreeNode(2);
        TreeNode t33 = new TreeNode(0);
        TreeNode t34 = new TreeNode(8);
        TreeNode t41 = new TreeNode(7);
        TreeNode t42 = new TreeNode(4);

        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        t22.left = t33; t22.right = t34;
        t32.left = t41; t32.right = t42;
        List<Integer> res = new LC863_AllNodesDistanceKInBinaryTree_M().distanceK(t1, t21, 2);
        for (int n: res) {
            System.out.println(n);
        }
    }
}
