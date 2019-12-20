package FullTime.LinkedIn;

public class LowestCommonAncestor {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * Find the lowest common ancestor (LCA) of Binary Tree
     *
     * Recursive
     * time: O(N), space: O(N)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) return null;
        if (root == null || root == p || root == q) return root;

        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l != null && r != null) return root;
        else if (l == null) {
            return r;
        } else {
            return l;
        }
    }


    /**
     * Find the lowest common ancestor (LCA) of BST
     *
     * Iterative
     * time: O(N), space: O(1)
     */
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;

        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
