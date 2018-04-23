package Tree;

/**
 * Created by sjwang on 23/04/2018.
 * Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L).
 * You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.
 *
 * Example 1:
 * Input:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * Output:
 *     1
 *       \
 *        2
 * Example 2:
 * Input:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * Output:
 *       3
 *      /
 *    2
 *   /
 *  1
 */

public class TrimABinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) return null;
        if(root.val > R) return trimBST(root.left, L, R);
        if(root.val < L) return trimBST(root.right, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String args[]) {
        TreeNode t1 = new TreeNode(0);
        t1.left = null;
        t1.right = null;
        TreeNode t2 = new TreeNode(3);
        t2.left = null;
        t2.right = null;
        TreeNode t3 = new TreeNode(2);
        t3.left = null;
        t3.right = t2;
        TreeNode t4 = new TreeNode(1);
        t4.left = t1;
        t4.right = t3;

        new TrimABinarySearchTree().trimBST(t4, 2, 3);
    }
}
