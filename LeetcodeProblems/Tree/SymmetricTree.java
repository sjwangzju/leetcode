package Tree;

/**
 * Created by sjwang on 07/26/2018.
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isMirror(root.left, root.right);
    }
    public boolean isMirror(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null) return false;
        return (L.val == R.val) && (isMirror(L.left, R.right)) && (isMirror(L.right, R.left));
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
        TreeNode t22 = new TreeNode(2);
        TreeNode t31 = new TreeNode(3);
        TreeNode t32 = new TreeNode(4);
        TreeNode t33 = new TreeNode(4);
        TreeNode t34 = new TreeNode(3);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32;
        t22.left = t33; t22.right = t34;
        System.out.println(new SymmetricTree().isSymmetric(t1));
    }
}
