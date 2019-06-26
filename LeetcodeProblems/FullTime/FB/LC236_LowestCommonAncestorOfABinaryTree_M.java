package FullTime.FB;

/**
 * time: O(N), N is num of nodes
 * space: O(logN)
 */
public class LC236_LowestCommonAncestorOfABinaryTree_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);

        if (l == null && r == null) {
            return null;
        }
        if (l == null) {
            return r;
        }
        if (r == null) {
            return l;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t21 = new TreeNode(5);
        TreeNode t22 = new TreeNode(1);
        TreeNode t31 = new TreeNode(6);
        TreeNode t32 = new TreeNode(2);
        TreeNode t33 = new TreeNode(0);
        TreeNode t34 = new TreeNode(8);
        t1.left = t21; t1.right = t22;
        t21.left = t31; t21.right = t32; t22.left = t33; t22.right = t34;
        TreeNode res = new LC236_LowestCommonAncestorOfABinaryTree_M().lowestCommonAncestor(t1, t31, t32);
        System.out.print(res.val);
    }
}
