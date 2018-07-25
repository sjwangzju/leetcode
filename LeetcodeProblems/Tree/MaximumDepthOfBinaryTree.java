package Tree;

/**
 * Created by sjwang on 07/25/2018.
 *
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        while(root != null) {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        return 0;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String args[]){
        TreeNode t1 = new TreeNode(3);
        TreeNode t21 = new TreeNode(9);
        TreeNode t22 = new TreeNode(20);
        TreeNode t31 = new TreeNode(15);
        TreeNode t32 = new TreeNode(7);
        t1.left = t21; t1.right = t22;
        t22.left = t31; t22.right = t32;
        System.out.println(new MaximumDepthOfBinaryTree().maxDepth(t1));
    }
}
