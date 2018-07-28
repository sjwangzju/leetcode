package Tree;

/**
 * Created by sjwang on 07/28/2018.
 *
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxLength(root);
        return max;
    }
    public int maxLength(TreeNode root) {
        if(root == null) return 0;
        int left = maxLength(root.left), right = maxLength(root.right);
        max = Math.max(max, left + right);
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
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(3);
        TreeNode t31 = new TreeNode(4);
        TreeNode t32 = new TreeNode(5);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(t1));
    }
}
