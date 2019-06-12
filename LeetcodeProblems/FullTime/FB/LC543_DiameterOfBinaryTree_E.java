package FullTime.FB;

/**
 * tree DFS
 *
 * time: O(N), N is num of nodes
 * space: O(1)
 */
public class LC543_DiameterOfBinaryTree_E {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int max = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return max;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int l = dfs(root.left);
        int r = dfs(root.right);

        max = Math.max(max, l + r);
        return 1 + Math.max(l, r);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(4);
        TreeNode t32 = new TreeNode(5);

        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;

        System.out.println(new LC543_DiameterOfBinaryTree_E().diameterOfBinaryTree(t1));
    }
}
