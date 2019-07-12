package FullTime.FB;

/**
 * Recursion (with lower & upper bound)
 *
 * time: O(N)
 * space: O(N)
 */
public class LC1008_ConstructBinarySearchTreeFromPreorderTraversal_E {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode dfs(int[] preorder, int lo, int hi) {
        if (i == preorder.length) return null;

        int val = preorder[i];
        if (val < lo || val > hi) return null;

        i++;
        TreeNode cur = new TreeNode(val);
        cur.left = dfs(preorder, lo, val);
        cur.right = dfs(preorder, val, hi);
        return cur;
    }

    public static void main(String[] args) {
        int[] preorder = {8,5,1,7,10,12};
        TreeNode t = new LC1008_ConstructBinarySearchTreeFromPreorderTraversal_E().bstFromPreorder(preorder);
        System.out.print(t.val);
    }
}
