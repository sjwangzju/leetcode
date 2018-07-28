package Tree;

/**
 * Created by sjwang on 07/28/2018.
 *
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * Note: A leaf is a node with no children.
 *
 * Example:
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null && root.val == sum) return true;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
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
        TreeNode t1 = new TreeNode(5);
        TreeNode t21 = new TreeNode(4);
        TreeNode t22 = new TreeNode(8);
        TreeNode t31 = new TreeNode(11);
        TreeNode t32 = new TreeNode(13);
        TreeNode t33 = new TreeNode(4);
        TreeNode t41 = new TreeNode(7);
        TreeNode t42 = new TreeNode(2);
        TreeNode t43 = new TreeNode(1);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t22.left = t32; t22.right = t33;
        t31.left = t41; t31.right = t42; t33.right = t43;
        System.out.println(new PathSum().hasPathSum(t1, 27));
    }
}
