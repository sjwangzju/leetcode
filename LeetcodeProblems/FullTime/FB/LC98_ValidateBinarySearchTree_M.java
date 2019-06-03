package FullTime.FB;

/**
 * compare with min & max (Long):
 * max(left subtree) < root.val
 * min(right subtree) > root.val
 *
 * time: O(N), N is the num of nodes
 * space: O(lgN)-O(N), depth of tree
 */
public class LC98_ValidateBinarySearchTree_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean dfs(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(3);
        t1.left = t21;
        t1.right = t22;
        System.out.println(new LC98_ValidateBinarySearchTree_M().isValidBST(t1));
    }
}
