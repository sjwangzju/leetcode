package Recursion;

/**
 * Created by sjwang on 08/04/2018
 *
 * Given a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * Example 1:
 * Input:
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output:
 * 2
 *
 * Example 2:
 * Input:
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output:
 * 2
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class LongestUnivaluePath {
    private int max = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        findLongest(root);
        return max - 1;
    }
    public int findLongest(TreeNode root) {
        if(root == null) return 0;
        int left = findLongest(root.left), right = findLongest(root.right);
        if(root.left != null && root.val != root.left.val) left = 0;
        if(root.right != null && root.val != root.right.val) right = 0;
        max = Math.max(max, 1 + left + right);
        return 1 + Math.max(left, right);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public static void main(String args[]){
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(4);
        TreeNode t22 = new TreeNode(5);
        TreeNode t31 = new TreeNode(4);
        TreeNode t32 = new TreeNode(4);
        TreeNode t33 = new TreeNode(5);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32; t22.right = t33;
        System.out.println(new LongestUnivaluePath().longestUnivaluePath(t1));
    }
}
