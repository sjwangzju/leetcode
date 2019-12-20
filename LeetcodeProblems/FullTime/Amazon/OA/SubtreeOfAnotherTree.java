package FullTime.Amazon.OA;

public class SubtreeOfAnotherTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) {
            val = x;
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;
        return isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSame(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) return true;
        if (n1 == null || n2 == null) return false;

        return n1.val == n2.val
                && isSame(n1.left, n2.left) && isSame(n1.right, n2.right);
    }
}
