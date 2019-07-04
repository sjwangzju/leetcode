package FullTime.FB;

import java.util.*;

/**
 * Map<Integer, PriorityQueue<Node>>
 *
 * time: O(NlogN)
 * space: O(N)
 */
public class LC987_VerticalOrderTraversalOfABinaryTree_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class Node {
        int x;
        int y;
        int val;
        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    Map<Integer, PriorityQueue<Node>> map = new HashMap<>();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        Node n = new Node(0, 0, root.val);
        dfs(root, n);

        for (int i = min; i <= max; i++) {
            List<Integer> list = new LinkedList<>();
            PriorityQueue<Node> p = map.get(i);
            while (!p.isEmpty()) {
                list.add(p.poll().val);
            }
            res.add(list);
        }
        return res;
    }

    public void dfs(TreeNode t, Node n) {
        int curX = n.x;
        int curY = n.y;
        min = Math.min(min, curX);
        max = Math.max(max, curX);

        if (!map.containsKey(curX)) {
            map.put(curX, new PriorityQueue<>((a,b) -> (a.y == b.y? a.val - b.val: b.y - a.y)));
        }
        map.get(curX).offer(n);

        if (t.left != null) {
            dfs(t.left, new Node(curX - 1, curY - 1, t.left.val));
        }
        if (t.right != null) {
            dfs(t.right, new Node(curX + 1, curY - 1, t.right.val));
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t21 = new TreeNode(9);
        TreeNode t22 = new TreeNode(20);
        TreeNode t31 = new TreeNode(15);
        TreeNode t32 = new TreeNode(10);
        TreeNode t33 = new TreeNode(7);
        t1.left = t21; t1.right = t22;
        t21.right = t31;
        t22.left = t32; t22.right = t33;

        List<List<Integer>> res = new LC987_VerticalOrderTraversalOfABinaryTree_M().verticalTraversal(t1);
        for (List<Integer> l: res) {
            for (int n: l) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
