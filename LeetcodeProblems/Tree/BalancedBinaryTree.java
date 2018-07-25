package Tree;

/**
 * Created by sjwang on 07/25/2018.
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example 1:
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(countDepth(root.left) - countDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int countDepth(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(countDepth(root.left), countDepth(root.right));
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
        TreeNode t1 = new TreeNode(4);
        TreeNode t21 = new TreeNode(2);
        TreeNode t22 = new TreeNode(5);
        TreeNode t31 = new TreeNode(1);
        TreeNode t32 = new TreeNode(3);
        TreeNode t41 = new TreeNode(3);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        t31.left = t41;
        System.out.println(new BalancedBinaryTree().isBalanced(t1));
    }
}
