package Tree;

/**
 * Created by sjwang on 23/04/2018.
 * Given two binary trees and imagine that when you put one of them to cover the other,
 * some nodes of the two trees are overlapped while the others are not.
 *
 * You need to merge them into a new binary tree.
 * The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
 * Otherwise, the NOT null node will be used as the node of new tree.
 *
 * Example 1:
 * Input:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * Output:
 * Merged tree:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 * Note: The merging process must start from the root nodes of both trees.
 */

public class MergeTwoBinaryTrees {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null){
            return t2;
        }
        else if(t2 == null){
            return t1;
        }
        else{
            t1.val = t1.val + t2.val;
            t1.left = mergeTrees(t1.left, t2.left);
            t1.right = mergeTrees(t1.right, t2.right);
            return t1;
        }
    }

    public static void main(String args[]){
        TreeNode t11 = new TreeNode(5);
        t11.left = null;
        t11.right = null;
        TreeNode t12 = new TreeNode(3);
        t12.left = t11;
        t12.right = null;
        TreeNode t13 = new TreeNode(2);
        t13.left = null;
        t13.right = null;
        TreeNode t14 = new TreeNode(1);
        t14.left = t12;
        t14.right = t13;

        TreeNode t21 = new TreeNode(4);
        t21.left = null;
        t21.right = null;
        TreeNode t22 = new TreeNode(1);
        t22.left = null;
        t22.right = t21;
        TreeNode t23 = new TreeNode(7);
        t23.left = null;
        t23.right = null;
        TreeNode t24 = new TreeNode(3);
        t24.left = null;
        t24.right = t23;
        TreeNode t25 = new TreeNode(2);
        t25.left = t22;
        t25.right = t24;

        new MergeTwoBinaryTrees().mergeTrees(t14, t25);
    }
}
