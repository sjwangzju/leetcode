package BinarySearchTree;

/**
 * Created by sjwang on 09/02/2018.
 *
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *
 * Note: There are at least two nodes in this BST.
 */
public class MinimumAbsoluteDifferenceInBST {
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(Math.min(Math.min(Math.abs(root.val - getMax(root.left)), Math.abs(getMin(root.right) - root.val)), getMinimumDifference(root.left)), getMinimumDifference(root.right));
    }
    public int getMax(TreeNode node) {
        if(node == null) return Integer.MAX_VALUE;
        if(node.right == null) return node.val;
        return getMax(node.right);
    }
    public int getMin(TreeNode node) {
        if(node == null) return Integer.MAX_VALUE;
        if(node.left == null) return node.val;
        return getMin(node.left);
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
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2; t2.left = t3;
        System.out.println(new MinimumAbsoluteDifferenceInBST().getMinimumDifference(t1));
    }
}
