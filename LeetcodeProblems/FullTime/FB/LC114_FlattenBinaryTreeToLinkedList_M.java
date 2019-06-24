package FullTime.FB;

/**
 * Recursive
 *
 * time: O(N)
 * space: (1)
 */
public class LC114_FlattenBinaryTreeToLinkedList_M {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public void flatten(TreeNode root) {
        if (root == null) return;

        flatten(root.left);
        flatten(root.right);

        TreeNode tmp = root.right;
        root.right = root.left;

        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = tmp;
        root.left = null;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(2);
        TreeNode t21 = new TreeNode(3);
        TreeNode t22 = new TreeNode(4);
        t1.left = t21;
        t1.right = t22;
        new LC114_FlattenBinaryTreeToLinkedList_M().flatten(t1);
        System.out.print(t1.right.val);
    }
}
