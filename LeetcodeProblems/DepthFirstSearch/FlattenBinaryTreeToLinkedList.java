package DepthFirstSearch;

/**
 * Created by sjwang on 08/02/2018.
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * For example, given the following tree:
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * The flattened tree should look like:
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        if(root == null) return;
        flatten(root.left);
        flatten(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        TreeNode cur = root;
        while(cur.right != null) {
            cur = cur.right;
        }
        cur.right = temp;
        root.left = null;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static void main(String args[]){
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t1.right = t2; t2.left = t3;
        new FlattenBinaryTreeToLinkedList().flatten(t1);
    }
}
