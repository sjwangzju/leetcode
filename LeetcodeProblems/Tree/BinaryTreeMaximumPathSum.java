package Tree;

/**
 * Created by sjwang on 07/26/2018.
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 *
 * Example 1:
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: 42
 */
public class BinaryTreeMaximumPathSum {
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        findMax(root);
        return max;
    }
    public int findMax(TreeNode root) {
        if(root == null) return 0;
        int val_L = Math.max(findMax(root.left), 0), val_R = Math.max(findMax(root.right), 0);
        max = Math.max(max, val_L + val_R + root.val);
        return root.val + Math.max(val_L, val_R);
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
        TreeNode t1 = new TreeNode(-10);
        TreeNode t21 = new TreeNode(9);
        TreeNode t22 = new TreeNode(20);
        TreeNode t31 = new TreeNode(15);
        TreeNode t32 = new TreeNode(7);
        t1.left = t21; t1.right = t22;
        t22.left = t31; t22.right = t32;
        System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(t1));
    }
}
