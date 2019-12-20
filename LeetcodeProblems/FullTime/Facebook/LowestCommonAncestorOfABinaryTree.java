package FullTime.Facebook;

public class LowestCommonAncestorOfABinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
        TreeNode(int x) { val = x; }
    }

    // Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
    // Output: 3
    // Explanation: The LCA of nodes 5 and 1 is 3.
    //
    // time: O(N), space: O(N)
    public TreeNode lowestCommonAncestorI(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestorI(root.left, p, q);
        TreeNode right = lowestCommonAncestorI(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;
    }

    // 变形 - only know parent (no left/right)
    //
    // Thoughts:
    // 1. Iterative
    //
    // time: O(N), space: O(1)
    public TreeNode lowestCommonAncestorII(TreeNode p, TreeNode q) {
        int d1 = 0, d2 = 0;
        TreeNode pp = p, qq = q;
        while (pp != null) {
            pp = pp.parent;
            d1++;
        }
        while (qq != null) {
            qq = qq.parent;
            d2++;
        }
        if (d1 > d2) return lowestCommonAncestorII(q, p);
        for (int i = 0; i < d2 - d1; i++) {
            q = q.parent;
        }
        while (!p.equals(q)) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n21 = new TreeNode(1); TreeNode n22 = new TreeNode(3);
        TreeNode n31 = new TreeNode(4); TreeNode n32 = new TreeNode(5);
        n1.left = n21; n1.right = n22;
        n21.left = n31; n21.right = n32;
        n21.parent = n1; n22.parent = n1;
        n31.parent = n21; n32.parent = n21;
        TreeNode res = new LowestCommonAncestorOfABinaryTree().lowestCommonAncestorII(n31, n32);
        System.out.println(res.val);
    }
}
