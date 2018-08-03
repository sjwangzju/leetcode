package DepthFirstSearch;

/**
 * Created by sjwang on 08/03/2018
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 * Input:
 *     2
 *    / \
 *   1   3
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * Output: false
 * Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
 *              is 5 but its right child's value is 4.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValid(TreeNode root, long min, long max) {
        if(root == null) return true;
        if(root.val <= min || root.val >= max) return false;
        return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String args[]){
        TreeNode t1 = new TreeNode(5);
        TreeNode t21 = new TreeNode(1);
        TreeNode t22 = new TreeNode(6);
        TreeNode t31 = new TreeNode(3);
        TreeNode t32 = new TreeNode(8);
        t1.left = t21; t1.right = t22;
        t22.left = t31; t22.right = t32;
        System.out.println(new ValidateBinarySearchTree().isValidBST(t1));
    }
}
