package FullTime.Facebook;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    // time: O(NlogN), space: O(N)
    public class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    Map<TreeNode, Point> map = new HashMap<>();
    Map<Integer, List<TreeNode>> index = new HashMap<>();
    int min = 0, max = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        map.put(root, new Point(0,0));
        dfs(root);

        for (int i = min; i <= max; i++) {
            List<Integer> tmp = new ArrayList<>();
            List<TreeNode> nodes = index.get(i);
            Collections.sort(nodes, (a, b) -> (map.get(a).y == map.get(b).y? a.val - b.val: map.get(a).y - map.get(b).y));
            for (TreeNode n: nodes) {
                tmp.add(n.val);
            }
            res.add(tmp);
        }
        return res;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        int x = map.get(root).x, y = map.get(root).y;
        if (!index.containsKey(x)) {
            index.put(x, new ArrayList<>());
        }
        index.get(x).add(root);
        min = Math.min(min, x);
        max = Math.max(max, x);
        if (root.left != null) {
            map.put(root.left, new Point(x - 1, y + 1));
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, new Point(x + 1, y + 1));
            dfs(root.right);
        }
    }
}
