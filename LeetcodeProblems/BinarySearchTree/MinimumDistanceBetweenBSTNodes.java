package BinarySearchTree;

/**
 * Created by sjwang on 10/08/2018.
 *
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 *
 * Example :
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 *
 *           4
 *         /   \
 *       2      6
 *      / \
 *     1   3
 *
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 *
 * Note:
 * The size of the BST will be between 2 and 100.
 * The BST is always valid, each node's value is an integer, and each node's value is different.
 */
public class MinimumDistanceBetweenBSTNodes {
    public Integer res = Integer.MAX_VALUE;
    public Integer prev = null;
    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null) {
            res = Math.min(res, root.val - prev);
        }
        prev = root.val;
        inorder(root.right);
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
        TreeNode t1 = new TreeNode(7);
        TreeNode t21 = new TreeNode(3);
        TreeNode t22 = new TreeNode(8);
        TreeNode t31 = new TreeNode(1);
        TreeNode t32 = new TreeNode(5);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        System.out.println(new MinimumDistanceBetweenBSTNodes().minDiffInBST(t1));
    }
}
