package Tree;

/**
 * Created by sjwang on 07/25/2018.
 *
 * Invert a binary tree.
 *
 * Example:
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 */
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        else{
            TreeNode N = root.left;
            root.left = invertTree(root.right);
            root.right = invertTree(N);
        }
        return root;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String args[]){
        TreeNode t1 = new TreeNode(1);
        TreeNode t21 = new TreeNode(2);
        t1.left = t21;
        System.out.println(new InvertBinaryTree().invertTree(t1));
    }
}