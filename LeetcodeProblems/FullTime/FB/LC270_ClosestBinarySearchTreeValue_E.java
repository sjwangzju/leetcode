package FullTime.FB;

/**
 * DFS
 *
 * time: O(N)
 * space: O(logN)
 */
public class LC270_ClosestBinarySearchTreeValue_E {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    double min = Double.MAX_VALUE;
    int res = 0;
    public int closestValue(TreeNode root, double target) {
        dfs(root, target);
        return res;
    }

    public void dfs(TreeNode node, double target) {
        if (node == null) return;
        double cur = node.val - target;
        if (Double.compare(Math.abs(cur), min) < 0) {
            min = Math.abs(cur);
            res = node.val;
        }
        if (cur < 0) {
            dfs(node.right, target);
        } else {
            dfs(node.left, target);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = null;
        TreeNode t22 = new TreeNode(2);
        t1.left = t21;
        t1.right = t22;
        double target = 3.428571;
        System.out.println(new LC270_ClosestBinarySearchTreeValue_E().closestValue(t1, target));
    }
}
